package br.com.felipecastilhos.codechallenge.data.dao;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.felipecastilhos.codechallenge.data.local.DBHelper;
import br.com.felipecastilhos.codechallenge.data.local.Db;
import br.com.felipecastilhos.codechallenge.data.model.User;

public class UserDAO {
    private static DBHelper mDBHelper;
    private static final String TABLE_NAME = Db.UserTable.TABLE_NAME;

    public UserDAO(Context context) {
        mDBHelper = DBHelper.getInstance(context);
    }

    public void  createUser(String name) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Db.UserTable.COLUMN_NAME, name);
        db.insert(TABLE_NAME, null, contentValues);
    }

    public User getUser(int id) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME + " where id == " + id, null);
        return parseCursorToUser(cursor);
    }

    public static User parseCursorToUser(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndexOrThrow(Db.UserTable.COLUMN_ID));
        String name = cursor.getString(cursor.getColumnIndexOrThrow(Db.UserTable.COLUMN_NAME));
        return new User(id, name);
    }

    public int totalUsers() {
        return mDBHelper.getNumberRows(Db.UserTable.TABLE_NAME);
    }
}
