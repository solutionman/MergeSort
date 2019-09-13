package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){

//        for( String a : args ){
//            System.out.println(a);
//        }

        if(args.length < 3 ){
            System.out.println("Недостаточно аргументов для выполнения программы.");
            System.exit(0);
        }

        String typeOfSort = "-a";
        int ac = 0;
        if( args[0].equals( "-a" ) || args[0].equals( "-d" ) ){
            typeOfSort = args[0];
            ac++;
        }
        //String typeOfSort = args[0];
        String typeOfData = args[ac];
        String outputFileName = args[ac + 1];
        ArrayList<String> inputFileName = new ArrayList<>(Arrays.asList(args).subList(ac + 2, args.length));

        CheckArguments checkArgs = new CheckArguments();
        if(!checkArgs.checkArguments( typeOfData, outputFileName, inputFileName )){
            System.out.println("Ошибка в аргументах, работа программы прекращена.");
            System.exit(0);
        }

        MergingSorting mergingSorting = new MergingSorting();

        if(inputFileName.size() == 1){

            System.out.println( "Входящий файл один, объединять не с чем, его содержимое будет внесено в исходящий файл " + outputFileName );
            mergingSorting.singleFile( outputFileName, inputFileName.get( 0 ) );

        } else {

            try{
                File tempFile = File.createTempFile( "tempFile", null );
                //String tempFileName = inputFileName.get( 0 );
                mergingSorting.singleFile( "tempFile", inputFileName.get( 0 ) );

                for( int i = 0; i < inputFileName.size() - 1; i++ )
                {
                    mergingSorting.mergeAndSort( outputFileName, "tempFile", inputFileName.get( i + 1 ), typeOfData );
                    mergingSorting.singleFile( "tempFile", outputFileName );
                }

                tempFile.deleteOnExit();

            } catch ( IOException e ){
                System.out.println("Ошибка при слиянии и сортировке файлов " + e);
            }

        }


    }
}
