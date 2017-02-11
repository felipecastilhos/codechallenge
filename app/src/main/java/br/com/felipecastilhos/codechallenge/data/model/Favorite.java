package br.com.felipecastilhos.codechallenge.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Favorite implements Parcelable {
    public int id;
    public int restaurantId;
    public String date;

    protected Favorite(Parcel in) {
        id = in.readInt();
        restaurantId = in.readInt();
        date = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(restaurantId);
        dest.writeString(date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Favorite> CREATOR = new Creator<Favorite>() {
        @Override
        public Favorite createFromParcel(Parcel in) {
            return new Favorite(in);
        }

        @Override
        public Favorite[] newArray(int size) {
            return new Favorite[size];
        }
    };
}
