package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPoolTest01 {
    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    private static void beeper() {
        Runnable r = () -> {
            System.out.println(LocalTime.now().format(formatter) + " Beep.");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
//        executor.schedule(r, 5, TimeUnit.SECONDS);
//        ScheduledFuture<?> scheduledFuture = executor.scheduleWithFixedDelay(r, 1, 5, TimeUnit.SECONDS);
        // FixedDelay soma o sleep da thread, ou runnable, com o delay
        ScheduledFuture<?> scheduledFuture = executor.scheduleAtFixedRate(r, 1, 5, TimeUnit.SECONDS);
        // FixedRate não soma o sleep da thread, mas se for maior que o rate, então o sleep prevalece
        executor.schedule((Runnable) () -> {
            System.out.println("Cancelando o scheduleWithFixedTimeDelay");
            scheduledFuture.cancel(false); // Deve interromper se estiver rodando: true or false
            executor.shutdown();
        }, 20, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        System.out.println(LocalTime.now().format(formatter));
        beeper();
    }
}
