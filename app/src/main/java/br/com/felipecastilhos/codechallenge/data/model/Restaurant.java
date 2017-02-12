package br.com.felipecastilhos.codechallenge.data.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Restaurant implements Parcelable {
    public int id;
    public String name;
    public String about;
    public double distance;

    public Restaurant(int id, String name, String about, double distance) {
        this.id = id;
        this.name = name;
        this.about = about;
        this.distance = distance;
    }

    protected Restaurant(Parcel in) {
        id = in.readInt();
        name = in.readString();
        about = in.readString();
        distance = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(about);
        dest.writeDouble(distance);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };
}
