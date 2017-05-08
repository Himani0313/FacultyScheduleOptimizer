package edu.asu.facultyscheduleoptimizer.dummy;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.api.client.util.DateTime;

import java.io.Serializable;

/**
 * Created by hjshah2 on 5/7/2017.
 */

public class sample implements Serializable{
    public String nameEvent;
    public DateTime t1;
    public DateTime t2;
    public String typeEvent;
    public sample(String name, DateTime time1, DateTime time2, String type){
        this.nameEvent = name;
        this.t1 = time1;
        this.t2 = time2;
        this.typeEvent = type;
    }
}
