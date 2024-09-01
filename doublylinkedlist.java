public class doublylinkedlist {
    public class node{
        int data;
        node next;
        node prev;

        public node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;

        }
    }
    public static node head;
    public static node tail;
    public static int size;

    //add
    public void addFirst(int data){
        node newNode = new node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    //print
    public void print(){
        node temp = head;
        while(temp != null){
            System.out.print(temp.data + "<->");
            temp = temp.next;

        }
        System.out.println("null");
    }
    //remove - removefirst
    public int removeFirst(){
        if(head == null){
            System.out.println("DLL IS EMPTY");
            return Integer.MIN_VALUE;
        }
        if (size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public void reverse(){
        node curr = head;
        node prev = null;
        node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;

        }
        head = prev;
    }



    public static void main(String args[]){
        doublylinkedlist dll = new doublylinkedlist();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);

        //dll.print();
        //System.out.println(dll.size);

        //dll.removeFirst();
        //dll.print();
        //System.out.println(dll.size);

        dll.print();
        dll.reverse();
        dll.print();


    }
}
