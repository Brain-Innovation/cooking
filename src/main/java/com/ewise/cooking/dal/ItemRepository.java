package com.ewise.cooking.dal;

import com.ewise.cooking.beans.Item;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {

  List<Item> findByName(String name);

  Item findById(long id);
}
