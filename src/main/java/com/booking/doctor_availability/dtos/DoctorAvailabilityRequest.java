package com.booking.doctor_availability.dtos;


import java.util.Date;
import java.util.UUID;

public record DoctorAvailabilityRequest(Date time, UUID doctorId, String doctorName, double cost) {}