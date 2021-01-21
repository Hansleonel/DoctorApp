package com.codehans.doctorapp.models;

public class Notification {
    private int idNotification;
    private int typeNotification;
    private String imgNotification;
    private String titleNotification;
    private String subjectNotification;
    private String timerNotification;

    public Notification() {
    }

    public Notification(int idNotification, int typeNotification, String imgNotification, String titleNotification, String subjectNotification, String timerNotification) {
        this.idNotification = idNotification;
        this.typeNotification = typeNotification;
        this.imgNotification = imgNotification;
        this.titleNotification = titleNotification;
        this.subjectNotification = subjectNotification;
        this.timerNotification = timerNotification;
    }

    public int getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(int idNotification) {
        this.idNotification = idNotification;
    }

    public int getTypeNotification() {
        return typeNotification;
    }

    public void setTypeNotification(int typeNotification) {
        this.typeNotification = typeNotification;
    }

    public String getImgNotification() {
        return imgNotification;
    }

    public void setImgNotification(String imgNotification) {
        this.imgNotification = imgNotification;
    }

    public String getTitleNotification() {
        return titleNotification;
    }

    public void setTitleNotification(String titleNotification) {
        this.titleNotification = titleNotification;
    }

    public String getSubjectNotification() {
        return subjectNotification;
    }

    public void setSubjectNotification(String subjectNotification) {
        this.subjectNotification = subjectNotification;
    }

    public String getTimerNotification() {
        return timerNotification;
    }

    public void setTimerNotification(String timerNotification) {
        this.timerNotification = timerNotification;
    }
}
