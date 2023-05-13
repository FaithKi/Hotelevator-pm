package utils;

import java.util.Random;

public class Randomizer {

    private final Random random = new Random();
    
    public int getRandomInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}
