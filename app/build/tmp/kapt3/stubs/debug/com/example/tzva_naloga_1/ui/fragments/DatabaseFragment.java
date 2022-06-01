package com.example.tzva_naloga_1.ui.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0011H\u0016J\b\u0010%\u001a\u00020\u0011H\u0002J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010\'\u001a\u00020\"H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/example/tzva_naloga_1/ui/fragments/DatabaseFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/example/tzva_naloga_1/adapters/ItemListAdapter$OnItemClickListener;", "()V", "itemListAdapter", "Lcom/example/tzva_naloga_1/adapters/ItemListAdapter;", "itemViewModel", "Lcom/example/tzva_naloga_1/database/ItemViewModel;", "getItemViewModel", "()Lcom/example/tzva_naloga_1/database/ItemViewModel;", "itemViewModel$delegate", "Lkotlin/Lazy;", "menu_close", "Landroid/view/Menu;", "menu_delete", "menu_select_all", "close", "", "delete", "onCreateOptionsMenu", "menu", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "item", "Lcom/example/tzva_naloga_1/database/entities/ItemEntity;", "onOptionsItemSelected", "", "Landroid/view/MenuItem;", "onPause", "selectAll", "showDeleteMenu", "show", "app_debug"})
public final class DatabaseFragment extends androidx.fragment.app.Fragment implements com.example.tzva_naloga_1.adapters.ItemListAdapter.OnItemClickListener {
    private final kotlin.Lazy itemViewModel$delegate = null;
    private com.example.tzva_naloga_1.adapters.ItemListAdapter itemListAdapter;
    private android.view.Menu menu_delete;
    private android.view.Menu menu_select_all;
    private android.view.Menu menu_close;
    
    public DatabaseFragment() {
        super();
    }
    
    private final com.example.tzva_naloga_1.database.ItemViewModel getItemViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onItemClick(@org.jetbrains.annotations.NotNull()
    com.example.tzva_naloga_1.database.entities.ItemEntity item) {
    }
    
    private final void showDeleteMenu(boolean show) {
    }
    
    @java.lang.Override()
    public void onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu, @org.jetbrains.annotations.NotNull()
    android.view.MenuInflater inflater) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void delete() {
    }
    
    private final void selectAll() {
    }
    
    private final void close() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
}