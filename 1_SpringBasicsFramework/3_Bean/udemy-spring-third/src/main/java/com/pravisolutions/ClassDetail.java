package com.pravisolutions;

public class ClassDetail {
    private String classID;

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    @Override
    public String toString() {
        return "ClassDetail{" +
                "classID='" + classID + '\'' +
                '}';
    }
}
