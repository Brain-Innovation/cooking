package com.ewise.cooking.controller;

import com.ewise.cooking.rest.RestItem;
import com.ewise.cooking.service.ItemService;
import java.time.LocalDate;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

  private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

  @Autowired
  private ItemService itemService;

  @GetMapping("v0/items/{name}")
  public RestItem getItem(@PathVariable String name) {
    logger.info("BEGIN getItem {}", name);

    // test
    return new RestItem(111L, name, 20, LocalDate.of(2021, 2, 12), "Birmingham", "Tesco");
  }

  @GetMapping("v0/items/{name}")
  public List<RestItem> getItems() {
    logger.info("BEGIN getItems");

    return itemService.getItems();
  }
}
