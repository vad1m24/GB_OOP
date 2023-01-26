package Lesson4;

import java.util.List;

    // Реализовать хранение фруктов в коробке.
public class Box<T extends Fruit> {
    // Для внутреннего хранения можно использовать например List
    private List<T> list;

    // Должен быть конструктор
    public Box(List<T> list) {
        this.list = list;
    }

    // Добавление фрукта
    public void add(T fruit) {
        list.add(fruit);
    }
    // Получение веса фруктов в коробке
    public double getWeight() {
        double sum = 0;
        for (T fruits : list) {
            sum += fruits.getWeight();
        }
        return sum;
    }

    // Пересыпать фрукты из текущей коробки в anotherBox
    public void moveTo(Box<? super T> anotherBox) {
        for (T fruits : list) {
            anotherBox.add(fruits);
        }
        list.clear();
    }
}
