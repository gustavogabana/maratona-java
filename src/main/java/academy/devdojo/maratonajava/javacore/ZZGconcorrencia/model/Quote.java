package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.model;

public final class Quote {
    private final String store;
    private final double price;
    private final Discount.Code discountCode;

    private Quote(String store, double price, Discount.Code discountCode) {
        this.store = store;
        this.price = price;
        this.discountCode = discountCode;
    }

    /**
     * Creates new Quote object from the value following the pattern storeName:price:discount
     *
     * @param value containing storeName:price:discountCode
     * @return new Quote with values from @param value
     */
    public static Quote newQuote(String value) {
        String[] values = value.split(":");
        return new Quote(values[0], Double.parseDouble(values[1].replace(",", ".")), Discount.Code.valueOf(values[2].replace(",", ".")));
    }

    @Override
    public String toString() {
        return "Quote{" +
                "nome='" + store + '\'' +
                ", price=" + price +
                ", discountCode=" + discountCode +
                '}';
    }

    public String getStore() {
        return store;
    }

    public double getPrice() {
        return price;
    }

    public Discount.Code getDiscountCode() {
        return discountCode;
    }
}
