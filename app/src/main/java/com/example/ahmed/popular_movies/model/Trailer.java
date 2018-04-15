package com.example.ahmed.popular_movies.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ahmed on 5/4/2018.
 */

public class Trailer implements Parcelable{

    private String site;

    private String id;

    private String iso_639_1;

    private String name;

    private String type;

    private String key;

    private String iso_3166_1;

    private String size;

    public Trailer(Parcel in) {
        site = in.readString();
        id = in.readString();
        iso_639_1 = in.readString();
        name = in.readString();
        type = in.readString();
        key = in.readString();
        iso_3166_1 = in.readString();
        size = in.readString();
    }

    public static final Creator<Trailer> CREATOR = new Creator<Trailer>() {
        @Override
        public Trailer createFromParcel(Parcel in) {
            return new Trailer(in);
        }

        @Override
        public Trailer[] newArray(int size) {
            return new Trailer[size];
        }
    };

    public String getSite ()
    {
        return site;
    }

    public void setSite (String site)
    {
        this.site = site;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getIso_639_1 ()
    {
        return iso_639_1;
    }

    public void setIso_639_1 (String iso_639_1)
    {
        this.iso_639_1 = iso_639_1;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getKey ()
    {
        return key;
    }

    public void setKey (String key)
    {
        this.key = key;
    }

    public String getIso_3166_1 ()
    {
        return iso_3166_1;
    }

    public void setIso_3166_1 (String iso_3166_1)
    {
        this.iso_3166_1 = iso_3166_1;
    }

    public String getSize ()
    {
        return size;
    }

    public void setSize (String size)
    {
        this.size = size;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [site = "+site+", id = "+id+", iso_639_1 = "+iso_639_1+", name = "+name+", type = "+type+", key = "+key+", iso_3166_1 = "+iso_3166_1+", size = "+size+"]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(site);
        parcel.writeString(id);
        parcel.writeString(iso_639_1);
        parcel.writeString(name);
        parcel.writeString(type);
        parcel.writeString(key);
        parcel.writeString(iso_3166_1);
        parcel.writeString(size);
    }
}
