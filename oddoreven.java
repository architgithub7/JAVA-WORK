public class oddoreven{
    public static void checkOddorEven(int n){
        int bitmask = 1;
        if((n & bitmask) == 0){
            //even number
            System.out.println("even number");
        }else{
            System.out.println("odd number");
        }
    }
    public static void main(String[] args) {
        checkOddorEven(3);
        checkOddorEven(11);
        checkOddorEven(14);
    }
}