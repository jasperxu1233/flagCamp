package com.flagcamp.goodsreborn.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name="seller")
public class Seller implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sellerId;

    private String username;
    private String password;
    private String phone;
    private String address;
    private LocalDateTime creatTime;
    private LocalDateTime updateTime;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Seller() {
    }

    private Seller(Builder builder) {
        //this.sellerId = builder.sellerId;
        this.username = builder.username;
        this.password = builder.password;
        this.phone = builder.phone;
        this.address = builder.address;
        this.creatTime = builder.creatTime;
        this.updateTime = builder.updateTime;
        this.items=builder.items;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(LocalDateTime creatTime) {
        this.creatTime = creatTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public static class Builder{
        private int sellerId;

        private String username;
        private String password;
        private String phone;
        private String address;
        private LocalDateTime creatTime;
        private LocalDateTime updateTime;

        private List<Item> items;

        public Builder() {
        }

        public Builder setSellerId(int sellerId) {
            this.sellerId = sellerId;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setCreatTime(LocalDateTime creatTime) {
            this.creatTime = creatTime;
            return this;
        }

        public Builder setUpdateTime(LocalDateTime updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public Builder setItems(List<Item> items) {
            this.items = items;
            return this;
        }

        public Seller build() {
            return new Seller(this);
        }

    }
}
