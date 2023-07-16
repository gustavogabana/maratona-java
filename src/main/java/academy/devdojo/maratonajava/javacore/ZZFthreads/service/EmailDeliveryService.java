package academy.devdojo.maratonajava.javacore.ZZFthreads.service;

import academy.devdojo.maratonajava.javacore.ZZFthreads.model.Members;

public class EmailDeliveryService implements Runnable {

    private final Members members;

    public EmailDeliveryService(Members members) {
        this.members = members;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " Começando a entregar os e-mails...");
        while (members.isOpen() || members.pendingEmails() > 0) {
            try {
                String email = members.retrieveEmail();
                if (email == null) continue;
                System.out.println(threadName + " Enviando para " + email);
                Thread.sleep(2000);
                System.out.println(threadName + " enviou com sucesso para " + email);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Todos os e-mails foram enviados com sucesso.");
    }
}
