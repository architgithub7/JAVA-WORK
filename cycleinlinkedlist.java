public class cycleinlinkedlist {
    public static class node{
        int data;
        node next;
    
        public node(int data){
            this.data =  data;
            this.next = null;
    
        }
    }
    public static boolean isCycle(){
        node slow = head;
        node fast = head;
        
        while(fast != null && fast.next != null){
            slow  = slow.next;
            fast  = fast.next.next;
            if(slow == fast){
                return true; // cycle exists
            }
        }
        return false;
    }
    public static void removecycle(){
        //detect cycle
        node slow = head;
        node fast = head;
        boolean cycle = false;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                cycle = true;
                break;
            }
            
            }
            if(cycle == false){
                return;
        }
        //find meeting point
        slow = head;
        node prev = null;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;

        }
        //remove cycle -> last.next = null
        prev.next = null;
        

    }
    public static node head;
    public static node tail;

    public static void main(String[] args) {
        //head = new node(1);
        //head.next = new node(2);
        //head.next.next = new node(3);
        //head.next.next.next = head;
        //1 -> 2 -> 3 -> 1
        //System.out.println(isCycle());
        head  = new node(1);
        node temp = new node(2);
        head.next = temp;
        head.next.next = new node(3);
        head.next.next.next = temp;

        //1 -> 2 -> 3 ->2
        System.out.println(isCycle());
        removecycle();
        System.out.println(isCycle());

    }
    
}
