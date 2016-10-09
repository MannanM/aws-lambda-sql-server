package com.mannanlive.domain;

public class SpaceResponseClass {
    private String dbName;
    private String fileName;
    private double currentSizeMb;
    private double freeSpaceMb;

    public SpaceResponseClass() {
    }

    public SpaceResponseClass(String dbName, String fileName, double currentSizeMb, double freeSpaceMb) {
        this.dbName = dbName;
        this.fileName = fileName;
        this.currentSizeMb = currentSizeMb;
        this.freeSpaceMb = freeSpaceMb;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public double getCurrentSizeMb() {
        return currentSizeMb;
    }

    public void setCurrentSizeMb(double currentSizeMb) {
        this.currentSizeMb = currentSizeMb;
    }

    public double getFreeSpaceMb() {
        return freeSpaceMb;
    }

    public void setFreeSpaceMb(double freeSpaceMb) {
        this.freeSpaceMb = freeSpaceMb;
    }
}
