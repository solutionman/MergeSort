package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){

        if(args.length < 4 ){
            System.out.println("Недостаточно аргументов для выполнения программы.");
            System.exit(0);
        }

        String typeOfSort = args[0];
        String typeOfData = args[1];
        String outputFileName = args[2];
        ArrayList<String> inputFileName = new ArrayList<>(Arrays.asList(args).subList(3, args.length));

        System.out.print( typeOfSort + " " + typeOfData + " " + outputFileName + " ");
        for(String a : inputFileName){
            System.out.print(a + " ");
        }
        
    }
}
