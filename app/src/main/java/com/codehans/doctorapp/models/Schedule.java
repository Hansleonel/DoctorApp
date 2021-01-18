package com.codehans.doctorapp.models;

public class Schedule {
    private int idSchedule;
    private String imgPersonSchedule;
    private String namePersonSchedule;
    private String subjectSchedule;
    private String descriptionSchedule;
    private String dateSchedule;

    public Schedule() {
    }

    public Schedule(int idSchedule, String imgPersonSchedule, String namePersonSchedule, String subjectSchedule, String descriptionSchedule, String dateSchedule) {
        this.idSchedule = idSchedule;
        this.imgPersonSchedule = imgPersonSchedule;
        this.namePersonSchedule = namePersonSchedule;
        this.subjectSchedule = subjectSchedule;
        this.descriptionSchedule = descriptionSchedule;
        this.dateSchedule = dateSchedule;
    }

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    public String getImgPersonSchedule() {
        return imgPersonSchedule;
    }

    public void setImgPersonSchedule(String imgPersonSchedule) {
        this.imgPersonSchedule = imgPersonSchedule;
    }

    public String getNamePersonSchedule() {
        return namePersonSchedule;
    }

    public void setNamePersonSchedule(String namePersonSchedule) {
        this.namePersonSchedule = namePersonSchedule;
    }

    public String getSubjectSchedule() {
        return subjectSchedule;
    }

    public void setSubjectSchedule(String subjectSchedule) {
        this.subjectSchedule = subjectSchedule;
    }

    public String getDescriptionSchedule() {
        return descriptionSchedule;
    }

    public void setDescriptionSchedule(String descriptionSchedule) {
        this.descriptionSchedule = descriptionSchedule;
    }

    public String getDateSchedule() {
        return dateSchedule;
    }

    public void setDateSchedule(String dateSchedule) {
        this.dateSchedule = dateSchedule;
    }
}
