package com.booking.appointment_booking.infrastrecture;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.booking.appointment_booking.domain.contracts.IGetAvailableSlots;
import com.booking.doctor_availability.contacts.DoctorAvailabilityResponse;
import com.booking.doctor_availability.contacts.GetAllAvailableSlots;

@Service
public class GetAvailableSlots implements IGetAvailableSlots {
        private final GetAllAvailableSlots getAllAvailableSlots;

    public GetAvailableSlots(GetAllAvailableSlots getAllAvailableSlots) {
        this.getAllAvailableSlots = getAllAvailableSlots;
    }  

    @Override
    public boolean isSlotAvailable(UUID slotID) {
        // Check if slot is  available on reserved date from the DoctorAvailability module
        // Replace this with actual logic to retrieve data
        List<DoctorAvailabilityResponse> availableSlots = getAllAvailableSlots.getAllAvailableSlots();

        if (availableSlots.contains(slotID)) {
            return true;
        }
         return false;
    }
    
    @Override
    public List<DoctorAvailabilityResponse> getAllAvailableSlots() {
        return getAllAvailableSlots.getAllAvailableSlots();
    }

}
