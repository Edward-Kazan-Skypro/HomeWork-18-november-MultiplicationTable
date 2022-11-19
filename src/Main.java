import java.util.HashSet;

public class Main {

    public static HashSet<Integer> numbersSet = new HashSet<>();

    static int normal_number;
    static int reverse_number;
    public static void fillSet() {

        while (numbersSet.size() < 15) {
            String firstNumber = String.valueOf((int) (Math.random() * 8 + 2));
            String secondNumber = String.valueOf((int) (Math.random() * 8 + 2));
            normal_number = Integer.parseInt((firstNumber) + (secondNumber));
            reverse_number = Integer.parseInt((secondNumber) + (firstNumber));
            if (!(numbersSet.contains(normal_number)) & (!numbersSet.contains(reverse_number))) {
                numbersSet.add(normal_number);
            }
        }
    }
    //Комментарий к реализации:
    //Пробовал использовать метод reverse() из StringBuilder.
    //Создавал объект StringBuilder из двух строковых переменных (случайные числа перевел в строку).
    //Потом делал проверку объекта StringBuilder и "инверсированного" этого же объекта в списке.
    //Но, без переопределния методов equals() и hashCode(), объекты StringBuilder корректно не сравниваются.
    //Поэтому пришлось "реверс" делать "руками",
    //создав новую переменную, поменяв местами первое и втрое число.
    //И уже эти два числа проверять на наличие в списке.

    public static void viewQuestions() {
        System.out.println("Вопросы для учеников из таблицы умножения:");
        for (Integer n : numbersSet) {
            String bufferString = String.valueOf(n);
            String s1 = bufferString.substring(0, 1);
            String s2 = bufferString.substring(1, 2);
            System.out.println(s1 + "*" + s2 + "=");
        }
    }

    public static void main(String[] args) {
        fillSet();
        viewQuestions();
    }
}