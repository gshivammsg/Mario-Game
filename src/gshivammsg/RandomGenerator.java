package gshivammsg;

import java.util.Random;

public class RandomGenerator {
    private static Random r;

    public static int next(int upperLimit) {
        if(r == null) {
            r = new Random();
        }

        return r.nextInt(upperLimit);
    }


    public static int nextBetween(int lowerLimit, int upperLimit) {
        if(r == null) {
            r = new Random();
        }

        return r.nextInt(upperLimit - lowerLimit) + lowerLimit;
    }
}