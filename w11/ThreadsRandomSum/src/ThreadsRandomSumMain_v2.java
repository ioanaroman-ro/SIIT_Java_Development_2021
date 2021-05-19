import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadsRandomSumMain_v2 {
    public static void main(String[] args) {
        RandomNumberGenerator one = new RandomNumberGenerator();
        RandomNumberGenerator two = new RandomNumberGenerator();
        RandomNumberGenerator three = new RandomNumberGenerator();
        RandomNumberGenerator four = new RandomNumberGenerator();
        RandomNumberGenerator five = new RandomNumberGenerator();

        List<RandomNumberGenerator> threads = new ArrayList<>(Arrays.asList(one, two, three, four, five));
        int sum1 = 0;

        for (RandomNumberGenerator rg : threads){
            try {
                rg.start();
                rg.join();
                sum1 += rg.getNumber();
            } catch (IllegalThreadStateException e){
                System.out.println("Thread " + rg.getName() + " already started.");
            }
            catch (InterruptedException e) {
                System.out.println("Thread " + rg.getName()+ " interrupted.");
            }
        }

        System.out.println("Suma cu colectii este: " + sum1);
    }
}
