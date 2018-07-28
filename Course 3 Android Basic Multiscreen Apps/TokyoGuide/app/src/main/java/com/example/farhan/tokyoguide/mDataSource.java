package com.example.farhan.tokyoguide;

/**
 * Created by Farhan on 10/3/2017.
 */

public class mDataSource {

    private int mImage;
    private int mName;
    private int mDec;
    private int mLocation;
    private int mSchedule;
    private int mPhone;

    public mDataSource(int mImage, int mName, int mDec, int mLocation, int mSchedule, int mPhone) {
        this.mImage = mImage;
        this.mName = mName;
        this.mDec = mDec;
        this.mLocation = mLocation;
        this.mSchedule = mSchedule;
        this.mPhone = mPhone;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public int getmName() {
        return mName;
    }

    public void setmName(int mName) {
        this.mName = mName;
    }

    public int getmDec() {
        return mDec;
    }

    public void setmDec(int mDec) {
        this.mDec = mDec;
    }

    public int getmLocation() {
        return mLocation;
    }

    public void setmLocation(int mLocation) {
        this.mLocation = mLocation;
    }

    public int getmSchedule() {
        return mSchedule;
    }

    public void setmSchedule(int mSchedule) {
        this.mSchedule = mSchedule;
    }

    public int getmPhone() {
        return mPhone;
    }

    public void setmPhone(int mPhone) {
        this.mPhone = mPhone;
    }
}
