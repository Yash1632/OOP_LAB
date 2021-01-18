package LAB_1;

public class Area_TSC {
    public static void main(String[] args){
        int l = Integer.parseInt(args[0]);
        int h = Integer.parseInt(args[1]);
        //calculating area of triangle 
        float area_t = area_of_triangle(l,h);
        //print area of triangle
        System.out.println("Area Of Triangle: "+area_t);
        //s --> side of square
        int s = Integer.parseInt(args[2]);
        //function call for area of square
        float area_s = area_of_square(s);
        //printing area of square
        System.out.println("Area Of Square: "+area_s);
        //r --> radius of circle
        int r = Integer.parseInt(args[3]);
        //function call to area of circle
        double area_c = area_of_circle(r);
        //printing area of circle
        System.out.println("Area Of Circle: "+area_c);
    }
    static float area_of_triangle(int l, int h){
        return (l*h)/2;
    }
    static float area_of_square(int s){
        return s*s;
    }
    static double area_of_circle(int r){
        return 3.14*r*r;
    }
}
