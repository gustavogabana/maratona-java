package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.model;

public class ReportDTO {
    private String aircraftName;
    private Country coutry;
    private Currency currency;
    private String personName;

    public ReportDTO(String aircraftName, Country coutry, Currency currency, String personName) {
        this.aircraftName = aircraftName;
        this.coutry = coutry;
        this.currency = currency;
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "ReportDTO{" +
                "aircraftName='" + aircraftName + '\'' +
                ", coutry=" + coutry +
                ", currency=" + currency +
                ", personName='" + personName + '\'' +
                '}';
    }

    public static final class ReportDTOBuilder {
        private String aircraftName;
        private Country coutry;
        private Currency currency;
        private String personName;

        private ReportDTOBuilder() {

        }


        public static ReportDTOBuilder builder() {
            return new ReportDTOBuilder();
        }

        public ReportDTOBuilder aircraftName(String aircraftName) {
            this.aircraftName = aircraftName;
            return this;
        }

        public ReportDTOBuilder country(Country country) {
            this.coutry = country;
            return this;
        }

        public ReportDTOBuilder currency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public ReportDTOBuilder personName(String personName) {
            this.personName = personName;
            return this;
        }

        public ReportDTO build () {
            return new ReportDTO(aircraftName, coutry, currency, personName);
        }
    }
}
