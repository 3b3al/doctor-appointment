package com.booking.doctor_availability.utils;

import java.util.concurrent.CompletableFuture;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.booking.appointment_booking.contacts.BookAppointmentResponse;
import com.booking.doctor_availability.repositories.DoctorAvailabilityRepo;
import com.booking.shared.IEventBus;

@Configuration
public class ReserveSlotEvenHandler {
    private final IEventBus eventBus;
    private DoctorAvailabilityRepo doctorAvailabilityRepo;

    public ReserveSlotEvenHandler(IEventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Bean
    public void subscribe() {
        eventBus.subscribe(this ,BookAppointmentResponse.class, this::handle);
    }

    public CompletableFuture<Void> handle(BookAppointmentResponse reserveSlotDto) {
        System.out.println("Slot reserved: " + reserveSlotDto.slotId());
        doctorAvailabilityRepo.updateDoctorAvailability(reserveSlotDto.slotId());
        return CompletableFuture.completedFuture(null);
    }

}
