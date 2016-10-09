package com.mannanlive.domain;

import java.sql.Date;

public class TimeResponseClass {
    private java.sql.Date currentTime;

    public TimeResponseClass() {
    }

    public TimeResponseClass(Date currentTime) {
        this.currentTime = currentTime;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }
}