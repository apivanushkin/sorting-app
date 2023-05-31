package com.epam.sorting;

import java.util.Arrays;
import org.junit.Test;

public class SortingAppNegativeTest {

	@Test(expected = IllegalArgumentException.class)
	public void whenExtraArgsPassed_thenIllegalArgumentException() {
		String[] args = new String[SortingApp.MAX_ARGS + 1];
		SortingApp.main(args);
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenNoArgsPassed_thenIllegalArgumentException() {
		String[] args = new String[SortingApp.MIN_ARGS - 1];
		SortingApp.main(args);
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenNotIntegerArgPassed_thenIllegalArgumentException() {
		String[] args = new String[SortingApp.MAX_ARGS];
		Arrays.fill(args, "zero");
		SortingApp.main(args);
	}
}
