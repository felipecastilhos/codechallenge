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
    private static final String TABLE_NAME = Db.ReviewTable.TABLE_NAME;

    public ReviewDAO(Context context) {
        mDBHelper = DBHelper.getInstance(context);
    }


    public int id;
    public float rate;
    public int userId;
    public int  restaurantId;
    public String userReview;
    public String date;

    public void createReview(float rate, int userId, int restaurantId,
                             String userReview, String date) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Db.ReviewTable.COLUMN_RATE, rate);
        contentValues.put(Db.ReviewTable.COLUMN_USER_ID, userId);
        contentValues.put(Db.ReviewTable.COLUMN_RESTAURANT_ID, restaurantId);
        contentValues.put(Db.ReviewTable.COLUMN_USER_REVIEW, userReview);
        contentValues.put(Db.ReviewTable.COLUMN_DATE, date);
        db.insert(TABLE_NAME, null, contentValues);
    }

    public Review getReview(int id) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        String query = "select * from " + TABLE_NAME + " where " +  Db.ReviewTable.COLUMN_ID + " == " + id;
        Cursor cursor = db.rawQuery(query, null);
        Review review =  Db.parseCursorToReview(cursor);
        cursor.close();
        return review;
    }

    public Review getAllRestaurantReview(int restaurantId) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        String query = "select * from " + TABLE_NAME + " where " + Db.ReviewTable.COLUMN_RESTAURANT_ID + " == " + restaurantId;
        Cursor cursor = db.rawQuery(query , null);
        Review review =  Db.parseCursorToReview(cursor);
        cursor.close();
        return review;
    }

}
