
package com.example.marvelcharacters.model.pojo.hq;

import java.util.List;
import com.google.gson.annotations.Expose;

public class Stories {

    @Expose
    private Long available;
    @Expose
    private String collectionURI;
    @Expose
    private List<Item> items;
    @Expose
    private Long returned;

    public Long getAvailable() {
        return available;
    }

    public void setAvailable(Long available) {
        this.available = available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Long getReturned() {
        return returned;
    }

    public void setReturned(Long returned) {
        this.returned = returned;
    }

}