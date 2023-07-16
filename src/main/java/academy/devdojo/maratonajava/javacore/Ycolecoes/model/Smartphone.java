package academy.devdojo.maratonajava.javacore.Ycolecoes.model;

public class Smartphone {
    private String serialNumber;
    private String marca;

    public Smartphone(String serialNumber, String marca) {
        this.serialNumber = serialNumber;
        this.marca = marca;
    }

    /*
     * Reflexivo: x.equals(x) tem que ser true para tudo o que for diferente de null;
     * Simétrico: para x e y diferentes de null, se x.equals(y) == true logo y.equals(x) == true;
     * Transitividade: para x,y,z diferentes de null, se x.equals(y) == true e x.equals(z) == true logo y.equals(z) == true;
     * Consistente: x.equals(x) sempre retorna true se x for diferente de null;
     * Para x diferente de null, x.equals(null) == false;
     * */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false; // Se o objeto comparado for null, retorna false;
        if (this == obj) return true; // Se os objetos forem iguais, retorna true;
        if (this.getClass() != obj.getClass()) return false; // Se forem objetos de tipos diferentes, retorna false;
        Smartphone smartphone = (Smartphone) obj; // Tipa o objeto para Smartphone
        return serialNumber != null && serialNumber.equals(smartphone.serialNumber);
        // Retorna true se o serialNumber do objeto passado igual ao deste objeto.
    }


    /*
     * Se x.equals(y) == true, y.hashCode() = x.hashCode();
     * Se y.hashCode() == x.hashCode(), não necessariamente o y.equals(x) tem de ser true;
     * Se x.equals(y) == false, hashCode tem de ser diferente;
     * y.hashCode() != x.hashCode(), x.equals(y) deverá ser false;
     * */
    @Override
    public int hashCode() {
        return serialNumber == null ? 0 : this.serialNumber.hashCode();
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "serialNumber='" + serialNumber + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
