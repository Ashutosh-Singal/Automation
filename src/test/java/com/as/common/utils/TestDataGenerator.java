package com.as.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TestDataGenerator {

    private static final String[] FIRST_NAMES = {"Ford", "Micah", "Nova", "Kai", "Zara"};
    private static final String[] LAST_NAMES = {"Paucek", "Kovacek", "Vega", "Lunar", "Cosmos"};
    private static final Random random = new Random();

    public static String randomFullName(String suffix) {
        return FIRST_NAMES[random.nextInt(FIRST_NAMES.length)] + " " +
                LAST_NAMES[random.nextInt(LAST_NAMES.length)] + " - " + suffix;
    }

    public static BigDecimal randomBigDecimal(double min, double max, int scale) {
        double randomValue = ThreadLocalRandom.current().nextDouble(min, max);
        return BigDecimal.valueOf(randomValue).setScale(scale, RoundingMode.HALF_UP);
    }

}
