package com.booking.doctor_availability.dtos;


import java.util.Date;
import java.util.UUID;

public record DoctorAvailabilityResponse(UUID slotId, Date time, UUID doctorId, String doctorName, boolean isReserved, double cost) {}
