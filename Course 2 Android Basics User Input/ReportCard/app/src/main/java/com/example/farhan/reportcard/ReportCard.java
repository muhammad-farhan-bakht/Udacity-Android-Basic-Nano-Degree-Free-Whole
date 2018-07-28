package com.example.farhan.reportcard;

/**
 * Created by Farhan on 10/2/2017.
 */

public class ReportCard {

    private String mName;
    private char mSection;
    private int mClass;
    private int mEnglish;
    private int mChemistry;
    private int mMaths;
    private int mPhysics;
    private int mBiology;
    private int sum;

    // When we make an object of class we must pass these values in the Constructor.
    public ReportCard(String mName, char mSection, int mClass, int mEnglish, int mChemistry, int mMaths, int mPhysics, int mBiology) {
        this.mName = mName;
        this.mSection = mSection;
        this.mClass = mClass;
        this.mEnglish = mEnglish;
        this.mChemistry = mChemistry;
        this.mMaths = mMaths;
        this.mPhysics = mPhysics;
        this.mBiology = mBiology;
    }

    // Get name of Student
    public String getmName() {
        return mName;
    }
    // Set Name of Student
    public void setmName(String mName) {
        this.mName = mName;
    }
    // Get section of student
    public char getmSection() {
        return mSection;
    }
    // Set section of student
    public void setmSection(char mSession) {
        this.mSection = mSession;
    }
    // Get class of student
    public int getmClass() {
        return mClass;
    }
    // Set class of student
    public void setmClass(int mClass) {
        this.mClass = mClass;
    }
    // Get English marks
    public int getmEnglish() {
        return mEnglish;
    }
    // Set English marks
    public void setmEnglish(int mEnglish) {
        this.mEnglish = mEnglish;
    }
    // Get Chemistry marks
    public int getmChemistry() {
        return mChemistry;
    }
    // Set Chemistry marks
    public void setmChemistry(int mChemistry) {
        this.mChemistry = mChemistry;
    }
    // Get maths marks
    public int getmMaths() {
        return mMaths;
    }
    // Set maths marks
    public void setmMaths(int mMaths) {
        this.mMaths = mMaths;
    }
    // Get Physics marks
    public int getmPhysics() {
        return mPhysics;
    }
    // Set Physics marks
    public void setmPhysics(int mPhysics) {
        this.mPhysics = mPhysics;
    }
    // Get Biology marks
    public int getmBiology() {
        return mBiology;
    }
    // Set Biology marks
    public void setmBiology(int mBiology) {
        this.mBiology = mBiology;
    }

    // Get total marks
    public int getTotalMarks() {
        sum = mEnglish + mChemistry + mPhysics + mBiology + mMaths;
        return sum;
    }
    // Get Percentage
    public double getPercentage() {
        return (sum / 5);
    }

    @Override
    public String toString() {
        return "Result \n"+ " Name = " + mName +  "\n Section "+ mSection + "\n Class " + mClass + "\n English = " + mEnglish + "\n Maths = " + mMaths + "\n Biology = " + mBiology + "\n Chemistry = " + mChemistry + "\n Physics = " + mPhysics + "\n Percentage = " + getPercentage();
    }


}
