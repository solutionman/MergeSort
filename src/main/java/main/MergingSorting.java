package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class MergingSorting{
    void mergeAndSort(String outputFile, String firstFile, String secondFile){

        try(
                BufferedReader reader1 = new BufferedReader( new FileReader( firstFile ) );
                BufferedReader reader2 = new BufferedReader( new FileReader( secondFile ) )
        ){
            String line1;
            String line2;
            while( (line1 = reader1.readLine() ) != null && (line2 = reader2.readLine() ) != null ){
                System.out.println(line1 + " " + line2);
            }
        } catch( IOException e ){
            System.out.println("Ошибка при чтении файла " + e);
        }

    }
}
