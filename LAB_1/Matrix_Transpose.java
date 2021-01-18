package LAB_1;

public class Matrix_Transpose {
    public static void main(String[] args){
        if(args.length<1){
            System.out.println("Program Usage: java Matrix_Transpose rows columns <matrix data>");
        }
        int rows = Integer.parseInt(args[0]);
        int columns = Integer.parseInt(args[1]);
        int m[][] = new int[rows][columns];
        int m_t[][] = new int[columns][rows];
        int k=2;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                m[i][j] = Integer.parseInt(args[k]);
                m_t[j][i]=m[i][j];
                k++;
            }
        }
        System.out.println("Entered Matrix: \n");
        print_matrix(m);
        System.out.println("\nTranspose Of Matrix: \n");
        print_matrix(m_t);
        System.out.println("");
    }
    static void print_matrix(int m[][]){
        for(int i=0; i<m.length; i++){
            for(int j=0; j<m[0].length; j++){
                System.out.print("| "+m[i][j]+" ");
            }
            System.out.println("|");
        }
    }
}
