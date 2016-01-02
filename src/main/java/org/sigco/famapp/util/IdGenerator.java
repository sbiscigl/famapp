package org.sigco.famapp.util;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {

	private static final AtomicInteger lastIdGenerated = new AtomicInteger(0);

	private IdGenerator() {
		// prevent this class from being instantiated
	}

	public static int generateId() {
		return lastIdGenerated.incrementAndGet();
	}
}
