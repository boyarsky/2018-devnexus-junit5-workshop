package com.devnexus.workshop.junit5;

import java.time.*;
import java.time.temporal.*;

public class CableCarWait {

	private CableCarSchedule schedule;

	public CableCarWait(CableCarSchedule schedule) {
		this.schedule = schedule;
	}

	public boolean timeForHotDog(LocalTime now) {
		LocalTime nextCar = schedule.nextCar();
		long minutesLeft = now.until(nextCar, ChronoUnit.MINUTES);
		return minutesLeft > 15;
	}
}
