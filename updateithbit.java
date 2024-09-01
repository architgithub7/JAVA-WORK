import java.util.Scanner;

public class updateithbit{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int oper = sc.nextInt();
        //oper =1 it is a set operation method
        //oper =0 it is clear operation method
        int n = 5; //0101
        int pos = 1;

        int bitMask = 1 << pos;
        if(oper == 1){
            //set
            int newNumber = bitMask | n;
            System.out.println(newNumber);
        }else{
            //clear
            int newBitMask = ~(bitMask);
            int newNumber = newBitMask & n;
            System.out.println(newNumber);
        }
    sc.close();
    }
}