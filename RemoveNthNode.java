package LinkedList;

public class RemoveNthNode {
    public class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next= head;
        head = newNode;
    }
    public void addlast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public void print(){
        Node temp = head;
        if(temp == null){
            System.out.println("List is empty");
            return;
        }
        while(temp != null){
            System.out.print(temp.data+"->");
            temp =  temp.next;
        }
        System.out.println("null");
    }
    public void reverse(){
        Node previous = null;
        Node current = tail = head;
        Node next ;
        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }
    public void deleteNthNode(int n){
        // calculate size
        int size = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        if(n==size){//remove first
            head = head.next;
            return;
        }
        int i = 1;
        int indexToFind= size-n;
        Node previous = head;
        while(i<indexToFind){
            previous = previous.next;
            i++;
        }
        previous.next = previous.next.next;
        return;

    }
    public static void main(String args []){
        RemoveNthNode list = new RemoveNthNode();
        list.addFirst(1);
        list.addlast(2);
        list.addlast(3);
        list.addlast(4);
        list.addlast(5);
        list.print();


        list.deleteNthNode(3);
        list.print();;
    }
}
