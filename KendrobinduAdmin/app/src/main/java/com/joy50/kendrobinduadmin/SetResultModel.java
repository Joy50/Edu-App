package com.joy50.kendrobinduadmin;

public class SetResultModel {

    private String nameOfFile;
    private String linkOfFile;

    public SetResultModel(String nameOfFile, String linkOfFile) {
        this.nameOfFile = nameOfFile;
        this.linkOfFile = linkOfFile;
    }

    public String getNameOfFile() {
        return nameOfFile;
    }

    public void setNameOfFile(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }

    public String getLinkOfFile() {
        return linkOfFile;
    }

    public void setLinkOfFile(String linkOfFile) {
        this.linkOfFile = linkOfFile;
    }
}
