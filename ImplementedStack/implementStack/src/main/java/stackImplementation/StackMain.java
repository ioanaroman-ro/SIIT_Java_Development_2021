package stackImplementation;

public class StackMain {
    public static void main(String[] args) {
        try{
            Stack stack = new ImplementedStack();
            stack.push(new Customer());
            stack.push("Exemplu");
            stack.push(1);
            System.out.println("Elemente adaugate: \n" + stack);

            stack.pop();
            System.out.println("Element eliminat: \n" + stack);

            System.out.println("Varful din stack: \n" + stack.peek().toString());

        } catch (UserDefinedException e){
            System.err.println("Eroare stiva!");
            e.printStackTrace();
        }
    }
}
