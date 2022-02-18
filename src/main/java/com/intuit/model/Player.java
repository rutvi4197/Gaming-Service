package com.intuit.model;

import java.util.random.RandomGenerator;

import lombok.Data;

@Data
public class Player {
  private long id;
  private String name;
  private String gender;
  private int age;

  public Player(String name, String gender, int age) {
    this.id= RandomGenerator.getDefault().nextLong();
    this.name = name;
    this.gender = gender;
    this.age = age;
  }
  public Player(long id,String name, String gender, int age) {
    this.id= id;
    this.name = name;
    this.gender = gender;
    this.age = age;
  }
}
