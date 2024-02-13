package by.sportliner.lk.core.model;

public enum Tariff {

    ONE_LESSON_PER_WEEK(1, 16.5),

    TWO_LESSONS_PER_WEEK(2, 16.5),

    THREE_LESSONS_PER_WEEK(3, 13.33),

    UNLIM(4, 185);

    private int lessonsPerWeek;

    private double price;

    Tariff(int lessonsPerWeek, double price) {
        this.lessonsPerWeek = lessonsPerWeek;
        this.price = price;
    }

    public int getLessonsPerWeek() {
        return lessonsPerWeek;
    }

    public double getPrice() {
        return price;
    }
}
