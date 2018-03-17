package com.tuyano.springboot.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity
@Table(name="reservation")
public class Reservation {
  @Id
  public String id;
  public String name;
}