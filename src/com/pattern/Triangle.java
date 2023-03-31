package com.pattern;

public class Triangle {

    public static void main(String[] args) {

        triangle(5, 0);

    }

    static void triangle(int r, int c){

        if(r == 0){
            return;
        }
        if(c < r){
            System.out.print("*");
            triangle(r, c+1);
        }else{
            System.out.println();
            triangle(r-1, 0);
        }
    }
}
