import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ThreadPoolResponseTest {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        long startTime = System.nanoTime();
        //        work1();
        //        work2();
        scheduledExecutorService.submit(() -> {
            System.out.println("work1");
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        scheduledExecutorService.submit(() -> {
            System.out.println("work2");
        });


        long endTime = System.nanoTime();

        System.out.println("Task Time : " + (endTime - startTime));

    }

    public static void work1() throws InterruptedException {
        System.out.println("work1");
        Thread.sleep(5000L);

    }

    public static void work2(){
        System.out.println("work2");
    }

}
