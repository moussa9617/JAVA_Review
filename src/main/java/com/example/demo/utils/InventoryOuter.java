package com.example.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

public class InventoryOuter {

    public static class Inventory extends HashMap<String, InventoryItem> { }
    @Data
    public static class InventoryItem {
        private final String pName;
        private int qty;
        private float totalPrice;
        private String productBarcodes;

        public InventoryItem(String pName, float totalPrice, int qty) {
            this.pName = pName;
            this.totalPrice = totalPrice;
            this.qty = qty;
        }
}
}
