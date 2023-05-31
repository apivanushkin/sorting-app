package com.epam.sorting;

import java.util.Arrays;
import java.util.StringJoiner;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Stupid CLI application for ascending sorting of passed integer arguments
 *
 * @author Aleksei Ivanushkin
 */
public class SortingApp {

	public static final int MIN_ARGS = 1;
	public static final int MAX_ARGS = 10;
	private static final Logger LOG = LogManager.getLogger(SortingApp.class);

	private SortingApp() {
	}

	/**
	 * Prints asc-sorted args in standard console output (e.g. for args <3 2 1> the output will be <1 2 3>)
	 *
	 * @param args convertible to integers (from {@value MIN_ARGS} to {@value MAX_ARGS})
	 * @throws IllegalArgumentException if number of args is invalid or if the arg can not be parsed as {@link Integer}
	 */
	public static void main(String[] args) {
		LOG.info("Started with args: {}", Arrays.toString(args));
		if (args.length < MIN_ARGS || args.length > MAX_ARGS) {
			LOG.error("Wrong number of arguments");
			throw new IllegalArgumentException(
				String.format("%d to %d arguments expected, but was %d", MIN_ARGS, MAX_ARGS, args.length));
		}
		int[] numbers = convertToIntArray(args);
		LOG.info("Applying ascending sorting");
		Arrays.sort(numbers);
		System.out.println(toSpaceSeparatedString(numbers));
	}

	private static int[] convertToIntArray(String[] lines) {
		int[] numbers = new int[lines.length];
		for (int i = 0; i < lines.length; i++) {
			if (NumberUtils.isParsable(lines[i])) {
				numbers[i] = Integer.parseInt(lines[i]);
			} else {
				LOG.error("Invalid argument");
				throw new IllegalArgumentException("'" + lines[i] + "' is not parsable as an integer");
			}
		}
		return numbers;
	}

	private static String toSpaceSeparatedString(int[] numbers) {
		StringJoiner joiner = new StringJoiner(" ");
		for (int number : numbers) {
			joiner.add(String.valueOf(number));
		}
		return joiner.toString();
	}
}