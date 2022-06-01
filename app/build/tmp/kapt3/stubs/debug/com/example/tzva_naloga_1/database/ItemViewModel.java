package com.example.tzva_naloga_1.database;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\bJ\u0014\u0010\u0017\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0019R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/tzva_naloga_1/database/ItemViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/tzva_naloga_1/database/ItemRepository;", "(Lcom/example/tzva_naloga_1/database/ItemRepository;)V", "allFavoriteItems", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/tzva_naloga_1/database/entities/ItemEntity;", "getAllFavoriteItems", "()Landroidx/lifecycle/LiveData;", "allItems", "getAllItems", "allShoppingItems", "getAllShoppingItems", "deleteAllItems", "Lkotlinx/coroutines/Job;", "deleteAllItemsSelected", "deleteGarbage", "deleteItem", "item", "insertItem", "updateItem", "updateItems", "items", "", "app_debug"})
public final class ItemViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.tzva_naloga_1.database.ItemRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.tzva_naloga_1.database.entities.ItemEntity>> allItems = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.tzva_naloga_1.database.entities.ItemEntity>> allFavoriteItems = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.tzva_naloga_1.database.entities.ItemEntity>> allShoppingItems = null;
    
    public ItemViewModel(@org.jetbrains.annotations.NotNull()
    com.example.tzva_naloga_1.database.ItemRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.tzva_naloga_1.database.entities.ItemEntity>> getAllItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.tzva_naloga_1.database.entities.ItemEntity>> getAllFavoriteItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.tzva_naloga_1.database.entities.ItemEntity>> getAllShoppingItems() {
        return null;
    }
    
    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insertItem(@org.jetbrains.annotations.NotNull()
    com.example.tzva_naloga_1.database.entities.ItemEntity item) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job updateItem(@org.jetbrains.annotations.NotNull()
    com.example.tzva_naloga_1.database.entities.ItemEntity item) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job updateItems(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.tzva_naloga_1.database.entities.ItemEntity> items) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteAllItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteItem(@org.jetbrains.annotations.NotNull()
    com.example.tzva_naloga_1.database.entities.ItemEntity item) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteAllItemsSelected() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteGarbage() {
        return null;
    }
}