package stackImplementation;

public interface Stack {
    void push(Object item) throws UserDefinedException;
    void pop() throws UserDefinedException;
    Object peek() throws UserDefinedException;
    boolean empty();
    String toString();
}
