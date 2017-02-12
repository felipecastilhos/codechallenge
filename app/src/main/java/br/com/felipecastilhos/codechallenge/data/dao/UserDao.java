package br.com.felipecastilhos.codechallenge.data.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.felipecastilhos.codechallenge.data.local.DBHelper;
import br.com.felipecastilhos.codechallenge.data.local.Db;
import br.com.felipecastilhos.codechallenge.data.model.User;

public class UserDAO {
    private static DBHelper mDBHelper;

    public UserDAO(Context context) {
        mDBHelper = DBHelper.getInstance(context);
    }

    public void  createUser(String name) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Db.RestaurantTable.COLUMN_NAME, name);
        contentValues.put(Db.RestaurantTable.COLUMN_ABOUT, name);
        contentValues.put(Db.RestaurantTable.COLUMN_LOCATION, name);
        db.insert(Db.UserTable.TABLE_NAME, null, contentValues);
    }

    public User getUser(int id) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + Db.UserTable.TABLE_NAME + " where id == " + id, null);
        return Db.parseCursorToUser(cursor);
    }

    public int totalUsers() {
        return mDBHelper.getNumberRows(Db.UserTable.TABLE_NAME);
    }
}
