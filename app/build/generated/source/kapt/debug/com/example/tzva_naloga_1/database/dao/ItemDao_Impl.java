package com.example.tzva_naloga_1.database.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.tzva_naloga_1.database.entities.ItemEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ItemDao_Impl implements ItemDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ItemEntity> __insertionAdapterOfItemEntity;

  private final EntityDeletionOrUpdateAdapter<ItemEntity> __deletionAdapterOfItemEntity;

  private final EntityDeletionOrUpdateAdapter<ItemEntity> __updateAdapterOfItemEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllItems;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllSelected;

  private final SharedSQLiteStatement __preparedStmtOfDeleteGarbage;

  public ItemDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfItemEntity = new EntityInsertionAdapter<ItemEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `item` (`itemId`,`EAN`,`name`,`price`,`quantity`,`url`,`stock`,`shop`,`storage`,`category`,`isFavoriteItem`,`isOnShoppingList`,`description`,`selected`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemEntity value) {
        stmt.bindLong(1, value.getItemId());
        if (value.getEAN() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEAN());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        stmt.bindDouble(4, value.getPrice());
        if (value.getQuantity() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getQuantity());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getUrl());
        }
        stmt.bindLong(7, value.getStock());
        if (value.getShop() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getShop());
        }
        if (value.getStorage() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getStorage());
        }
        if (value.getCategory() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getCategory());
        }
        final int _tmp = value.isFavoriteItem() ? 1 : 0;
        stmt.bindLong(11, _tmp);
        final int _tmp_1 = value.isOnShoppingList() ? 1 : 0;
        stmt.bindLong(12, _tmp_1);
        if (value.getDescription() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getDescription());
        }
        final int _tmp_2 = value.getSelected() ? 1 : 0;
        stmt.bindLong(14, _tmp_2);
      }
    };
    this.__deletionAdapterOfItemEntity = new EntityDeletionOrUpdateAdapter<ItemEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `item` WHERE `itemId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemEntity value) {
        stmt.bindLong(1, value.getItemId());
      }
    };
    this.__updateAdapterOfItemEntity = new EntityDeletionOrUpdateAdapter<ItemEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `item` SET `itemId` = ?,`EAN` = ?,`name` = ?,`price` = ?,`quantity` = ?,`url` = ?,`stock` = ?,`shop` = ?,`storage` = ?,`category` = ?,`isFavoriteItem` = ?,`isOnShoppingList` = ?,`description` = ?,`selected` = ? WHERE `itemId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ItemEntity value) {
        stmt.bindLong(1, value.getItemId());
        if (value.getEAN() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEAN());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        stmt.bindDouble(4, value.getPrice());
        if (value.getQuantity() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getQuantity());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getUrl());
        }
        stmt.bindLong(7, value.getStock());
        if (value.getShop() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getShop());
        }
        if (value.getStorage() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getStorage());
        }
        if (value.getCategory() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getCategory());
        }
        final int _tmp = value.isFavoriteItem() ? 1 : 0;
        stmt.bindLong(11, _tmp);
        final int _tmp_1 = value.isOnShoppingList() ? 1 : 0;
        stmt.bindLong(12, _tmp_1);
        if (value.getDescription() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getDescription());
        }
        final int _tmp_2 = value.getSelected() ? 1 : 0;
        stmt.bindLong(14, _tmp_2);
        stmt.bindLong(15, value.getItemId());
      }
    };
    this.__preparedStmtOfDeleteAllItems = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM item";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllSelected = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM item WHERE selected = 1";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteGarbage = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM item WHERE stock = 0 AND isFavoriteItem = 0 AND isOnShoppingList = 0";
        return _query;
      }
    };
  }

  @Override
  public Object insertItem(final ItemEntity item, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfItemEntity.insert(item);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteItem(final ItemEntity item, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfItemEntity.handle(item);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateItem(final ItemEntity item, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfItemEntity.handle(item);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateItems(final List<ItemEntity> items,
      final Continuation<? super Integer> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total +=__updateAdapterOfItemEntity.handleMultiple(items);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteAllItems(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllItems.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAllItems.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteAllSelected(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllSelected.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAllSelected.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteGarbage(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteGarbage.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteGarbage.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<ItemEntity>> getAllItems() {
    final String _sql = "SELECT * FROM item WHERE stock > 0 ORDER BY name DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"item"}, new Callable<List<ItemEntity>>() {
      @Override
      public List<ItemEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "itemId");
          final int _cursorIndexOfEAN = CursorUtil.getColumnIndexOrThrow(_cursor, "EAN");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfStock = CursorUtil.getColumnIndexOrThrow(_cursor, "stock");
          final int _cursorIndexOfShop = CursorUtil.getColumnIndexOrThrow(_cursor, "shop");
          final int _cursorIndexOfStorage = CursorUtil.getColumnIndexOrThrow(_cursor, "storage");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfIsFavoriteItem = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavoriteItem");
          final int _cursorIndexOfIsOnShoppingList = CursorUtil.getColumnIndexOrThrow(_cursor, "isOnShoppingList");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfSelected = CursorUtil.getColumnIndexOrThrow(_cursor, "selected");
          final List<ItemEntity> _result = new ArrayList<ItemEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ItemEntity _item;
            final long _tmpItemId;
            _tmpItemId = _cursor.getLong(_cursorIndexOfItemId);
            final String _tmpEAN;
            if (_cursor.isNull(_cursorIndexOfEAN)) {
              _tmpEAN = null;
            } else {
              _tmpEAN = _cursor.getString(_cursorIndexOfEAN);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpPrice;
            _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            final String _tmpQuantity;
            if (_cursor.isNull(_cursorIndexOfQuantity)) {
              _tmpQuantity = null;
            } else {
              _tmpQuantity = _cursor.getString(_cursorIndexOfQuantity);
            }
            final String _tmpUrl;
            if (_cursor.isNull(_cursorIndexOfUrl)) {
              _tmpUrl = null;
            } else {
              _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            }
            final int _tmpStock;
            _tmpStock = _cursor.getInt(_cursorIndexOfStock);
            final String _tmpShop;
            if (_cursor.isNull(_cursorIndexOfShop)) {
              _tmpShop = null;
            } else {
              _tmpShop = _cursor.getString(_cursorIndexOfShop);
            }
            final String _tmpStorage;
            if (_cursor.isNull(_cursorIndexOfStorage)) {
              _tmpStorage = null;
            } else {
              _tmpStorage = _cursor.getString(_cursorIndexOfStorage);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final boolean _tmpIsFavoriteItem;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavoriteItem);
            _tmpIsFavoriteItem = _tmp != 0;
            final boolean _tmpIsOnShoppingList;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsOnShoppingList);
            _tmpIsOnShoppingList = _tmp_1 != 0;
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final boolean _tmpSelected;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfSelected);
            _tmpSelected = _tmp_2 != 0;
            _item = new ItemEntity(_tmpItemId,_tmpEAN,_tmpName,_tmpPrice,_tmpQuantity,_tmpUrl,_tmpStock,_tmpShop,_tmpStorage,_tmpCategory,_tmpIsFavoriteItem,_tmpIsOnShoppingList,_tmpDescription,_tmpSelected);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<ItemEntity>> getAllFavoriteItems() {
    final String _sql = "SELECT * FROM item WHERE isFavoriteItem = 1 ORDER BY itemId DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"item"}, new Callable<List<ItemEntity>>() {
      @Override
      public List<ItemEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "itemId");
          final int _cursorIndexOfEAN = CursorUtil.getColumnIndexOrThrow(_cursor, "EAN");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfStock = CursorUtil.getColumnIndexOrThrow(_cursor, "stock");
          final int _cursorIndexOfShop = CursorUtil.getColumnIndexOrThrow(_cursor, "shop");
          final int _cursorIndexOfStorage = CursorUtil.getColumnIndexOrThrow(_cursor, "storage");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfIsFavoriteItem = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavoriteItem");
          final int _cursorIndexOfIsOnShoppingList = CursorUtil.getColumnIndexOrThrow(_cursor, "isOnShoppingList");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfSelected = CursorUtil.getColumnIndexOrThrow(_cursor, "selected");
          final List<ItemEntity> _result = new ArrayList<ItemEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ItemEntity _item;
            final long _tmpItemId;
            _tmpItemId = _cursor.getLong(_cursorIndexOfItemId);
            final String _tmpEAN;
            if (_cursor.isNull(_cursorIndexOfEAN)) {
              _tmpEAN = null;
            } else {
              _tmpEAN = _cursor.getString(_cursorIndexOfEAN);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpPrice;
            _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            final String _tmpQuantity;
            if (_cursor.isNull(_cursorIndexOfQuantity)) {
              _tmpQuantity = null;
            } else {
              _tmpQuantity = _cursor.getString(_cursorIndexOfQuantity);
            }
            final String _tmpUrl;
            if (_cursor.isNull(_cursorIndexOfUrl)) {
              _tmpUrl = null;
            } else {
              _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            }
            final int _tmpStock;
            _tmpStock = _cursor.getInt(_cursorIndexOfStock);
            final String _tmpShop;
            if (_cursor.isNull(_cursorIndexOfShop)) {
              _tmpShop = null;
            } else {
              _tmpShop = _cursor.getString(_cursorIndexOfShop);
            }
            final String _tmpStorage;
            if (_cursor.isNull(_cursorIndexOfStorage)) {
              _tmpStorage = null;
            } else {
              _tmpStorage = _cursor.getString(_cursorIndexOfStorage);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final boolean _tmpIsFavoriteItem;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavoriteItem);
            _tmpIsFavoriteItem = _tmp != 0;
            final boolean _tmpIsOnShoppingList;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsOnShoppingList);
            _tmpIsOnShoppingList = _tmp_1 != 0;
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final boolean _tmpSelected;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfSelected);
            _tmpSelected = _tmp_2 != 0;
            _item = new ItemEntity(_tmpItemId,_tmpEAN,_tmpName,_tmpPrice,_tmpQuantity,_tmpUrl,_tmpStock,_tmpShop,_tmpStorage,_tmpCategory,_tmpIsFavoriteItem,_tmpIsOnShoppingList,_tmpDescription,_tmpSelected);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<ItemEntity>> getAllShoppingItems() {
    final String _sql = "SELECT * FROM item WHERE isOnShoppingList = 1 ORDER BY itemId DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"item"}, new Callable<List<ItemEntity>>() {
      @Override
      public List<ItemEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "itemId");
          final int _cursorIndexOfEAN = CursorUtil.getColumnIndexOrThrow(_cursor, "EAN");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfStock = CursorUtil.getColumnIndexOrThrow(_cursor, "stock");
          final int _cursorIndexOfShop = CursorUtil.getColumnIndexOrThrow(_cursor, "shop");
          final int _cursorIndexOfStorage = CursorUtil.getColumnIndexOrThrow(_cursor, "storage");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfIsFavoriteItem = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavoriteItem");
          final int _cursorIndexOfIsOnShoppingList = CursorUtil.getColumnIndexOrThrow(_cursor, "isOnShoppingList");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfSelected = CursorUtil.getColumnIndexOrThrow(_cursor, "selected");
          final List<ItemEntity> _result = new ArrayList<ItemEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ItemEntity _item;
            final long _tmpItemId;
            _tmpItemId = _cursor.getLong(_cursorIndexOfItemId);
            final String _tmpEAN;
            if (_cursor.isNull(_cursorIndexOfEAN)) {
              _tmpEAN = null;
            } else {
              _tmpEAN = _cursor.getString(_cursorIndexOfEAN);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpPrice;
            _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
            final String _tmpQuantity;
            if (_cursor.isNull(_cursorIndexOfQuantity)) {
              _tmpQuantity = null;
            } else {
              _tmpQuantity = _cursor.getString(_cursorIndexOfQuantity);
            }
            final String _tmpUrl;
            if (_cursor.isNull(_cursorIndexOfUrl)) {
              _tmpUrl = null;
            } else {
              _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            }
            final int _tmpStock;
            _tmpStock = _cursor.getInt(_cursorIndexOfStock);
            final String _tmpShop;
            if (_cursor.isNull(_cursorIndexOfShop)) {
              _tmpShop = null;
            } else {
              _tmpShop = _cursor.getString(_cursorIndexOfShop);
            }
            final String _tmpStorage;
            if (_cursor.isNull(_cursorIndexOfStorage)) {
              _tmpStorage = null;
            } else {
              _tmpStorage = _cursor.getString(_cursorIndexOfStorage);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final boolean _tmpIsFavoriteItem;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavoriteItem);
            _tmpIsFavoriteItem = _tmp != 0;
            final boolean _tmpIsOnShoppingList;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsOnShoppingList);
            _tmpIsOnShoppingList = _tmp_1 != 0;
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final boolean _tmpSelected;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfSelected);
            _tmpSelected = _tmp_2 != 0;
            _item = new ItemEntity(_tmpItemId,_tmpEAN,_tmpName,_tmpPrice,_tmpQuantity,_tmpUrl,_tmpStock,_tmpShop,_tmpStorage,_tmpCategory,_tmpIsFavoriteItem,_tmpIsOnShoppingList,_tmpDescription,_tmpSelected);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
