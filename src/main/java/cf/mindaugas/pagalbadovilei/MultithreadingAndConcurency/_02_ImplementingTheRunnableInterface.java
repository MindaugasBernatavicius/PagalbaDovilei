package cf.mindaugas.pagalbadovilei.MultithreadingAndConcurency;

public class _02_ImplementingTheRunnableInterface {
    public static void main(String[] args) throws InterruptedException {
        Thread stopWatchThread = new Thread(new StopWatchThreadWRunnable());
        stopWatchThread.start();
        System.out.println("Main thread starts");
        Thread.sleep(5000);
        System.out.println("Main thread is still running");
        Thread.sleep(5000);
        System.out.println("Main thread ends");
    }
}

class StopWatchThreadWRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Stop watch: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}