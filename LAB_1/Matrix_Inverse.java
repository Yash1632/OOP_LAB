public class Matrix_Inverse {
    public static void main(String[] args){
        if(args.length<1){
            System.out.println("Program Usage: java Matrix_Inverse <rows> <columns> <matrix data>");
            System.exit(0);
        }
        int rows = Integer.parseInt(args[0]);
        int columns = Integer.parseInt(args[1]);
        if(rows!=columns){
            System.out.println("Given Matrix should be a square matrix for its inverse to be found!!!\n please run the program again!!");
            System.exit(-1);
        }
        double matrix[][] = new double[rows][columns*2];
        //int Identity[][] = new int[rows][columns];
        int k=2;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                matrix[i][j] = Double.parseDouble(args[k]);
                //Identity[i][j] = 0;
                matrix[i][j+columns] = 0;
                if(i==j){
                    //Identity[i][j] = 1;
                    matrix[i][j+columns] = 1;
                }
                k++;
            }
        }
        System.out.println("\nGiven Matrix: ");
        print_matrix(matrix);
        //CALCULATING INVERSE
        double result[][] = inverse(matrix, rows);
        //PRINTING RESULT(IF ANY)
        System.out.println("Inverse of the matrix: \n");
        print_matrix(result);
        System.out.println("");
    }
    
    //FUNCTION TO CALCULATE INVERSE OF A GIVEN MATRIX
    static double[][] inverse(double A[][],int order){
        for(int i=0; i<order; i++){
            //test_print line
            //System.out.println("Row: "+(i+1));
            double temp = A[i][i];
            if(A[i][i]!=0){
                for(int j=0; j<order*2; j++){
                    A[i][j] /= temp;
                }
                //for debugging
                // System.out.println("Matrix After divide: ");
                // print_matrix(A);

                //Row transformation
                for(int j=0; j<order; j++){
                    if(j!=i){
                        if(A[j][i] != 0){
                            temp = A[j][i];
                            for(int k=0; k<order*2; k++){
                                A[j][k] -=temp*A[i][k];
                            }
                        }
                        //for debugging
                        // System.out.println("Matrix After row transformation: ");
                        // print_matrix(A);
                    }
                }
            }
        }
        //column transformation to make identity matrix
        for(int i=0; i<order; i++){
            if(A[i][i] != 0){  
                for(int j=0; j<order; j++){
                    if(i!=j){
                        //column transformation
                        if(A[i][j] != 0){
                            double temp = A[i][j];
                            for(int k=0; k<order; k++){
                                A[k][j] -=temp*A[k][i];
                                A[k][j+order] -=temp*A[k][i+order]; 
                            }
                        }
                        //for debugging
                        // System.out.println("Matrix After Column Transfoormation: ");
                        // print_matrix(A);
                    }
                }
            }
        }
        //checking if inverse exists
        boolean m_check = check(A, order);
        double r[][] = new double[order][order]; ;
        //if inverse exists
        if(m_check==true){
            for(int i=0; i<order; i++){
                for(int j=0; j<order; j++){
                    r[i][j] = A[i][j+order];
                }
            } 
        }
        //returning result matrix from augmented matrix
        return r;
    }
    //check if inverse exists or not
    static boolean check(double A[][], int order)
    {    
        boolean diagonal_elements_check = true, non_diagonal_check = false;
        //Identity Matrix Check
        for(int i=0; i<order; i++){
            if(A[i][i] == 0){
                diagonal_elements_check = false;
            }
            for(int j=0; j<order; j++){
                if(j!=i){
                    if(A[i][j] == 0 && A[j][i]==0){
                        non_diagonal_check = true;
                    }
                }
            }
        }
        //condition for existing inverse
        if(diagonal_elements_check==true && non_diagonal_check==true){
            return true;
        }
        //Condition for singular matrix
        else if(diagonal_elements_check==false && non_diagonal_check==true){
            System.out.println("Given Matrix Is a Singular Matrix!!\n\n No Inverse Exists!!!");
            System.exit(0);
        }
        //to check if code has any errors
        else{
            System.out.println("Recheck Code!!!");
            System.exit(0);
        }
        return true;
    }
    //to print matrix
    static void print_matrix(double A[][]){
        for(int i=0; i<A.length; i++){
            for(int j=0; j<A.length; j++){
                System.out.print("| "+A[i][j]+" ");
            }
            System.out.println("| ");
        }
    }
}