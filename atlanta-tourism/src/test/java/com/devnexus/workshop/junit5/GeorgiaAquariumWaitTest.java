package com.devnexus.workshop.junit5;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.*;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.junit.*;

@RunWith(MockitoJUnitRunner.class)
public class GeorgiaAquariumWaitTest {

	@Mock
	GeorgiaAquariumSchedule mockSchedule;

	private GeorgiaAquariumWait target;
	
	private LocalDate saturday;

	@Before
	public void setUp() {
		target = new GeorgiaAquariumWait(mockSchedule);
		saturday = LocalDate.of(2017,  Month.FEBRUARY, 24);
		LocalTime nineAm = LocalTime.of(9, 0);
		when(mockSchedule.opening(saturday)).thenReturn(nineAm);
	}

	@Test
	public void plentyOfTime() {
		LocalTime halfHourEarlier = LocalTime.of(8, 30);
		LocalDateTime dateTime = LocalDateTime.of(saturday, halfHourEarlier);
		assertFalse(target.isOpen(dateTime));
	}
	
	@Test
	public void anyMinuteNow() {
		LocalTime oneMinuteEarlier = LocalTime.of(8, 59);
		LocalDateTime dateTime = LocalDateTime.of(saturday, oneMinuteEarlier);
		assertFalse(target.isOpen(dateTime));
	}
	
	@Test
	public void exactOpening() {
		LocalTime sameTime = LocalTime.of(9, 00);
		LocalDateTime dateTime = LocalDateTime.of(saturday, sameTime);
		assertTrue(target.isOpen(dateTime));
	}
	
	@Test
	public void alreadyOpen() {
		LocalTime openHalfHour = LocalTime.of(9, 30);
		LocalDateTime dateTime = LocalDateTime.of(saturday, openHalfHour);
		assertTrue(target.isOpen(dateTime));
	}

}
