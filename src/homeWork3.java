import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class homeWork3 {
        /*Пусть дан произвольный список целых чисел, удалить из него четные числа*/
        /* Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка*/

        public static void main(String[]args) {
                List<Integer> lst = createListRandomInt(15, 0, 100);
                System.out.println(lst);
                lst = lst.stream().filter(x -> x % 2 != 0).toList();
                System.out.println(lst);
                System.out.println("Минимальное значение: " + Collections.min(lst));
                System.out.println("Максимальное значение: " + Collections.max(lst));
                System.out.println("Среднее значение: " + lst.stream().mapToInt(a -> a).average().orElse((Double.NaN)));
            }


    static List<Integer> createListRandomInt(int capacity, int min, int max) {
        Random rnd = new Random();
        List<Integer> lst = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            lst.add(rnd.nextInt(min, max));
        }
        return lst;
    }
}
