package com.myloginsystem.mid2_labexam;

import android.widget.Button;

public class DataModel {

    String day, startTime, endTime;

    Boolean checkStatus;

    String btnText;

    public void setCheckStatus(Boolean checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Boolean getCheckStatus() {
        return checkStatus;
    }

    public void setBtnText(String btnText) {
        this.btnText = btnText;
    }


    public String getBtnText() {
        return btnText;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDay() {
        return day;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }
}
