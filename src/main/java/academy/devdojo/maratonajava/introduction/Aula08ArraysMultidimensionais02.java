package academy.devdojo.maratonajava.introduction;

public class Aula08ArraysMultidimensionais02 {
    public static void main(String[] args) {
        int[][] arrayInt = new int[3][];

        arrayInt[0] = new int[2];
        arrayInt[1] = new int[4];
        arrayInt[2] = new int[7];

        int[][] arrayInt2 = {{5, 4}, {4, 6, 19, 5, 1}, {54, 985, 10001, 245, 2, 7}};

        for (int[] x : arrayInt) {
            for (int y : x) {
                System.out.println(y);
            }
        }

        for (int[] a : arrayInt2) {
            for (int b : a) {
                System.out.println(b);
            }
        }
    }
}
