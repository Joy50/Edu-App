package com.joy50.kendrobinduadmin;

public class StudentsInfoModel {

    private String studentName;
    private String studyLevel;

    public StudentsInfoModel(String studentName, String studyLevel) {
        this.studentName = studentName;
        this.studyLevel = studyLevel;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudyLevel() {
        return studyLevel;
    }

    public void setStudyLevel(String studyLevel) {
        this.studyLevel = studyLevel;
    }
}
