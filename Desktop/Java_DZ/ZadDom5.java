import java.util.*;

/*Задано уравнение вида q + w = e, q, w, e >= 0. 
Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69. 
Требуется восстановить выражение до верного равенства. 
Предложить хотя бы одно решение или сообщить, что его нет. */

public class ZadDom5 {
    static char[] textGlobal;
    static List<Integer> indexGlobal;

    public static void main(String[] args) {
        String text = "2?+?5=?8";

        char[] textchar = text.replace(" ", "").toCharArray();
        ArrayList<Integer> indQest = new ArrayList<>();

        for (int i = 0; i < textchar.length; i++) {
            if (textchar[i] == '+' || textchar[i] == '=') {
                textchar[i] = '-';
            }
            if (textchar[i] == '?') {
                indQest.add(i);
            }
        }
        // String[] num = String.valueOf(textchar).split("-");
        textGlobal = textchar;
        indexGlobal = indQest;
        valueOptions(new int[indexGlobal.size()], 0, 10);

    }

    public static void valueOptions(int[] comb, int index, int k) {
        if (index == comb.length) {
            checComb(comb);
            return;
        }
        for (int i = 0; i < k; i++) {
            comb[index] = i;
            valueOptions(comb, index + 1, k);

        }

    }

    public static void checComb(int[] comb) {
        for (int i = 0; i < comb.length; i++) {
            textGlobal[indexGlobal.get(i)] = Character.forDigit(comb[i], 10);
        }
        String[] num = String.valueOf(textGlobal).split("-");
        int a = Integer.parseInt(num[0]);
        int b = Integer.parseInt(num[1]);
        int c = Integer.parseInt(num[2]);
        if (a + b == c) {
            System.out.printf("%d + %d = %d", a, b, c);
            System.out.println();
        }

    }

}
