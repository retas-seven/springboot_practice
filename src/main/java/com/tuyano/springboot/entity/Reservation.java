package com.tuyano.springboot.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 
 */
@Entity
@Table(name = "reservation")
public class Reservation {

    /**  */
    @Id
    @Column(name = "ID")
    public String id;

    /**  */
    @Column(name = "NAME")
    public String name;
}