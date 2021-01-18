public class Print_Table
{
    public static void main(String[] args){
        //string to integer conversion
        int number = Integer.parseInt(args[0]);
        //loop to print table to 10
        for(int i = 1; i<=10; i++){
            System.out.println(number+" * "+i+" = "+(number*i));
        }
        System.exit(0);
    }
}