package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.model.Country;
import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.model.Currency;
import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.model.CurrencyFactory;

public class CurrencyFactoryTest01 {
    public static void main(String[] args) {
        Currency currency = CurrencyFactory.newCurrency(Country.BRAZIL);
        System.out.println(currency.getSymbol());
    }
}
