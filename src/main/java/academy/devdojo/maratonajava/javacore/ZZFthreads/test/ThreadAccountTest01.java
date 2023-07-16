package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

import academy.devdojo.maratonajava.javacore.ZZFthreads.model.Account;

public class ThreadAccountTest01 {

    private static final Account account = new Account();

    public static void main(String[] args) {
        Runnable r = () -> {
            for (int i = 0; i < 5; i++) {
                withdrawal(10);
                if (account.getBalance() < 0) {
                    System.out.println("FODEO!");
                }
            }
        };
        new Thread(r, "Hestia").start();
        new Thread(r, "Bell Cranel").start();
    }

    private static void withdrawal(int amount) {
        // Bloco de sincronização, não permitirá concorrência ao executa o código, recebe o objeto como parâmetro
        synchronized (account) {
            System.out.println(Thread.currentThread().getName() + "Valor da conta: " + account.getBalance());
            if (account.getBalance() >= amount) {
                System.out.println(Thread.currentThread().getName() + " está indo sacar dinheiro.");
                account.withdrawal(amount);
                System.out.println(Thread.currentThread().getName() + " saque completo! Valor atual: " + account.getBalance());
            } else {
                System.out.println("Sem dinheiro para " + Thread.currentThread().getName() + " sacar.");
            }
        }
    }
}
