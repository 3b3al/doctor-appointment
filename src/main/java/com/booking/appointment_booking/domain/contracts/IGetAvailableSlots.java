package com.booking.appointment_booking.domain.contracts;

import java.util.List;
import java.util.UUID;

import org.springframework.modulith.ApplicationModule;

import com.booking.doctor_availability.contacts.DoctorAvailabilityResponse;

@ApplicationModule(
    allowedDependencies = {"com.booking.doctor_availability"},
    type = ApplicationModule.Type.OPEN)
public interface IGetAvailableSlots {
    boolean isSlotAvailable(UUID slotId);
    List<DoctorAvailabilityResponse> getAllAvailableSlots();
}