import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator extends Thread implements Runnable{

    private int number;

    public RandomNumberGenerator() {
        this.number = number;
    }

    public void run() {
        number = ThreadLocalRandom.current().nextInt(1, 11);;
        System.out.print(number + " ");
    }

    public int getNumber() {
        return this.number;
    }
}
