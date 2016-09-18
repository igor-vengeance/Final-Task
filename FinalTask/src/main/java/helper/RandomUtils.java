package helper;

import java.util.Random;

public class RandomUtils {

    public static String getRandomEmail() {
        Random random = new Random();
        return String.format("selenium%s@mail.ru", random.nextInt(9999));
    }
}
