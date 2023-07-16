package academy.devdojo.maratonajava.introduction;

public class Aula08ArraysMultidimensionais01 {
    public static void main(String[] args) {
        // 1,2,3,4,5 meses
        // 31,28,31,30,31 matriz

        int[][] matriz = new int[3][3];
        matriz[0][0] = 31;
        matriz[0][1] = 28;
        matriz[0][2] = 31;

        matriz[1][0] = 30;
        matriz[1][1] = 31;
        matriz[1][2] = 30;

        matriz[2][0] = 31;
        matriz[2][1] = 20;
        matriz[2][2] = 31;

//        for (int i = 0; i < matriz.length; i++) {
//            for (int j = 0; j < matriz[i].length; j++) {
//                System.out.println(matriz[i][j]);
//            }
//        }

        for (int[] coluna : matriz) {
            for (int linha : coluna) {
                System.out.println(linha);
            }
        }

    }
}
