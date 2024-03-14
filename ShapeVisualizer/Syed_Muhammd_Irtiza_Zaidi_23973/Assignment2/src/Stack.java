public class Stack {
protected Node head;

    public Stack(){
    head=null;
}


     //ADD FROM STACK
    public void push(Shape shape) {
        if (head == null) {
            head = new Node(shape);
        } else {
            Node current = new Node(shape);
            current.next = head;
            head = current;
        }
    }

    //CHECL IF STACK IS EMPTY
    public boolean isEmpty() {
        return head == null;
    }

    //REMOVE FROM STACK
    public Shape pop(){
        Shape shape;
        if(head==null) return null;
        else {
            shape= head.shape;
            head=head.next;
        }
        return shape;

    }
}

