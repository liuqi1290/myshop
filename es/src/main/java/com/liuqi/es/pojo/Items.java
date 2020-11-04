package com.liuqi.es.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "ik", type = "_doc")
public class Items {


    @Id
    @Field(store = true,type= FieldType.Text,index = false)
    private Long itemId;
    @Field(store = true,type= FieldType.Text,index = true)
    private String itemName;
    @Field(store = true,type= FieldType.Integer,index = false)
    private Integer sellCounts;
    @Field(store = true,type= FieldType.Text,index = false)
    private String imgUrl;
    @Field(store = true ,type= FieldType.Integer,index = false)
    private Integer price;


    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getSellCounts() {
        return sellCounts;
    }

    public void setSellCounts(Integer sellCounts) {
        this.sellCounts = sellCounts;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", sellCounts=" + sellCounts +
                ", imgUrl='" + imgUrl + '\'' +
                ", price=" + price +
                '}';
    }
}
