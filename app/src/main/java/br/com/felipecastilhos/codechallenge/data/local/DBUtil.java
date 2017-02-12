package br.com.felipecastilhos.codechallenge.data.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBUtil {
    private static DBUtil INSTANCE;
    private DBHelper mDBHelper;
    private static SQLiteDatabase mDb;

    private DBUtil(Context context) {
        super();
        mDBHelper = new DBHelper(context);
        mDb = mDBHelper.getReadableDatabase();
    }

    public static DBUtil getInstance(Context context) {
        if(INSTANCE == null) INSTANCE = new DBUtil(context);
        return INSTANCE;
    }


}
