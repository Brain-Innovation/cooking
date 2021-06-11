package com.ewise.cooking.rest;


import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public class RestItem {

  private Long id;
  private String name;
  private double price;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate priceDate;
  private String location;
  private String store;

  public RestItem() {
    super();
  }

  public RestItem(String name, double price, LocalDate priceDate, String location,
      String store) {
    this();
    this.name = name;
    this.price = price;
    this.priceDate = priceDate;
    this.location = location;
    this.store = store;
  }

  public RestItem(Long id, String name, double price, LocalDate priceDate, String location,
      String store) {
    this(name, price, priceDate, location, store);
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
