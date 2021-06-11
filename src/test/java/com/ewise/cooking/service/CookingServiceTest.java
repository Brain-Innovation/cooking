package com.ewise.cooking.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.ewise.cooking.beans.Item;
import com.ewise.cooking.dal.ItemDao;
import com.ewise.cooking.rest.RestItem;
import java.time.LocalDate;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles({"test"})
@EnableAutoConfiguration
@SpringBootTest
public class CookingServiceTest {

  @Rule
  public MockitoRule rule = MockitoJUnit.rule();

  @MockBean
  private ItemDao itemDao;

  @Autowired
  private CookingService service;

  @Test
  public void canConvertToDal() {
    Long id = 101L;
    RestItem restItem = new RestItem("Rice", 12.5, LocalDate.now(), "B15 1TR", "Morrisons");

    Item returnItem = new Item(id, "Rice", 12.5, LocalDate.now(), "B15 1TR", "Morrisons");

    when(itemDao.createItem(any())).thenReturn(returnItem);

    RestItem actual = service.createItem(restItem);

    assertThat(actual.getId()).isEqualTo(id);
    assertThat(actual.getName()).isEqualTo(restItem.getName());
    assertThat(actual.getPrice()).isEqualTo(restItem.getPrice());
    assertThat(actual.getPriceDate()).isEqualTo(restItem.getPriceDate());
    assertThat(actual.getLocation()).isEqualTo(restItem.getLocation());
    assertThat(actual.getStore()).isEqualTo(restItem.getStore());
  }
}
