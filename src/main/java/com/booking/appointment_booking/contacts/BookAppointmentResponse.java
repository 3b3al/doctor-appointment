package com.booking.appointment_booking.contacts;
import java.util.Date;
import java.util.UUID;

public record BookAppointmentResponse(UUID slotId, String patientName, Date reservedAt) {}
