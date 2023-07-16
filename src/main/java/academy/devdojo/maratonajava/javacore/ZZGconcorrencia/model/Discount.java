package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.model;

public class Discount {

    //storeName:price:discountCode
    public enum Code {
        NONE(0), SUPER_SAYAJIN(5), SUPER_SAYAJIN2(10), SUPER_SAYAJIN3(15);
        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }

        public int getPercentage() {
            return percentage;
        }
    }
}
