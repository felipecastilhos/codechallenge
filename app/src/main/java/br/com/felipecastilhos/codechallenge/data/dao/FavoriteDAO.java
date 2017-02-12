package br.com.felipecastilhos.codechallenge.data.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.felipecastilhos.codechallenge.data.local.DBHelper;
import br.com.felipecastilhos.codechallenge.data.local.Db;
import br.com.felipecastilhos.codechallenge.data.model.Favorite;
import br.com.felipecastilhos.codechallenge.data.model.User;

public class FavoriteDAO {
    private static DBHelper mDBHelper;

    public FavoriteDAO(Context context) {
        mDBHelper = DBHelper.getInstance(context);
    }

    public void  createFavorite(String name) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Db.FavoriteTable.COLUMN_DATE, name);
        contentValues.put(Db.FavoriteTable.COLUMN_RESTAURANT_ID, name);
        db.insert(Db.UserTable.TABLE_NAME, null, contentValues);
    }

    public Favorite getFavorite(int id) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + Db.FavoriteTable.TABLE_NAME + " where id == " + id, null);
        return Db.parseCursorToFavorite(cursor);
    }
}
