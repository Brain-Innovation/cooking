package com.ewise.cooking.dal;

import com.ewise.cooking.beans.Item;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDao {

  @Autowired
  private ItemRepository repo;

  public Item createItem(Item item) {
    return repo.save(item);
  }

  public List<Item> getItemsByName(String name) {
    return repo.findByName(name);
  }

  public List<Item> getAllItems() {
    return StreamSupport.stream(repo.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }
}
