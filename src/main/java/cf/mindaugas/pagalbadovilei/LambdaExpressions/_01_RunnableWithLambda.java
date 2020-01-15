package cf.mindaugas.pagalbadovilei.LambdaExpressions;

public class _01_RunnableWithLambda {

    public static void meth(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Stop watch: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // 0. ... Using the classical way to initialize new threads w/ Runnable

        // Thread stopWatchThread = new Thread(new StopWatchThreadWRunnable2());
        // stopWatchThread.start();
        // System.out.println("Main thread starts");
        // Thread.sleep(5000);
        // System.out.println("Main thread is still running");
        // Thread.sleep(5000);
        // System.out.println("Main thread ends");


        // 1. ... Using lambdas to init threads w/ Runnable
        // () -> {}
        // () -> return 0;
        // (String a, String b) -> { return a + b };
        Thread stopWatchThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Stop watch: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 2. ... calling a method from lambda
        // Thread stopWatchThread = new Thread(() -> { meth(); });

        // 3. ... calling a method using a method reference
        // Thread stopWatchThread = new Thread(_01_RunnableWithLambda::meth);


        stopWatchThread.start();
        System.out.println("Main thread starts");
        Thread.sleep(5000);
        System.out.println("Main thread is still running");
        Thread.sleep(5000);
        System.out.println("Main thread ends");
    }
}

class StopWatchThreadWRunnable2 implements Runnable {
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
