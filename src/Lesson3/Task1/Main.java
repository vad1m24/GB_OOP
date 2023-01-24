package Lesson3.Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Notebook> list = new ArrayList<Notebook>();
        Notebook.fillingList(list);
        choiceOfOption(list);
    }

    private static void choiceOfOption(ArrayList<Notebook> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "Если хотите отсортировать список ноутбуков по цене, введите 1.\n" +
                "Если хотите отсортировать список ноутбуков по ОЗУ, введите 2.\n" +
                "Если хотите отсортировать список ноутбуков по ОЗУ и цене комплексно, введите 3.\n" +
                "Для выхода из консольного приложения, введите 0.\n");

        int number = sc.nextInt();
        if (number == 1) {
            Collections.sort(list, new SortedByPrice());
            System.out.println("\n~~~ Сортировка товаров по цене ~~~~~");
            for (Notebook notebook : list) {
                System.out.println(notebook.toString());
            }
            System.out.println();
            choiceOfOption(list);
        } else if (number == 2) {
            Collections.sort(list, new SortedByRam());
            System.out.println("\n~~~ Сортировка товаров по ОЗУ ~~~~~");
            for (Notebook notebook : list) {
                System.out.println(notebook.toString());
            }
            System.out.println();
            choiceOfOption(list);
        } else if (number == 3) {
            Collections.sort(list, new SortedComplex());
            System.out.println("\n~~~ Сортировка товаров по ОЗУ и цене комплексно ~~~~~");
            for (Notebook notebook : list) {
                System.out.println(notebook.toString());
            }
            System.out.println();
            choiceOfOption(list);
        } else if (number == 0) {
            System.out.println("Спасибо, что посетили наш каталог товаров. До свидания.");;
        } else {
            System.out.println("Введены некорректные данные, попробуйте снова.\n");
            choiceOfOption(list);
        }

    }
}

