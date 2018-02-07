
package com.dharmendra.redmart.models.pojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Img implements Parcelable {

    @SerializedName("h")
    @Expose
    private Integer h;
    @SerializedName("w")
    @Expose
    private Integer w;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("position")
    @Expose
    private Integer position;

    protected Img(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Img> CREATOR = new Creator<Img>() {
        @Override
        public Img createFromParcel(Parcel in) {
            return new Img(in);
        }

        @Override
        public Img[] newArray(int size) {
            return new Img[size];
        }
    };

    public Integer getH() {
        return h;
    }

    public void setH(Integer h) {
        this.h = h;
    }

    public Integer getW() {
        return w;
    }

    public void setW(Integer w) {
        this.w = w;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }
}
