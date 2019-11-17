//练习题
public class CreateThread2 {
    private static class p1 extends Thread {
        long sum = 0;

        @Override
        public void run() {
            for (int i = 0; i <= 10000000; i++) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    private static class p2 extends Thread {
        long sum = 0;

        @Override
        public void run() {
            for (int i = 0; i <= 10000000; i = i + 2) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    private static class p3 extends Thread {
        long sum = 0;

        @Override
        public void run() {
            for (int i = 0; i <= 10000000; i++) {
                sum += i ^ 2;
            }
            System.out.println(sum);
        }
    }


    public static void main(String[] args) {
        new p1().start();
        new p2().start();
        new p3().start();
    }
}
