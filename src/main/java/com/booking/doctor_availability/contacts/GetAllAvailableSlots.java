package com.booking.doctor_availability.contacts;

import java.util.List;

import org.springframework.modulith.ApplicationModule;


@ApplicationModule(
    allowedDependencies = {"com.booking.appointment_booking"},
    type = ApplicationModule.Type.OPEN)
public interface GetAllAvailableSlots {
    List<DoctorAvailabilityResponse> getAllAvailableSlots();
}
