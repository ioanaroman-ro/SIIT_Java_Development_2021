public class ThreadsRandomSumMain_v1 {

    public static void main(String[] args) {
        RandomNumberGenerator one = new RandomNumberGenerator();
        RandomNumberGenerator two = new RandomNumberGenerator();
        RandomNumberGenerator three = new RandomNumberGenerator();
        RandomNumberGenerator four = new RandomNumberGenerator();
        RandomNumberGenerator five = new RandomNumberGenerator();

        try {
            one.start();
            two.start();
            three.start();
            four.start();
            five.start();
        } catch (IllegalThreadStateException e) {
            System.out.println("Thread already started.");
        }

        try {
            one.join();
            two.join();
            three.join();
            four.join();
            five.join();
        } catch (InterruptedException e) {
            System.out.println("Threads interrupted");
        }

        int sum = one.getNumber() + two.getNumber() + three.getNumber() + four.getNumber() + five.getNumber();

        System.out.println("Suma v1 este: " + sum);

    }
}
