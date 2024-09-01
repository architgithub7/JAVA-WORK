public class mergesortlinkedlist {
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

    private node getMid(node head){
        node slow = head;
        node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; //mid node
    }
    private node merge(node head1 , node head2){
        node mergedll = new node(-1);
        node temp = mergedll;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;

            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;

        }
        return mergedll.next;
    }

    public node mergeSort(node head){
        if(head == null || head.next == null){
            return head;
        }
        //find mid 
        node mid  = getMid(head);
        //left & right ms
        node rightHead =mid.next;
        mid.next = null;
        node newLeft = mergeSort(head);
        node newRight = mergeSort(rightHead);

        //merge
        return merge(newLeft , newRight);
    }
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
        mergesortlinkedlist ll = new mergesortlinkedlist();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        //5->4->3->2->1

        ll.print();
        ll.head = ll.mergeSort(ll.head);
        ll.print();





    }
    
}
