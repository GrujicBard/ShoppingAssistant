package com.example.tzva_naloga_1.database;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/example/tzva_naloga_1/database/ItemsApplication;", "Landroid/app/Application;", "()V", "applicationScope", "Lkotlinx/coroutines/CoroutineScope;", "database", "Lcom/example/tzva_naloga_1/database/ItemRoomDatabase;", "getDatabase", "()Lcom/example/tzva_naloga_1/database/ItemRoomDatabase;", "database$delegate", "Lkotlin/Lazy;", "repository", "Lcom/example/tzva_naloga_1/database/ItemRepository;", "getRepository", "()Lcom/example/tzva_naloga_1/database/ItemRepository;", "repository$delegate", "app_debug"})
public final class ItemsApplication extends android.app.Application {
    private final kotlinx.coroutines.CoroutineScope applicationScope = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy database$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy repository$delegate = null;
    
    public ItemsApplication() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.tzva_naloga_1.database.ItemRoomDatabase getDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.tzva_naloga_1.database.ItemRepository getRepository() {
        return null;
    }
}