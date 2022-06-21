/*Написать программу, показывающую последовательность 
действий для игры “Ханойская башня” */

public class tower_of_hanoi {
    public static void towerOfHonoi(int a, char start, char end, char bufer) {
        if (a == 1) {
            System.out.println("1 c " + start + " на " + end);
            return;
        }

        towerOfHonoi(a - 1, start, bufer, end);
        System.out.printf("%d c %s на %s ",a,start,end);
        System.out.println();
        towerOfHonoi(a - 1, bufer, end, start);
    }

    public static void main(String[] args) {
        int d = 3;
        towerOfHonoi(d, 'A', 'B', 'C');
    }

}
