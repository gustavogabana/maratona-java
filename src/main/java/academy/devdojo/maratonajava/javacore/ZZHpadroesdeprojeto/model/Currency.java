package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.model;

public interface Currency {
    String getSymbol();
}

class Real implements Currency {

    @Override
    public String getSymbol() {
        return "R$";
    }
}

class Dollar implements Currency {

    @Override
    public String getSymbol() {
        return "$";
    }
}
