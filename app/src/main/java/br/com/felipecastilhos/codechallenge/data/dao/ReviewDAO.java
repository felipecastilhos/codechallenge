package br.com.felipecastilhos.codechallenge.data.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.felipecastilhos.codechallenge.data.local.DBHelper;
import br.com.felipecastilhos.codechallenge.data.local.Db;
import br.com.felipecastilhos.codechallenge.data.model.Restaurant;
import br.com.felipecastilhos.codechallenge.data.model.Review;

public class ReviewDAO {
    private static DBHelper mDBHelper;

    public ReviewDAO(Context context) {
        mDBHelper = DBHelper.getInstance(context);
    }

    public void createReview(String name, String about, String location) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Db.RestaurantTable.COLUMN_NAME, name);
        contentValues.put(Db.RestaurantTable.COLUMN_ABOUT, about);
        contentValues.put(Db.RestaurantTable.COLUMN_LOCATION, location);
        db.insert(Db.UserTable.TABLE_NAME, null, contentValues);
    }

    public Review getReview(int id) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        String query = "select * from " + Db.ReviewTable.TABLE_NAME + " where " +  Db.ReviewTable.COLUMN_ID + " == " + id;
        Cursor cursor = db.rawQuery(query, null);
        return Db.parseCursorToReview(cursor);
    }

    public Review getAllRestaurantReview(int restaurantId) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        String query = "select * from " + Db.ReviewTable.TABLE_NAME + " where " + Db.ReviewTable.COLUMN_RESTAURANT_ID + " == " + restaurantId;
        Cursor cursor = db.rawQuery(query , null);
        return Db.parseCursorToReview(cursor);
    }

}
