package org.example.task;

import java.util.Random;

public final class RandomUtil {

    private static  final Random RANDOM = new Random();
    public static final int DEFAULT_BOUND = 10;

    public RandomUtil() {
    }

    public static int getRandom() {
        return RANDOM.nextInt(DEFAULT_BOUND);
    }

    public static int getRandom(int bound) {
        return RANDOM.nextInt(bound);
    }

}
