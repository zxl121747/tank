package com.tank;

import java.util.Scanner;

public class Demo {
    // switch  必须加break
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            switch (s) {
                case "1":
                    System.out.println(1);
                case "2":
                    System.out.println(2);
                    break;
                case "3":
                    System.out.println(3);
            }
        }
    }
}
