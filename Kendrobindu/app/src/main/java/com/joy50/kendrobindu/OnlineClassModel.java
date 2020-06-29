package com.joy50.kendrobindu;

public class OnlineClassModel {

    private String educationLevel;
    private String educationTime;
    private String classLink;

    public OnlineClassModel(String educationLevel, String educationTime, String classLink) {
        this.educationLevel = educationLevel;
        this.educationTime = educationTime;
        this.classLink = classLink;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getEducationTime() {
        return educationTime;
    }

    public void setEducationTime(String educationTime) {
        this.educationTime = educationTime;
    }

    public String getClassLink() {
        return classLink;
    }

    public void setClassLink(String classLink) {
        this.classLink = classLink;
    }
}
