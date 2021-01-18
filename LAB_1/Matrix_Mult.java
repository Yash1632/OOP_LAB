public class Matrix_Mult {

    public static void main(String[] args){
        if(args.length<1){
            System.out.println("Program Usage: java Matrix_Mult m1(rows columns) <m1 data> m2(rows columns) <m2 data>");
            System.exit(0);
        }
        int rows = Integer.parseInt(args[0]);
        int columns = Integer.parseInt(args[1]);
        int rows1 = Integer.parseInt(args[(rows*columns)+2]);
        int columns1 = Integer.parseInt(args[(rows*columns)+3]);
        int m1[][] = new int[rows][columns];
        int m2[][] = new int[rows1][columns1];
        int k=2,k1=(rows*columns)+4;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                m1[i][j] = Integer.parseInt(args[k]);
                k++;
            }
        }
        for(int i=0; i<rows1; i++){
            for(int j=0; j<columns1; j++){
                m2[i][j] = Integer.parseInt(args[k1]);
                k1++;
            }
        }
        if(columns==rows1){
            int r[][] = new int[rows][columns1];
            for(int i=0;i<rows; i++){
                for(int j=0; j<columns1; j++){
                    int z = 0;
                    for(int l=0;l<columns; l++){
                        z += m1[i][l]*m2[l][j];
                    }
                    r[i][j] = z;
                }
            }
            System.out.println("Resultant Matrix: \n");
            for(int i=0;i<rows; i++){
                for(int j=0; j<columns1; j++){
                    System.out.print("| "+r[i][j]+" ");
                }
                System.out.println("|");
            }
            System.out.println("");
        }
    }
}