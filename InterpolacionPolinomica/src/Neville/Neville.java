package Neville;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Loli Delgado
 */
public class Neville {

    double[][] neville_table;
    double[] x_val;

    public Neville(int n) {
        neville_table = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                neville_table[i][j] = 0;
            }
        }
        x_val = new double[n];
        captura(n);
    }

    private void captura(int n) {
        Scanner s = new Scanner(System.in);
        double val;
        for (int i = 0; i < n; i++) {
            System.out.print("Valor de x" + i + ": ");
            val = s.nextDouble();
            x_val[i] = val;
            System.out.print("f(" + val + ") = ");
            neville_table[i][0] = s.nextDouble();
        }
        //imprimirValoresX();
        metodo_neville(n);
        System.out.println("\n");
        imprimirTabla(n);

    }

    private void imprimirTabla(int n) {
        System.out.println("Tabla de neville:");
        for (int i = 0; i < n; i++) {
            System.out.print(x_val[i] + "   ");
            for (int j = 0; j < n; j++) {
                System.out.printf("%.4f        ", neville_table[i][j]);
            }
            System.out.println("");
        }
    }

    private double f(double val) {
        return Math.sqrt(val);
    }

    private void metodo_neville(int n) {
        Scanner s = new Scanner(System.in);
        System.out.println("Valor de x a aproximar:");
        double x = s.nextDouble();

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                //  System.out.println("Valores que mando:\ni=" + i + "\nj=" + j);
                neville_table[i][j] = Q(x, i, j);
            }
        }
    }

    private double Q(double x, int i, int j) {
        /*System.out.println("----Fórmula:----");
         System.out.println("Valores que llegan:\nx = " + x + "\ni = " + i + "\nj = " + j);
         System.out.println("((x - x_val[i - j]) * (neville_table[i][j - 1])) - ((x - x_val[i]) * (neville_table[i - 1][j - 1]))/"
         + "(x_val[i] - x_val[i - j])");
         System.out.println("((" + x + " - " + x_val[i - j] + ") * (" + neville_table[i][j - 1] + ")) - ((" + x + " - " + x_val[i] + ")"
         + " * (" + neville_table[i - 1][j - 1] + "))/(" + x_val[i] + " - " + x_val[i - j] + ")");*/
        double num = ((x - x_val[i - j]) * (neville_table[i][j - 1])) - ((x - x_val[i]) * (neville_table[i - 1][j - 1]));
        double denom = x_val[i] - x_val[i - j];
        // System.out.println(num + " / " + denom);
        return (num / denom);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("\t\t\t\"METODO DE NEVILLE\"\n");
        System.out.println("\n¿Cuántos valores conoces?");
        int val_cono = s.nextInt();
        Neville n = new Neville(val_cono);
    }
//    private void imprimirValoresX() {
//        for (int i = 0; i < 5; i++) {
//            System.out.print(x_val[i] + " ");
//        }
//    }
}