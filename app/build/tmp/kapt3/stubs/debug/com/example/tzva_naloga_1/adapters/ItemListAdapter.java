package com.example.tzva_naloga_1.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002%&BE\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0017\u001a\u00020\u0010H\u0007J\u0006\u0010\u0018\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u000fJ\u001c\u0010\u0019\u001a\u00020\u00102\n\u0010\u001a\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J\u001c\u0010\u001c\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0015H\u0016J\b\u0010 \u001a\u00020\u0010H\u0007J\b\u0010!\u001a\u00020\u0010H\u0002J\b\u0010\"\u001a\u00020\u0010H\u0007J$\u0010#\u001a\u00020\u00102\n\u0010\u001a\u001a\u00060\u0003R\u00020\u00002\u0006\u0010$\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0015H\u0002R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/example/tzva_naloga_1/adapters/ItemListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/example/tzva_naloga_1/database/entities/ItemEntity;", "Lcom/example/tzva_naloga_1/adapters/ItemListAdapter$ItemViewHolder;", "onItemClickListener", "Lcom/example/tzva_naloga_1/adapters/ItemListAdapter$OnItemClickListener;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "dataset", "Landroidx/lifecycle/LiveData;", "", "itemViewModel", "Lcom/example/tzva_naloga_1/database/ItemViewModel;", "showMenuDelete", "Lkotlin/Function1;", "", "", "(Lcom/example/tzva_naloga_1/adapters/ItemListAdapter$OnItemClickListener;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/LiveData;Lcom/example/tzva_naloga_1/database/ItemViewModel;Lkotlin/jvm/functions/Function1;)V", "isEnable", "isSelectAll", "itemSelectedList", "", "itemsList", "close", "deleteSelectedItem", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "resetAdapter", "resetItemsList", "selectAll", "selectItem", "item", "ItemViewHolder", "OnItemClickListener", "app_debug"})
public final class ItemListAdapter extends androidx.recyclerview.widget.ListAdapter<com.example.tzva_naloga_1.database.entities.ItemEntity, com.example.tzva_naloga_1.adapters.ItemListAdapter.ItemViewHolder> {
    private final com.example.tzva_naloga_1.adapters.ItemListAdapter.OnItemClickListener onItemClickListener = null;
    private final androidx.lifecycle.LifecycleOwner owner = null;
    private androidx.lifecycle.LiveData<java.util.List<com.example.tzva_naloga_1.database.entities.ItemEntity>> dataset;
    private final com.example.tzva_naloga_1.database.ItemViewModel itemViewModel = null;
    private final kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> showMenuDelete = null;
    private boolean isEnable = false;
    private boolean isSelectAll = false;
    private java.util.List<java.lang.Integer> itemSelectedList;
    private java.util.List<com.example.tzva_naloga_1.database.entities.ItemEntity> itemsList;
    
    public ItemListAdapter(@org.jetbrains.annotations.NotNull()
    com.example.tzva_naloga_1.adapters.ItemListAdapter.OnItemClickListener onItemClickListener, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner owner, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<java.util.List<com.example.tzva_naloga_1.database.entities.ItemEntity>> dataset, @org.jetbrains.annotations.NotNull()
    com.example.tzva_naloga_1.database.ItemViewModel itemViewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> showMenuDelete) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.tzva_naloga_1.adapters.ItemListAdapter.ItemViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.tzva_naloga_1.adapters.ItemListAdapter.ItemViewHolder holder, int position) {
    }
    
    private final void selectItem(com.example.tzva_naloga_1.adapters.ItemListAdapter.ItemViewHolder holder, com.example.tzva_naloga_1.database.entities.ItemEntity item, int position) {
    }
    
    public final void deleteSelectedItem() {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void selectAll() {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void close() {
    }
    
    public final boolean isSelectAll() {
        return false;
    }
    
    private final void resetItemsList() {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void resetAdapter() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/example/tzva_naloga_1/adapters/ItemListAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/example/tzva_naloga_1/adapters/ItemListAdapter;Landroid/view/View;)V", "rv_cb", "Landroid/widget/ImageView;", "getRv_cb", "()Landroid/widget/ImageView;", "rv_tv_name", "Landroid/widget/TextView;", "getRv_tv_name", "()Landroid/widget/TextView;", "rv_tv_stock", "getRv_tv_stock", "app_debug"})
    public final class ItemViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView rv_tv_name = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView rv_tv_stock = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView rv_cb = null;
        
        public ItemViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getRv_tv_name() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getRv_tv_stock() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getRv_cb() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/tzva_naloga_1/adapters/ItemListAdapter$OnItemClickListener;", "", "onItemClick", "", "item", "Lcom/example/tzva_naloga_1/database/entities/ItemEntity;", "app_debug"})
    public static abstract interface OnItemClickListener {
        
        public abstract void onItemClick(@org.jetbrains.annotations.NotNull()
        com.example.tzva_naloga_1.database.entities.ItemEntity item);
    }
}