package br.com.felipecastilhos.codechallenge.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Review implements Parcelable {
    public int id;
    public float rate;
    public int userId;
    public int  restaurantId;
    public String userReview;
    public String date;

    public Review(int id, float rate, int userId, int restaurantId, String userReview, String date) {
        this.id = id;
        this.rate = rate;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.userReview = userReview;
        this.date = date;
    }


    protected Review(Parcel in) {
        id = in.readInt();
        rate = in.readFloat();
        userId = in.readInt();
        restaurantId = in.readInt();
        userReview = in.readString();
        date = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeFloat(rate);
        dest.writeInt(userId);
        dest.writeInt(restaurantId);
        dest.writeString(userReview);
        dest.writeString(date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Review> CREATOR = new Creator<Review>() {
        @Override
        public Review createFromParcel(Parcel in) {
            return new Review(in);
        }

        @Override
        public Review[] newArray(int size) {
            return new Review[size];
        }
    };
}
