package stackImplementation;

public class ImplementedStack implements Stack{

    private Node topNode = null;

    @Override
    public void push(Object item) throws UserDefinedException {
        Node node = new Node(item, topNode);
        topNode = node;
    }

    @Override
    public void pop() throws UserDefinedException {
        if(empty()){
            throw new UserDefinedException("Lista este vida!");
        }
        topNode = topNode.link;
    }

    @Override
    public Object peek() throws UserDefinedException {
        if(empty()){
            throw new UserDefinedException("Lista este vida!");
        }
        return topNode.item;
    }

    @Override
    public boolean empty() {
        return (topNode == null);
    }

    @Override
    public String toString(){
        String s = "";
        Node node = topNode;
        while (node != null){
            s += (node.item).toString()+ " ";
            node = node.link;
        }
        return s;
    }
}
