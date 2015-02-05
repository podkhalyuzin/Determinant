/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.* ;

/**
 * 
 * @author pc
 */

class Det
 {
    public static double det(Double[][] matrix)
    {
        if(matrix[0].length!=matrix[1].length)
          {
            System.out.println("Матрица должна быть размером nxn");
            return 0;
          }
        if(matrix.length==2)
        return matrix[0][0]*matrix[1][1]-matrix[1][0]*matrix[0][1];
        double counter=0;
        for(int i=0;i<matrix[0].length;i++)
          {
                int l= matrix[0].length;
                Double[][] temp = new Double[l-1][l-1];
                for(int j=1;j<l;j++)
                 {
                     for(int k=0;k<i;k++)
                      {
                        temp[j-1][k]=matrix[j][k];  
                      }
                     for(int k =i+1;k<l;k++)
                      {
                         temp[j-1][k-1]=matrix[j][k]; 
                      }
                 }
               counter+=Math.pow(-1,i)*matrix[0][i]*det(temp);       
          }
        return counter;
    }
 }

public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
        // TODO code application logic here 
    Scanner scan = new Scanner(System.in);
    System.out.print("Введите размерность массива : ");
    int n = scan.nextInt();
    Double[][] test = new Double[n][n];
    for(int i =0;i<n;i++)
     {
         for(int j=0;j<n;j++)
          {
              System.out.print("Введите ["+i+"]"+"["+j+"]= ");
              test[i][j]=scan.nextDouble();
          }
     }
    System.out.println(Det.det(test));
    }
 }

