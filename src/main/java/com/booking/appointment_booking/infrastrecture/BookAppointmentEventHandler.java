package com.booking.appointment_booking.infrastrecture;

import java.util.concurrent.CompletableFuture;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.booking.appointment_booking.domain.contracts.IGetAvailableSlots;
import com.booking.appointment_management.core.domain.events.AppointmentCancelledEvent;
import com.booking.shared.IEventBus;

@Configuration
public class BookAppointmentEventHandler {
    private final IEventBus eventBus;
    private final IGetAvailableSlots getAvailableSlots;

    public BookAppointmentEventHandler(IEventBus eventBus, IGetAvailableSlots getAvailableSlots) {
        this.eventBus = eventBus;
        this.getAvailableSlots = getAvailableSlots;
    }

    @Bean
    public Runnable subscribe() {
        eventBus.subscribe(this, AppointmentCancelledEvent.class, this::handleCancellation);
        return () -> System.out.println("Subscribed to AppointmentCancelledEvent");
    }

    public CompletableFuture<Void> handleCancellation(AppointmentCancelledEvent event) {
        System.out.println("Processing appointment cancellation for slot: " + event.slotId());
        getAvailableSlots.updateSlotAvailability(event.slotId(), false); // Set isReserved to false
        return CompletableFuture.completedFuture(null);
    }
} 