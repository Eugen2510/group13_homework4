package org.upper_lower_case.utils;

import java.util.Scanner;

public class ConsoleConnector {
    private static final Scanner scanner =  new Scanner(System.in);;
    private ConsoleConnector (){

    }

    public static Scanner getConnect(){
        return scanner;
    }

    public static void disConnect(){
        scanner.close();
    }

}
