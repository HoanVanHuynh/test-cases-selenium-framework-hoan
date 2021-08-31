package helpers;

import com.github.javafaker.Faker;

public class DataHelper {

    private static final Faker faker = new Faker();

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }


    public static String getRandomPassword(int numberOfCharacters) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= numberOfCharacters; i++) {
            stringBuilder.append(faker.bothify("?"));
        }
        return stringBuilder.toString();
    }

    public static String getRandomDigits(int count) {
        return faker.number().digits(count);
    }

    public static int getRandomNumber(int min, int max) {
        return faker.number().numberBetween(min, max);
    }
}