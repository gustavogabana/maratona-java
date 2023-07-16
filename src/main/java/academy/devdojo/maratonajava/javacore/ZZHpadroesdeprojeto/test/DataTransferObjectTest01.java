package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.model.*;

public class DataTransferObjectTest01 {
    public static void main(String[] args) {
        Aircraft aircraft = new Aircraft("777");
        Country country = Country.BRAZIL;
        Currency currency = CurrencyFactory.newCurrency(country);
        Person person = new Person.PersonBuilder()
                .firstName("Willaim")
                .lastName("Suane")
                .build();

        ReportDTO reportDTO = ReportDTO.ReportDTOBuilder.builder()
                .aircraftName(aircraft.getName())
                .country(country)
                .currency(currency)
                .personName(person.getFirstName() + person.getLastName())
                .build();

        System.out.println(reportDTO);
    }
}
