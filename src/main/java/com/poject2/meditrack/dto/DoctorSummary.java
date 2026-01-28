package com.poject2.meditrack.dto;

public class DoctorSummary {
    private String fullName;
    private String id;
    private long appointmentCount;
    public DoctorSummary(String fullName, String id, long appointmentCount) {
        this.fullName = fullName;
        this.id = id;
        this.appointmentCount = appointmentCount;
    }
}
