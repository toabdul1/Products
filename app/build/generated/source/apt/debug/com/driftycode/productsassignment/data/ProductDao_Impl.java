package com.driftycode.productsassignment.data;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class ProductDao_Impl implements ProductDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfProductTableModel;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfProductTableModel;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfProductTableModel;

  public ProductDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProductTableModel = new EntityInsertionAdapter<ProductTableModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `products`(`id`,`name`,`description`,`regular_price`,`sale_price`,`product_photo`,`colors`,`updated_date`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProductTableModel value) {
        stmt.bindLong(1, value.id);
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        stmt.bindLong(4, value.getRegular_price());
        stmt.bindLong(5, value.getSale_price());
        if (value.getProduct_photo() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getProduct_photo());
        }
        if (value.getColors() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getColors());
        }
        if (value.getUpdatedDate() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUpdatedDate());
        }
      }
    };
    this.__deletionAdapterOfProductTableModel = new EntityDeletionOrUpdateAdapter<ProductTableModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `products` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProductTableModel value) {
        stmt.bindLong(1, value.id);
      }
    };
    this.__updateAdapterOfProductTableModel = new EntityDeletionOrUpdateAdapter<ProductTableModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `products` SET `id` = ?,`name` = ?,`description` = ?,`regular_price` = ?,`sale_price` = ?,`product_photo` = ?,`colors` = ?,`updated_date` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProductTableModel value) {
        stmt.bindLong(1, value.id);
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        stmt.bindLong(4, value.getRegular_price());
        stmt.bindLong(5, value.getSale_price());
        if (value.getProduct_photo() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getProduct_photo());
        }
        if (value.getColors() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getColors());
        }
        if (value.getUpdatedDate() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUpdatedDate());
        }
        stmt.bindLong(9, value.id);
      }
    };
  }

  @Override
  public void insertProduct(ProductTableModel productItem) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfProductTableModel.insert(productItem);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteProduct(ProductTableModel product) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfProductTableModel.handle(product);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateProduct(ProductTableModel product) {
    __db.beginTransaction();
    try {
      __updateAdapterOfProductTableModel.handle(product);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<ProductTableModel> getProducts() {
    final String _sql = "SELECT * FROM products";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
      final int _cursorIndexOfRegularPrice = _cursor.getColumnIndexOrThrow("regular_price");
      final int _cursorIndexOfSalePrice = _cursor.getColumnIndexOrThrow("sale_price");
      final int _cursorIndexOfProductPhoto = _cursor.getColumnIndexOrThrow("product_photo");
      final int _cursorIndexOfColors = _cursor.getColumnIndexOrThrow("colors");
      final int _cursorIndexOfUpdatedDate = _cursor.getColumnIndexOrThrow("updated_date");
      final List<ProductTableModel> _result = new ArrayList<ProductTableModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ProductTableModel _item;
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        final int _tmpRegular_price;
        _tmpRegular_price = _cursor.getInt(_cursorIndexOfRegularPrice);
        final int _tmpSale_price;
        _tmpSale_price = _cursor.getInt(_cursorIndexOfSalePrice);
        final String _tmpProduct_photo;
        _tmpProduct_photo = _cursor.getString(_cursorIndexOfProductPhoto);
        final String _tmpColors;
        _tmpColors = _cursor.getString(_cursorIndexOfColors);
        final String _tmpUpdatedDate;
        _tmpUpdatedDate = _cursor.getString(_cursorIndexOfUpdatedDate);
        _item = new ProductTableModel(_tmpName,_tmpDescription,_tmpRegular_price,_tmpSale_price,_tmpProduct_photo,_tmpColors,_tmpUpdatedDate);
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
