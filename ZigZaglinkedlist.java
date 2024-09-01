public class ZigZaglinkedlist {
    public static class node{
        int data;
        node next;
    
        public node(int data){
            this.data =  data;
            this.next = null;
    
        }
    }
    public void addFirst(int data){
        node newNode = new node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void addLast(int data){
        node newNode = new node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    
    
    }

    public void print(){
        if (head == null){
            System.out.println("linked list is empty");
            return;
        }
        node temp = head;
        while(temp!=null){
            System.out.print(temp.data+ " -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public static node head;
    public static node tail;
    public static int size;

    public void zigZag(){
        //find mid
        node slow = head;
        node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        node mid = slow;

        //reverse 2nd half
        node curr = mid.next;
        mid.next = null;
        node prev = null;
        node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node left = head;
        node right = prev;
        node nextL , nextR;

        // alt merge - zig zag merge
        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }
    public static void main(String[] args) {
        ZigZaglinkedlist ll = new ZigZaglinkedlist();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        //1->2->3->4->5
        ll.print();
        ll.zigZag();
        ll.print();
    }

    
}
