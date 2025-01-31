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
    private final DoctorAvailabilityRepo doctorAvailabilityRepo;

    public ReserveSlotEvenHandler(IEventBus eventBus , DoctorAvailabilityRepo doctorAvailabilityRepo) {
        this.eventBus = eventBus;
        this.doctorAvailabilityRepo = doctorAvailabilityRepo;
    }

    @Bean
    public Runnable subscribe() {
        eventBus.subscribe(this ,BookAppointmentResponse.class, this::handle);
        return () -> System.out.println("Subscribed to ReserveSlotEvent");
    }

    public CompletableFuture<Void> handle(BookAppointmentResponse reserveSlotDto) {
        System.out.println("Slot reserved: " + reserveSlotDto.slotId());
        doctorAvailabilityRepo.updateDoctorAvailability(reserveSlotDto.slotId());
        return null;
    }

}
