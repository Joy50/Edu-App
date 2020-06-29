package com.joy50.kendrobindu;

public class CheckResultModel {

    private String classLevel;
    private String downloadLink;

    public CheckResultModel(String classLevel, String downloadLink) {
        this.classLevel = classLevel;
        this.downloadLink = downloadLink;
    }

    public String getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(String classLevel) {
        this.classLevel = classLevel;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

}
