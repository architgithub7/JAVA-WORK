public class Linkedlist{

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
public void addMiddle(int idx, int data){
    node newNode = new node(data);
    size++;
    node temp = head;

    int i = 0;

    while(i<idx-1){
        temp = temp.next;
        i++;
        
    }
    newNode.next = temp.next;
    temp.next = newNode;

    
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
public int removeFirst(){
    if(size == 0){
        System.out.println("linkedlist is empty");
        return Integer.MIN_VALUE;
    }else if(size == 1){
        int val = head.data;
        head=tail=null;
        size=0;
        return val;
    }
    int val = head.data;
    head = head.next;
    size--;
    return val;
}
public int removeLast(){
    if(size == 0){
        System.out.println("linkedlist is empty");
        return Integer.MIN_VALUE;
    }else if(size == 1){
        int val = head.data;
        head=tail=null;
        size=0;
        return val;
    }
    node prev = head;
    for(int i =0; i<size-2; i++){
        prev = prev.next;
    }
    int val = prev.next.data;
    prev.next = null;
    tail = prev;
    size--;
    return val;

}
public int itrSearch(int key){
    node temp = head;
    int i = 0;

    while(temp!=null){
        if (temp.data == key){
            return i;
        }
        temp = temp.next;
        i++;
    }
    //key not found
    return -1;
}
public void reverse(){
    node prev = null;
    node curr = head;
    node next;
    
    while(curr!=null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;

    }
    head = prev;
}
public void deleteNthfromend(int n){
    //calculate size
    int sz = 0;
    node temp = head;
    while(temp != null){
        temp = temp.next;
        sz++;
    }
    if(n == sz){
        head = head.next;
        return;
    }

    //sz-n
    int i =1;
    int itoFind = sz-n;
    node prev = head;
    while(i < itoFind){
        prev = prev.next;
        i++;
    }
    prev.next = prev.next.next;
    return;

}

public node FindMid(node head){
     node slow = head;
     node fast = head;

     while(fast!= null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
     }
     return slow;//slow 

}

public boolean checkPalindrome(){
    if(head == null || head.next == null){
        return true;
    }
    //step1 find mid
    node midNode = FindMid(head);

    //step2 - reverse 2nd half
    node prev = null;
    node curr = midNode;
    node next;

    while(curr != null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
     node right = prev;
     node left = head;

     //step2 - check left half and right half
     while(right != null){
        if(left.data != right.data){
            return false;
        }
        left = left.next;
        right = right.next;

     }
     return true;   
}



public static node head;
public static node tail;
public static int size;


public static void main (String args[]){
    Linkedlist ll = new Linkedlist();
   // ll.addFirst(2);
   // ll.addFirst(1);
   // ll.addLast(3);
    //ll.addLast(4);
    //ll.addMiddle(2,9);
    ll.addFirst(1);
    ll.addLast(2);
    ll.addLast(2);
    ll.addLast(1);
    ll.print();
    //System.out.println(ll.size);
   // ll.removeFirst();
    //ll.print();
    //ll.removeLast();
   // ll.print();
  // System.out.println(ll.itrSearch(2));
   //ll.reverse();
   //ll.print();
   //ll.deleteNthfromend(3);
   //ll.print();
   System.out.println(ll.checkPalindrome());


}
}

