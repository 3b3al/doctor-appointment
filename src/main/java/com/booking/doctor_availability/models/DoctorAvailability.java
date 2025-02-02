package com.booking.doctor_availability.models;

import java.util.Date;
import java.util.UUID;

public class DoctorAvailability {
    private UUID slotId;
    private Date time;
    private UUID doctorId;
    private String doctorName;
    private boolean isReserved;
    private double cost;

    private DoctorAvailability(UUID slotId, Date time, UUID doctorId, String doctorName, boolean isReserved, double cost) {
        this.slotId = slotId;
        this.time = time;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.isReserved = isReserved;
        this.cost = cost;
    }

    public static DoctorAvailability newDoctorAvailabilitySlot(Date time, UUID doctorId, String doctorName, double cost) {
        UUID slotId = UUID.randomUUID();
        boolean isReserved = false;
        return new DoctorAvailability(slotId, time, doctorId, doctorName, isReserved, cost);
    }

    public UUID getSlotId() {
        return slotId;
    }

    public Date getTime() {
        return time;
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public double getCost() {
        return cost;
    }
}
