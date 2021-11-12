package com.flagcamp.goodsreborn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="item_image")
public class ItemImage implements Serializable {
    private static final long serialVersionUID = 3L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String url;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    @JsonIgnore
    private Item item;

    private LocalDateTime creatTime;
    private LocalDateTime updateTime;

    public ItemImage() {
    }

    private ItemImage(Builder builder) {
        this.url = builder.url;
        this.item = builder.item;
        this.creatTime = builder.creatTime;
        this.updateTime = builder.updateTime;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
        private String url;
        private Item item;
        private LocalDateTime creatTime;
        private LocalDateTime updateTime;

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setItem(Item item) {
            this.item = item;
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

        public ItemImage build() {
            return new ItemImage(this);
        }
    }
}
