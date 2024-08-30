package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        // TODO: добавить логику для объявления переменной date и задания её значения, для генерации строки с датой
        // Вы можете использовать класс LocalDate и его методы для получения и форматирования даты
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
        // с помощью Faker, либо используя массив валидных городов и класс Random
        var cities = new String[]{"Москва", "Красногорск", "Тверь", "Смоленск", "Калуга", "Брянск", "Тула", "Орёл",
                "Рязань", "Владимир", "Иваново", "Кострома", "Ярославль", "Курск", "Белгород", "Липецк",
                "Тамбов", "Санкт-Петербург", "Гатчина", "Великий Новгород", "Псков", "Вологда", "Петрозаводск", "Мурманск",
                "Архангельск", "Нарьян-Мар", "Сыктывкар", "Калининград", "Нижний Новгород", "Киров", "Йошкар-Ола",
                "Чебоксары", "Саранск", "Казань", "Ульяновск", "Пенза", "Саратов", "Самара", "Пермь", "Ижевск", "Казань",
                "Уфа", "Оренбург", "Волгоград", "Астрахань", "Элиста", "Ростов-на-Дону", "Краснодар", "Майкоп",
                "Севастополь", "Ставрополь", "Черкесск", "Нальчик", "Владикавказ", "Магас", "Грозный", "Махачкала",
                "Екатеринбург", "Челябинск", "Курган", "Тюмень", "Ханты-Мансийск", "Салехард", "Омск", "Томск",
                "Новосибирск", "Кемерово", "Барнаул", "Горно-Алтайск", "Красноярск", "Абакан", "Кызыл", "Иркутск",
                "Улан-Удэ", "Чита", "Якутск", "Магадан", "Анадырь", "Петропавловск-Камчатский", "Благовещенск",
                "Биробиджан", "Хабаровск", "Владивосток", "Южно-Сахалинск", "Воронеж"};
                return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        // TODO: добавить логику для объявления переменной name и задания её значения, для генерации можно
        // использовать Faker
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " +  faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        // TODO: добавить логику для объявления переменной phone и задания её значения, для генерации можно
        // использовать Faker
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
            // generateName(locale), generatePhone(locale)
            return new UserInfo(generateCity(),generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}