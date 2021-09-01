package lesson4;

public class Homework {

    private static final int COUNT = 20;

    private volatile char currentLetter = 'A';
    private final Object monitor = new Object();

    public static void main(String[] args) {
        Homework printApp = new Homework();
        Thread threadA = new Thread(() -> {
            printApp.PrintA();
        });
        Thread threadB = new Thread(() -> {
            printApp.PrintB();
        });
        Thread threadC = new Thread(() -> {
            printApp.PrintC();
        });
        threadA.start();
        threadB.start();
        threadC.start();
    }

    private void PrintA() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < COUNT; i++) {
                    while (currentLetter != 'A') {
                        monitor.wait();
                    }
                    System.out.print("A");
                    currentLetter = 'B';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void PrintB() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < COUNT; i++) {
                    while (currentLetter != 'B') {
                        monitor.wait();
                    }
                    System.out.print("B");
                    currentLetter = 'C';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void PrintC() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < COUNT; i++) {
                    while (currentLetter != 'C') {
                        monitor.wait();
                    }
                    System.out.print("C");
                    currentLetter = 'A';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
