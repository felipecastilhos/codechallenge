package br.com.felipecastilhos.codechallenge.data.local;

import android.database.Cursor;

import br.com.felipecastilhos.codechallenge.data.model.Favorite;
import br.com.felipecastilhos.codechallenge.data.model.Location;
import br.com.felipecastilhos.codechallenge.data.model.Restaurant;
import br.com.felipecastilhos.codechallenge.data.model.Review;
import br.com.felipecastilhos.codechallenge.data.model.User;

public class Db {
    public abstract static class FavoriteTable {
        public static final String TABLE_NAME = "favorite";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_RESTAURANT_ID = "restaurant_id";
        public static final String COLUMN_DATE = "date";

        public static final String CREATE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_RESTAURANT_ID + " INTEGER NOT NULL, " +
                        COLUMN_DATE + " TEXT NOT NULL, " +
                        "FOREIGN KEY (" + COLUMN_RESTAURANT_ID + ") REFERENCES " +
                        RestaurantTable.TABLE_NAME + "(" + RestaurantTable.COLUMN_ID +
                        ")); ";

    }

    public abstract static class RestaurantTable {
        public static final String TABLE_NAME = "restaurant";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_ABOUT = "about";
        public static final String COLUMN_DISTANCE= "distance";

        public static final String CREATE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_NAME + " TEXT NOT NULL, " +
                        COLUMN_ABOUT + "TEXT, " +
                        COLUMN_DISTANCE + "DOUBLE NOT NULL " +
                        " ); ";
    }

    public abstract static class UserTable {
        public static final String TABLE_NAME = "user";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";

        public static final String CREATE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_NAME + " TEXT NOT NULL " +
                        ");";
    }

    public abstract static class ReviewTable {
        public static final String TABLE_NAME = "review";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_RATE = "rate";
        public static final String COLUMN_USER_REVIEW = "user_review";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_RESTAURANT_ID = "restaurant_id";
        public static final String COLUMN_USER_ID = "user_id";

        public static final String CREATE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_RATE + " DOUBLE NOT NULL, " +
                        COLUMN_USER_REVIEW + " TEXT, " +
                        COLUMN_DATE + " INTEGER NOT NULL, " +
                        COLUMN_RESTAURANT_ID + " INTEGER NOT NULL, " +
                        COLUMN_USER_ID + " INTEGER NOT NULL, " +
                        "FOREIGN KEY (" + COLUMN_RESTAURANT_ID + ") REFERENCES " +
                        RestaurantTable.TABLE_NAME + "(" + RestaurantTable.COLUMN_ID + "), " +
                        "FOREIGN KEY (" + COLUMN_USER_ID + ") REFERENCES " +
                        UserTable.TABLE_NAME + "(" + UserTable.COLUMN_ID + ")" +
                        "); ";
    }
}
