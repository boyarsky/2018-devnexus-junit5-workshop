package com.devnexus.workshop.junit5;

public class Earthquake {

	public static class ShakeException extends RuntimeException {

		private static final long serialVersionUID = -7501336581318526078L;

		public ShakeException(String message) {
			super(message);
		}
	}

	public void shake(boolean strong) {
		if (strong) {
			throw new ShakeException("Wait for the aftershock...");
		}
	}
	
	// we are impatient, so let's only wait two seconds
	public void waitForAftershock() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// ignore
		}
	}
}
