package br.com.felipecastilhos.codechallenge.data.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.felipecastilhos.codechallenge.data.local.DBHelper;
import br.com.felipecastilhos.codechallenge.data.local.Db;
import br.com.felipecastilhos.codechallenge.data.model.Restaurant;
import br.com.felipecastilhos.codechallenge.data.model.Review;
import br.com.felipecastilhos.codechallenge.data.model.User;

public class ReviewDAO {
    private static DBHelper mDBHelper;
    private static final String TABLE_NAME = Db.ReviewTable.TABLE_NAME;
    private static Context mContext;

    public ReviewDAO(Context context) {
        mDBHelper = DBHelper.getInstance(context);
        mContext = context;
    }

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
        Review review = parseCursorToReview(cursor);
        cursor.close();
        return review;
    }

    public Review getAllRestaurantReview(int restaurantId) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        String query = "select * from " + TABLE_NAME + " where " + Db.ReviewTable.COLUMN_RESTAURANT_ID + " == " + restaurantId;
        Cursor cursor = db.rawQuery(query , null);
        Review review = parseCursorToReview(cursor);
        cursor.close();
        return review;
    }

    public static Review parseCursorToReview(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndexOrThrow(Db.ReviewTable.COLUMN_ID));
        float rate = cursor.getFloat(cursor.getColumnIndexOrThrow(Db.ReviewTable.COLUMN_RATE));
        int userID = cursor.getInt(cursor.getColumnIndexOrThrow(Db.ReviewTable.COLUMN_USER_ID));
        int restaurantID = cursor.getInt(cursor.getColumnIndexOrThrow(Db.ReviewTable.COLUMN_RESTAURANT_ID));
        String userReview = cursor.getString(cursor.getColumnIndexOrThrow(Db.ReviewTable.COLUMN_USER_REVIEW));
        String date = cursor.getString(cursor.getColumnIndexOrThrow(Db.ReviewTable.COLUMN_DATE));

        UserDAO userDAO = new UserDAO(mContext);
        RestaurantDAO restaurantDAO = new RestaurantDAO(mContext);

        User user =  userDAO.getUser(userID);
        Restaurant restaurant = restaurantDAO.getRestaurant(restaurantID);
        return new Review(id, rate, user, restaurant, userReview, date);
    }
}
