public class SynchronizedDemo {
    public synchronized void method() {
        // 具体代码
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }

    public synchronized static void staticMethod() {
        // 具体代码
    }

    public void block() {
        synchronized (this) {
            // 具体代码
        }
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            while (true) {
                object.method();
            }
        }
        private SynchronizedDemo object;
        MyThread(SynchronizedDemo object) {
            this.object = object;
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo object = new SynchronizedDemo();
        Thread t = new MyThread(object);
        t.start();
        while (true) {
            object.method();
        }
    }
}
