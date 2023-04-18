package com.instanceofcake.service;

import com.instanceofcake.domain.Inventory;
import com.instanceofcake.domain.ProductOption;

import java.util.concurrent.CompletableFuture;

import static com.instanceofcake.util.CommonUtil.delay;

public class InventoryService {
    public Inventory addInventory(ProductOption productOption) {
        delay(500);
        return new Inventory(2);

    }

    public CompletableFuture<Inventory> addInventory_CF(ProductOption productOption) {

        return CompletableFuture.supplyAsync(() -> {
            delay(500);
            return new Inventory(2);
        });

    }
}
