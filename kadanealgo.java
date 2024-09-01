public class kadanealgo {

    public static int kadanesAlgorithm(int[] numbers){
        int cs = 0;
        int ms = Integer.MIN_VALUE;
        boolean haspositive = false;

        for(int i = 0; i<numbers.length; i++){
            cs = cs+numbers[i];
            if(cs<0){
                cs = 0;
            }
            if(cs>ms){
                ms = cs;
            }else{
                haspositive = true;
            }
        }
        if(!haspositive && ms == Integer.MIN_VALUE){
            System.out.println("it conatains only negative numbers");
            return -1;
        }
        System.out.println("max subarray sum is " + ms);
        return ms;

    }
    public static void main(String[] args) {
        int[] numbers = {-2, -3, 4, -1,-2, 1, 5, -3};
        kadanesAlgorithm(numbers);

    }
}
