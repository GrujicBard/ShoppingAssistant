package com.example.tzva_naloga_1.ui.fragments;

import java.lang.System;

@kotlin.Suppress(names = {"DEPRECATION"})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0002J\b\u0010@\u001a\u00020=H\u0002J\b\u0010A\u001a\u00020=H\u0002J&\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020\u0018X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001a\u0010#\u001a\u00020\u0018X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\u001a\u0010&\u001a\u00020\u0018X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u001a\"\u0004\b(\u0010\u001cR\u001a\u0010)\u001a\u00020\u0018X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b.\u0010/R\u000e\u00102\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u00103\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u00105\"\u0004\b:\u00107R\u000e\u0010;\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006J"}, d2 = {"Lcom/example/tzva_naloga_1/ui/fragments/InputFragment;", "Landroidx/fragment/app/Fragment;", "()V", "barcodeLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/journeyapps/barcodescanner/ScanOptions;", "kotlin.jvm.PlatformType", "database", "Lcom/google/firebase/database/DatabaseReference;", "dd_cat", "Landroid/widget/AutoCompleteTextView;", "getDd_cat", "()Landroid/widget/AutoCompleteTextView;", "setDd_cat", "(Landroid/widget/AutoCompleteTextView;)V", "dd_shop", "getDd_shop", "setDd_shop", "dd_storage", "getDd_storage", "setDd_storage", "ean", "", "et_EAN", "Landroid/widget/EditText;", "getEt_EAN", "()Landroid/widget/EditText;", "setEt_EAN", "(Landroid/widget/EditText;)V", "et_description", "getEt_description", "setEt_description", "et_item_name", "getEt_item_name", "setEt_item_name", "et_price", "getEt_price", "setEt_price", "et_quantity", "getEt_quantity", "setEt_quantity", "et_stock", "getEt_stock", "setEt_stock", "itemViewModel", "Lcom/example/tzva_naloga_1/database/ItemViewModel;", "getItemViewModel", "()Lcom/example/tzva_naloga_1/database/ItemViewModel;", "itemViewModel$delegate", "Lkotlin/Lazy;", "market", "success", "getSuccess", "()Ljava/lang/String;", "setSuccess", "(Ljava/lang/String;)V", "unSuccess", "getUnSuccess", "setUnSuccess", "url", "fetchProductFromMarket", "", "jsonArray", "Lorg/json/JSONArray;", "getDataFromFirebase", "insertNewItem", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class InputFragment extends androidx.fragment.app.Fragment {
    private final kotlin.Lazy itemViewModel$delegate = null;
    private com.google.firebase.database.DatabaseReference database;
    private java.lang.String market = "";
    private java.lang.String ean = "";
    private java.lang.String url = "";
    public android.widget.EditText et_EAN;
    public android.widget.EditText et_item_name;
    public android.widget.EditText et_price;
    public android.widget.EditText et_description;
    public android.widget.EditText et_stock;
    public android.widget.EditText et_quantity;
    public android.widget.AutoCompleteTextView dd_storage;
    public android.widget.AutoCompleteTextView dd_shop;
    public android.widget.AutoCompleteTextView dd_cat;
    public java.lang.String success;
    public java.lang.String unSuccess;
    private final androidx.activity.result.ActivityResultLauncher<com.journeyapps.barcodescanner.ScanOptions> barcodeLauncher = null;
    
    public InputFragment() {
        super();
    }
    
    private final com.example.tzva_naloga_1.database.ItemViewModel getItemViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getEt_EAN() {
        return null;
    }
    
    public final void setEt_EAN(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getEt_item_name() {
        return null;
    }
    
    public final void setEt_item_name(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getEt_price() {
        return null;
    }
    
    public final void setEt_price(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getEt_description() {
        return null;
    }
    
    public final void setEt_description(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getEt_stock() {
        return null;
    }
    
    public final void setEt_stock(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getEt_quantity() {
        return null;
    }
    
    public final void setEt_quantity(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.AutoCompleteTextView getDd_storage() {
        return null;
    }
    
    public final void setDd_storage(@org.jetbrains.annotations.NotNull()
    android.widget.AutoCompleteTextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.AutoCompleteTextView getDd_shop() {
        return null;
    }
    
    public final void setDd_shop(@org.jetbrains.annotations.NotNull()
    android.widget.AutoCompleteTextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.AutoCompleteTextView getDd_cat() {
        return null;
    }
    
    public final void setDd_cat(@org.jetbrains.annotations.NotNull()
    android.widget.AutoCompleteTextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSuccess() {
        return null;
    }
    
    public final void setSuccess(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUnSuccess() {
        return null;
    }
    
    public final void setUnSuccess(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void insertNewItem() {
    }
    
    private final void getDataFromFirebase() {
    }
    
    private final void fetchProductFromMarket(org.json.JSONArray jsonArray) {
    }
}