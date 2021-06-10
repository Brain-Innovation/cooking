package com.ewise.cooking.beans;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private double price;
  private LocalDate priceDate;
  private String location;
  private String store;

  public Item() {
    super();
  }

  public Item(String name, double price, LocalDate priceDate, String location, String store) {
    this();
    this.name = name;
    this.price = price;
    this.priceDate = priceDate;
    this.location = location;
    this.store = store;
  }

  public Item(Long id, String name, double price, LocalDate priceDate, String location,
      String store) {
    this(name, price, priceDate, location, store);
    this.id = id;
  }

  @Override
  public String toString() {
    return "Item{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", price=" + price +
        ", priceDate=" + priceDate +
        ", location='" + location + '\'' +
        ", store='" + store + '\'' +
        '}';
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public LocalDate getPriceDate() {
    return priceDate;
  }

  public void setPriceDate(LocalDate priceDate) {
    this.priceDate = priceDate;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getStore() {
    return store;
  }

  public void setStore(String store) {
    this.store = store;
  }
}
