package com.driftycode.productsassignment.base;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.driftycode.productsassignment.data.ProductsDatabase;

/**
 * Created by Abdul Raheem on 14/11/17.
 */

public class ProductsApplication extends Application {

    private ProductsApplication applicationContext;
    private ProductsDatabase database;

    // Database initialization for the application

    /**
     *
     * @return product database
     */
    public ProductsDatabase getRoomInstance() {
        database = Room.databaseBuilder(getApplicationContext(),
                ProductsDatabase.class, "Products.db")
                .build();
        return database;
    }


}
