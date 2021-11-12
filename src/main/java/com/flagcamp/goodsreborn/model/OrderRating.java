package com.flagcamp.goodsreborn.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="order_rating")
public class OrderRating implements Serializable {
    private static final long serialVersionUID = 4L;
}
