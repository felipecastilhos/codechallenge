package br.com.felipecastilhos.codechallenge.data.local;

import br.com.felipecastilhos.codechallenge.data.model.Location;

import static br.com.felipecastilhos.codechallenge.data.local.Db.FavoritTable.COLUMN_DATE;

public class Db {
    public abstract static class FavoritTable {
        public static final String TABLE_NAME = "favorite";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_RESTAURANT_ID = "restaurant_id";
        public static final String COLUMN_DATE = "date";

        public static final String CREATE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_RESTAURANT_ID + " INTEGER NOT NULL, " +
                        COLUMN_DATE + " TEXT NOT NULL, " +
                        "FOREIGN KEY (" + COLUMN_RESTAURANT_ID + ") REFERENCES" +
                        RestaurantTable.TABLE_NAME + "(" + RestaurantTable.COLUMN_ID +
                        ")); ";

    }

    public abstract static class RestaurantTable {
        public static final String TABLE_NAME = "restaurant";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_ABOUT = "about";
        public static final String COLUMN_LOCATION = "location";

        public static final String CREATE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_NAME + " INTEGER NOT NULL, " +
                        COLUMN_ABOUT + "TEXT, " +
                        COLUMN_LOCATION + "TEXT NOT NULL, " +
                        " ); ";
    }

    public abstract static class UserTable {
        public static final String TABLE_NAME = "user";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";

        public static final String CREATE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_NAME + " INTEGER NOT NULL, " +
                        ");";
    }

    public int id;
    public float rate;
    public int userId;
    public int restaurantId;
    public String userReview;
    public int date;

    public abstract static class Review {
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
                        COLUMN_RATE + " INTEGER NOT NULL, " +
                        COLUMN_USER_REVIEW+ " TEXT, " +
                        COLUMN_DATE+ " TEXT NOT NULL, " +
                        COLUMN_RESTAURANT_ID+ " TEXT NOT NULL, " +
                        COLUMN_USER_ID+ " TEXT NOT NULL, " +
                        "FOREIGN KEY (" + COLUMN_RESTAURANT_ID + ") REFERENCES" +
                        RestaurantTable.TABLE_NAME + "(" + RestaurantTable.COLUMN_ID + "), " +
                        "FOREIGN KEY (" + COLUMN_USER_ID+ ") REFERENCES" +
                        UserTable.TABLE_NAME + "(" + UserTable.COLUMN_ID + ")" +
                        "); ";
    }
}
