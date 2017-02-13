package br.com.felipecastilhos.codechallenge.data.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.felipecastilhos.codechallenge.data.local.DBHelper;
import br.com.felipecastilhos.codechallenge.data.local.Db;
import br.com.felipecastilhos.codechallenge.data.model.Restaurant;

public class RestaurantDAO {
    private static DBHelper mDBHelper;
    private static final String TABLE_NAME = Db.RestaurantTable.TABLE_NAME;

    public RestaurantDAO(Context context) {
        mDBHelper = DBHelper.getInstance(context);
    }

    public void createRestaurant(String name, String about, double distance) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Db.RestaurantTable.COLUMN_NAME, name);
        contentValues.put(Db.RestaurantTable.COLUMN_ABOUT, about);
        contentValues.put(Db.RestaurantTable.COLUMN_DISTANCE, distance);
        db.insert(TABLE_NAME, null, contentValues);
    }

    public Restaurant getRestaurant(int id) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME + " where id == " + id, null);
        Restaurant restaurant = parseCurorToRestaurant(cursor);
        cursor.close();
        return restaurant;
    }

    public Cursor listNearbyRestaurants(double distance) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        List<Restaurant> list = new ArrayList<>();
        return db.rawQuery("select * from " + TABLE_NAME + " where " + Db.RestaurantTable.COLUMN_DISTANCE + " < " + distance, null);
    }

    public static Restaurant parseCurorToRestaurant(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndexOrThrow(Db.RestaurantTable.COLUMN_ID));
        String name = cursor.getString(cursor.getColumnIndexOrThrow(Db.RestaurantTable.COLUMN_NAME));
        String about = cursor.getString(cursor.getColumnIndexOrThrow(Db.RestaurantTable.COLUMN_ABOUT));
        double distance = cursor.getDouble(cursor.getColumnIndexOrThrow(Db.RestaurantTable.COLUMN_DISTANCE));
        return new Restaurant(id, name, about, distance);
    }


}
