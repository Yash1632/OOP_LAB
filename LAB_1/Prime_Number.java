package LAB_1;

public class Prime_Number {
    public static void main(String[] args){
        for(int i=2; i<=1000; i++){
            int j = 0;
            //loop to check if number is prime
            for(int k=2; k<i; k++){
                /* if condition to check divisiblity
                   from numbers between and number.
                   If divisible, then it is not prime */
                if(i%k==0){
                    j++;
                    break;
                }
            }
            //j==0 for prime and not=0 for non-prime
            if(j == 0){
                System.out.println(i);
            }
        }
    }
}