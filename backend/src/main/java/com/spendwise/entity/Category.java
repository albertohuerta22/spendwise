package com.spendwise.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    private String name;
    private String description;

  public Category(){}

  public Category(Long category_id, String name, String description) {
    this.category_id = category_id;
    this.name = name;
    this.description = description;
  }

  public Long getCategoryId(){
    return category_id;
  }

  public void setCategoryId(Long category_id){
    this.category_id = category_id;
  }

  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getDescription(){
    return description;
  }

  public void setDescription(String description){
    this.description = description;
  }
}
