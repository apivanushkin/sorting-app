package com.epam.sorting;

import static junit.framework.TestCase.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SortingAppPositiveTest {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	private final String[] args;
	private final String expectedOutput;

	public SortingAppPositiveTest(ImmutablePair<String, String> pair) {
		args = pair.left.split(" ");
		expectedOutput = pair.right;
	}

	@Parameters
	public static Object[] getParameters() {
		return new ImmutablePair[]{
			new ImmutablePair<>("0", "0"),
			new ImmutablePair<>("9 8 7 6 5 4 3 2 1 0", "0 1 2 3 4 5 6 7 8 9"),
			new ImmutablePair<>("-1 -340 1 0", "-340 -1 0 1")};
	}

	@Before
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	public void whenValidArgsPassed_thenArgsSortedAsc() {
		SortingApp.main(args);
		assertEquals(expectedOutput, extractLastOutputLine(outputStreamCaptor.toString()));
	}

	@After
	public void tearDown() {
		System.setOut(standardOut);
	}

	private String extractLastOutputLine(String output) {
		String[] lines = output.split(System.lineSeparator());
		return lines[lines.length - 1];
	}
}
