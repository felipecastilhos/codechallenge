package br.com.felipecastilhos.codechallenge.data.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.felipecastilhos.codechallenge.data.local.DBHelper;
import br.com.felipecastilhos.codechallenge.data.local.Db;
import br.com.felipecastilhos.codechallenge.data.model.Restaurant;

public class RestaurantDAO {
    private static DBHelper mDBHelper;

    public RestaurantDAO(Context context) {
        mDBHelper = DBHelper.getInstance(context);
    }

    public void createRestaurant(String name, String about, double distance) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Db.RestaurantTable.COLUMN_NAME, name);
        contentValues.put(Db.RestaurantTable.COLUMN_ABOUT, about);
        contentValues.put(Db.RestaurantTable.COLUMN_DISTANCE, distance);
        db.insert(Db.UserTable.TABLE_NAME, null, contentValues);
    }

    public Restaurant getRestaurant(int id) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + Db.RestaurantTable.TABLE_NAME + " where id == " + id, null);
        return Db.parseCurorToRestaurant(cursor);
    }


}
