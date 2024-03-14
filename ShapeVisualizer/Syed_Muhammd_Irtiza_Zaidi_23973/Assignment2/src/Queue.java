public class Queue {
   private Node head;
   protected Node tail;

   //ADDING INTO QUEUE
   public void Enqueue(Shape shape){
       if(head==null){
           head=new Node(shape);
           tail=head;
       }
       else{
           Node current=new Node(shape);
           tail.next=current;
           tail=current;
       }
   }

   //CHECK IF QUEUE IS EMPTY
    public boolean isEmpty() {
        return head == null;
    }


    //REMOVING FROM QUEUE
    public Shape Dequeu(){
       if(head==null) return null;
       else {
           Shape ret = head.shape;
           head = head.next;
           return ret;
       }
   }


}
