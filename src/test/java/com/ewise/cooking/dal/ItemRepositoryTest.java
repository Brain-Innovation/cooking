package com.ewise.cooking.dal;

import static org.assertj.core.api.Assertions.assertThat;

import com.ewise.cooking.beans.Item;
import java.time.LocalDate;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles({"test"})
@EnableAutoConfiguration
@SpringBootTest
public class ItemRepositoryTest {

  @Autowired
  protected ItemRepository repo;

  @Autowired
  private ItemDao dao;

  @Before
  public void before() {
    repo.deleteAll();
  }

  @Test
  public void can_create_and_load_item_by_name_test() {
    String name = "Rice";

    Item created = new Item("Rice", 12.5, LocalDate.now(), "B15 1TR", "Morrisons");

    Item expected = dao.createItem(created);

    List<Item> actualItems = dao.getItemsByName(name);

    assertThat(actualItems).hasSize(1);

    Item actualItem = actualItems.get(0);
    assertThat(actualItem.getName()).isEqualTo(expected.getName());
    assertThat(actualItem.getPrice()).isEqualTo(expected.getPrice());
    assertThat(actualItem.getPriceDate()).isEqualTo(expected.getPriceDate());
    assertThat(actualItem.getLocation()).isEqualTo(expected.getLocation());
    assertThat(actualItem.getStore()).isEqualTo(expected.getStore());
  }

  @Test
  public void can_create_and_load_all_items_test() {
    Item create1 = new Item("Rice", 12.5, LocalDate.now(), "B15 1TR", "Morrisons");
    Item create2 = new Item("Biscuit", 1.25, LocalDate.now(), "B15 1TR", "Morrisons");

    Item expected1 = dao.createItem(create1);
    Item expected2 = dao.createItem(create2);

    List<Item> actualItems = dao.getAllItems();

    assertThat(actualItems).hasSize(2);

    Item actualItem1 = actualItems.get(0);
    assertThat(actualItem1.getName()).isEqualTo(expected1.getName());
    assertThat(actualItem1.getPrice()).isEqualTo(expected1.getPrice());
    assertThat(actualItem1.getPriceDate()).isEqualTo(expected1.getPriceDate());
    assertThat(actualItem1.getLocation()).isEqualTo(expected1.getLocation());
    assertThat(actualItem1.getStore()).isEqualTo(expected1.getStore());

    Item actualItem2 = actualItems.get(1);
    assertThat(actualItem2.getName()).isEqualTo(expected2.getName());
    assertThat(actualItem2.getPrice()).isEqualTo(expected2.getPrice());
    assertThat(actualItem2.getPriceDate()).isEqualTo(expected2.getPriceDate());
    assertThat(actualItem2.getLocation()).isEqualTo(expected2.getLocation());
    assertThat(actualItem2.getStore()).isEqualTo(expected2.getStore());
  }
}
