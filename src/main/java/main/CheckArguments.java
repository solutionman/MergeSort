package main;

import java.io.File;
import java.util.ArrayList;

class CheckArguments {
    boolean checkArguments(String typeOfSort, String typeOfData, String outputFileName, ArrayList<String> inputFilesName){

        if( !typeOfSort.equals("-a") && !typeOfSort.equals("-d") ){
            System.out.println("Первый аргумент должен иметь значение -a или -d");
            return false;
        }

        if( !typeOfData.equals("-i") && !typeOfData.equals("-s") ){
            System.out.println("Второй аргумент должен иметь значиние -i или -s");
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
