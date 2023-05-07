package ru.checkwebsite.apiuser;

import com.github.javafaker.Faker;

public class GeneratorRandom extends CreateUser {
    static Faker faker = new Faker();

    public CreateUser getCreateUser() {
        String email = (faker.name().firstName() + "@example.com");
        String password = (faker.number().digits(7));
        String name = ((faker.name().firstName()));
        return new CreateUser(email, password, name);
    }
    public CreateUser getCreateUserWithShortPass() {
        String email = (faker.name().firstName() + "@example.com");
        String password = (faker.number().digits(5));
        String name = ((faker.name().firstName()));
        return new CreateUser(email, password, name);
    }
}