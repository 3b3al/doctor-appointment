package com.booking.appointment_management.shell.adapter.persistence;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import com.booking.appointment_management.core.domain.AppointmentStatus;

@Entity
@Table(name = "appointments")
public class AppointmentEntity {
    @Id
    private String id;

    @Column(name = "slot_id", nullable = false)
    private String slotId;

    @Column(name = "patient_id", nullable = false)
    private String patientId;

    @Column(name = "patient_name", nullable = false)
    private String patientName;

    @Column(name = "reserved_at", nullable = false)
    private LocalDateTime reservedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AppointmentStatus status;

    protected AppointmentEntity() {
    }

    public AppointmentEntity(String id, String slotId, String patientId, String patientName, LocalDateTime reservedAt, AppointmentStatus status) {
        this.id = id;
        this.slotId = slotId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.reservedAt = reservedAt;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getSlotId() {
        return slotId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public LocalDateTime getReservedAt() {
        return reservedAt;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    protected void setId(String id) {
        this.id = id;
    }

    protected void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    protected void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    protected void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    protected void setReservedAt(LocalDateTime reservedAt) {
        this.reservedAt = reservedAt;
    }

    protected void setStatus(AppointmentStatus status) {
        this.status = status;
    }
}
