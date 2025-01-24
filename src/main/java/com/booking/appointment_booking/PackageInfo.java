package com.booking.appointment_booking;

import org.springframework.modulith.ApplicationModule;

@ApplicationModule(
    allowedDependencies = {"com.booking.doctor_availability"})
public class PackageInfo {

}
