public class rotatearray {

    public static void rotate(int numbers[] , int k){
        reverse(numbers,0,numbers.length-1);
        reverse(numbers,0,k-1);
        reverse(numbers,k,numbers.length-1);


    }

    public static void reverse(int numbers[] , int start, int end){
        while(start<end){
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int number[] = {1, 2, 3, 4, 5, 6, 7};  // o/p // 5,6,7,1,2,3,4
        int k = 3;

        rotate(number, k);
        for(int i = 0; i<number.length; i++ ){
            System.out.print(number[i]+ " ");
        }
        System.out.println();

    }
    
}
