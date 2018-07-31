

package com.softaai.agrostarassigment.model;


import com.softaai.agrostarassigment.enums.ItemType;

public interface LazyLoading {
    ItemType getItemType();
    void setItemType(ItemType itemType);
}
