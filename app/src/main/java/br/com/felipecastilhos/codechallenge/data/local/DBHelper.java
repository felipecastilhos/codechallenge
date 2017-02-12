package br.com.felipecastilhos.codechallenge.data.local;

import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "codechallenge.db";
    public static final int DATABASE_VERSION = 1;
    private static DBHelper mInstance;
    private static SQLiteDatabase mDB;
    private DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.beginTransaction();
        try {
            db.execSQL(Db.UserTable.CREATE);
            db.execSQL(Db.RestaurantTable.CREATE);
            db.execSQL(Db.ReviewTable.CREATE);
            db.execSQL(Db.FavoriteTable.CREATE);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public synchronized void close() {
        if (mInstance != null)
            mDB.close();
    }

    public static synchronized DBHelper getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DBHelper(context);
            mDB = mInstance.getWritableDatabase();
        }

        return mInstance;
    }

    public int getNumberRows(String table) {
        return (int) DatabaseUtils.queryNumEntries(mDB, table);
    }
}
