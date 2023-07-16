package academy.devdojo.maratonajava.javacore.Oexception.exception.test;

import academy.devdojo.maratonajava.javacore.Oexception.exception.model.LoginInvalidoException;

import java.io.IOException;
import java.util.Scanner;

public class LoginInvalidoExceptionTest01 {
    public static void main(String[] args) {
        try {
            logar();
        } catch (LoginInvalidoException e) {
            e.printStackTrace();
        }
    }

    private static void logar() throws LoginInvalidoException { // Exception do tipo checked
        Scanner teclado = new Scanner(System.in);
        String usernameDB = "Goku";
        String senhaDB = "ssj";

        System.out.println("Usuário");
        String usernameDigitado = teclado.nextLine();
        System.out.println("Senha");
        String senhaDigitada = teclado.nextLine();

        if (!usernameDB.equals(usernameDigitado) && !senhaDigitada.equals(senhaDB)) {
            throw new LoginInvalidoException("Usuário ou senha inválidos.");
        }

        System.out.println("Usuário logado com sucesso.");
    }
}
