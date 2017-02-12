package br.com.felipecastilhos.codechallenge.data.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.felipecastilhos.codechallenge.data.local.DBHelper;
import br.com.felipecastilhos.codechallenge.data.local.Db;
import br.com.felipecastilhos.codechallenge.data.model.User;

public class UserDao {
    private static Context mContext;
    private static DBHelper mDBHelper;

    public UserDao(Context context) {
        mContext = context;
    }

    public void  createUser(String name) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Db.UserTable.COLUMN_NAME, name);
        db.insert(Db.UserTable.TABLE_NAME, null, contentValues);
    }

    public User getUser(int id) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        String[] colummns = {Db.UserTable.COLUMN_NAME};
        Cursor cursor = db.rawQuery("select * from user where id == " + id, null);
        return Db.parseCursorToUser(cursor);
    }
}
