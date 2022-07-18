package com.example.model;

public class MedicalDeclaration {
    private int id;
    private String name;
    private String yearOfBirth;
    private String travelInformation;
    private String starDay;
    private String endDay;
    private String note;

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(int id, String name, String yearOfBirth, String travelInformation, String starDay, String endDay, String note) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.travelInformation = travelInformation;
        this.starDay = starDay;
        this.endDay = endDay;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getTravelInformation() {
        return travelInformation;
    }

    public void setTravelInformation(String travelInformation) {
        this.travelInformation = travelInformation;
    }

    public String getStarDay() {
        return starDay;
    }

    public void setStarDay(String starDay) {
        this.starDay = starDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}