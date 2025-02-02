package com.booking.appointment_management.core.domain;

import java.time.LocalDateTime;

public class Appointment {
    private final String id;
    private final String slotId;
    private final String patientId;
    private final String patientName;
    private final LocalDateTime reservedAt;
    private AppointmentStatus status;

    public Appointment(String id, String slotId, String patientId, String patientName, LocalDateTime reservedAt) {
        this.id = id;
        this.slotId = slotId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.reservedAt = reservedAt;
        this.status = AppointmentStatus.SCHEDULED;
    }

    // Copy constructor with status
    private Appointment(String id, String slotId, String patientId, String patientName, LocalDateTime reservedAt, AppointmentStatus status) {
        this.id = id;
        this.slotId = slotId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.reservedAt = reservedAt;
        this.status = status;
    }

    // Getters
    public String getId() { return id; }
    public String getSlotId() { return slotId; }
    public String getPatientId() { return patientId; }
    public String getPatientName() { return patientName; }
    public LocalDateTime getReservedAt() { return reservedAt; }
    public AppointmentStatus getStatus() { return status; }

    public Appointment complete() {
        return new Appointment(id, slotId, patientId, patientName, reservedAt, AppointmentStatus.COMPLETED);
    }

    public Appointment cancel() {
        return new Appointment(id, slotId, patientId, patientName, reservedAt, AppointmentStatus.CANCELLED);
    }
}
