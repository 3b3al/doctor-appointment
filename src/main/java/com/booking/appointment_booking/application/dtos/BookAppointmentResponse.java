package com.booking.appointment_booking.application.dtos;

import java.util.Date;
import java.util.UUID;

public record BookAppointmentResponse(UUID slotId, String patientName, Date reservedAt) {}
