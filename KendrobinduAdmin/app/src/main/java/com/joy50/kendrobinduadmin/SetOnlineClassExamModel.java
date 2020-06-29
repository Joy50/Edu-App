package com.joy50.kendrobinduadmin;

public class SetOnlineClassExamModel {

    private String levelOfClass;
    private String linkForClass;
    private String linkForExam;
    private String timeSet;

    public SetOnlineClassExamModel(String levelOfClass, String linkForClass, String linkForExam, String timeSet) {
        this.levelOfClass = levelOfClass;
        this.linkForClass = linkForClass;
        this.linkForExam = linkForExam;
        this.timeSet = timeSet;
    }

    public SetOnlineClassExamModel(String levelOfClass, String linkForClass, String timeSet) {
        this.levelOfClass = levelOfClass;
        this.linkForClass = linkForClass;
        this.timeSet = timeSet;
    }

    public String getLevelOfClass() {
        return levelOfClass;
    }

    public void setLevelOfClass(String levelOfClass) {
        this.levelOfClass = levelOfClass;
    }

    public String getLinkForClass() {
        return linkForClass;
    }

    public void setLinkForClass(String linkForClass) {
        this.linkForClass = linkForClass;
    }

    public String getLinkForExam() {
        return linkForExam;
    }

    public void setLinkForExam(String linkForExam) {
        this.linkForExam = linkForExam;
    }

    public String getTimeSet() {
        return timeSet;
    }

    public void setTimeSet(String timeSet) {
        this.timeSet = timeSet;
    }
}
