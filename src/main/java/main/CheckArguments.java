package main;

import java.io.File;
import java.util.ArrayList;

class CheckArguments {
    boolean checkArguments( String typeOfData, String outputFileName, ArrayList<String> inputFilesName){

        if( !typeOfData.equals("-i") && !typeOfData.equals("-s") ){
            System.out.println("Аргумент должен иметь значиние -i или -s");
            return false;
        }

        File out = new File( outputFileName );
        if( !out.exists() || out.isDirectory() ){
            System.out.println("Нет файла " + out + " или он не является файлом");
            return false;
        }

        for( String ifn : inputFilesName ){
            File f = new File(ifn);
            if( !f.exists() || f.isDirectory() ){
                System.out.println( "Нет файла " +  ifn + " или он не является файлом");
                return false;
            }
        }

        return true;
    }
}
