package academy.devdojo.maratonajava.introduction;

public class Aula06EstruturasRepeticao01 {
    public static void main(String[] args) {
        // while, do while, for
        int count = 0;
        while (count <= 10) {
            System.out.println(count);
            count++;
        }

        count = 0;
        do {
            System.out.println(count);
            count++;
        } while (count <= 10);

        for (count = 0; count <= 15; count++) {
            System.out.println(count);
        }
    }
}
