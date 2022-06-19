package com.example.demo.model;

import lombok.Data;

import java.util.HashMap;

public class InventoryOuter {

    public static class Inventory extends HashMap<String, InventoryItem> { }
    @Data
    public static class InventoryItem {
        private final String productName;
        private int qty;
        private float totalPrice;
        private String productBarcodes;

        public InventoryItem(String productName, float totalPrice, int qty) {
            this.productName = productName;
            this.totalPrice = totalPrice;
            this.qty = qty;
        }
}
}
