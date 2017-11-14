package com.driftycode.productsassignment.data;

/**
 * Created by Abdul Raheem on 14/11/17.
 */

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {ProductTableModel.class}, version = 1)
public abstract class ProductsDatabase extends RoomDatabase {
    public abstract ProductDao productDao();
}
