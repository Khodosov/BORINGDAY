package ru.spbu.apmath.sem2.project;

public class Product {
    private final String name;
    private final double score;
    private final String genre1;
    private final String genre2;
    private final String descr;


    public Product(String name, double score, String genre1, String genre2, String descr) {
        this.descr = descr;
        this.name = name;
        this.score = score;
        this.genre2 = genre2;
        this.genre1 = genre1;
    }

    // Выводим информацию
    @Override
    public String toString() {
        return String.format(" | Название: %s | Оценка: %s | Жанр: %s | Жанр: %s | Описание: %s",
                this.name, this.score,this.genre1, this.genre2, this,descr);
    }
}
