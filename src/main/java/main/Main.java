package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

//        System.out.print( typeOfSort + " " + typeOfData + " " + outputFileName + " ");
//        for(String a : inputFileName){
//            System.out.print(a + " ");
//        }

        CheckArguments checkArgs = new CheckArguments();
        if(!checkArgs.checkArguments( typeOfSort, typeOfData, outputFileName, inputFileName )){
            System.out.println("Ошибка в аргументах, работа программы прекращена.");
            System.exit(0);
        }


        try(
            BufferedReader reader1 = new BufferedReader( new FileReader( inputFileName.get( 0 ) ) );
            BufferedReader reader2 = new BufferedReader( new FileReader( inputFileName.get( 1 ) ) )
        ){
            String line1;
            String line2;
            while( (line1 = reader1.readLine() ) != null && (line2 = reader2.readLine() ) != null ){
                System.out.println(line1 + " " + line2);
            }
        } catch( IOException e ){
            System.out.println("Ошибка при чтении файла " + inputFileName.get( 0 ));
        }
    }
}
