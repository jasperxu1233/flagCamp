package com.flagcamp.goodsreborn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name='item')
public class Item implements Serializable {
    private static final long serialVersionUID=2L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name="seller_id")
    @JsonIgnore
    private Seller seller;

    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ItemImage> itemImages;

    private String itemName;
    private Category category;
    private Condition condtion;
    private double price;
    @Type(type="text")
    private String description;
    private int itemViews;
    private ItemStatus itemStatus;
    private LocalDateTime creatTime;
    private LocalDateTime updateTime;

    public Item() {
    }

    private Item(Builder builder) {
        //this.id = id;
        this.seller = builder.seller;
        this.itemName = builder.itemName;
        this.category = builder.category;
        this.condtion = builder.condtion;
        this.price = builder.price;
        this.description = builder.description;
        this.itemViews = builder.itemViews;
        this.itemStatus = builder.itemStatus;
        this.creatTime = builder.creatTime;
        this.updateTime = builder.updateTime;
        this.itemImages=builder.itemImages;
    }
    public int getId() {
        return id;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public List<ItemImage> getItemImages() {
        return itemImages;
    }

    public void setItemImages(List<ItemImage> itemImages) {
        this.itemImages = itemImages;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Condition getCondtion() {
        return condtion;
    }

    public void setCondtion(Condition condtion) {
        this.condtion = condtion;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getItemViews() {
        return itemViews;
    }

    public void setItemViews(int itemViews) {
        this.itemViews = itemViews;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
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

    public static class Builder {
        private int id;
        private Seller seller;
        private String itemName;
        private Category category;
        private Condition condtion;
        private double price;
        private String description;
        private int itemViews;
        private ItemStatus itemStatus;
        private LocalDateTime creatTime;
        private LocalDateTime updateTime;
        private List<ItemImage> itemImages;
        public Builder() {
        }
        public Builder setSeller(Seller seller) {
            this.seller = seller;
            return this;
        }

        public Builder setItemName(String itemName) {
            this.itemName = itemName;
            return this;
        }

        public Builder setCategory(Category category) {
            this.category = category;
            return this;
        }

        public Builder setCondtion(Condition condtion) {
            this.condtion = condtion;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }
        public Builder setItemImages(List<ItemImage> itemImages) {
            this.itemImages = itemImages;
            return this;
        }
        public Builder setItemViews(int itemViews) {
            this.itemViews = itemViews;
            return this;
        }

        public Builder setItemStatus(ItemStatus itemStatus) {
            this.itemStatus = itemStatus;
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
        public Item build() {
            return new Item(this);
        }
    }
}
