package com.joy50.kendrobinduadmin;

public class ReviewAssignmentModel {

    private String nameOfAssignment;
    private String downloadLink;

    public ReviewAssignmentModel(String nameOfAssignment, String downloadLink) {
        this.nameOfAssignment = nameOfAssignment;
        this.downloadLink = downloadLink;
    }

    public String getNameOfAssignment() {
        return nameOfAssignment;
    }

    public void setNameOfAssignment(String nameOfAssignment) {
        this.nameOfAssignment = nameOfAssignment;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }
}
