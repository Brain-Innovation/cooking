package com.ewise.cooking.service;

import com.ewise.cooking.beans.Item;
import com.ewise.cooking.dal.ItemDao;
import com.ewise.cooking.rest.RestItem;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(rollbackFor = {Exception.class})
public class ItemService {

  @Autowired
  private ItemDao itemDao;

  public RestItem createItem(RestItem restItem) {
    Item item = convertToBean(restItem);

    return convertToRest(itemDao.createItem(item));
  }

  public List<RestItem> getItems() {
    return itemDao.getAllItems().stream().map(this::convertToRest).collect(Collectors.toList());
  }


  private Item convertToBean(RestItem restItem) {
    return new Item(restItem.getName(), restItem.getPrice(), restItem.getPriceDate(),
        restItem.getLocation(), restItem.getStore());
  }

  private RestItem convertToRest(Item item) {
    return new RestItem(item.getId(), item.getName(), item.getPrice(), item.getPriceDate(),
        item.getLocation(), item.getStore());
  }
}
