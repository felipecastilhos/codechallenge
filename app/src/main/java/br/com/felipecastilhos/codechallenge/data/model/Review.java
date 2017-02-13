package br.com.felipecastilhos.codechallenge.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Review implements Parcelable {
    public int id;
    public float rate;
    public User user;
    public Restaurant  restaurant;
    public String userReview;
    public String date;

    public Review(int id, float rate, User user, Restaurant restaurant, String userReview, String date) {
        this.id = id;
        this.rate = rate;
        this.user = user;
        this.restaurant = restaurant;
        this.userReview = userReview;
        this.date = date;
    }


    protected Review(Parcel in) {
        id = in.readInt();
        rate = in.readFloat();
        user = in.readParcelable(User.class.getClassLoader());
        restaurant = in.readParcelable(Restaurant.class.getClassLoader());
        userReview = in.readString();
        date = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeFloat(rate);
        dest.writeParcelable(user, flags);
        dest.writeParcelable(restaurant, flags);
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
