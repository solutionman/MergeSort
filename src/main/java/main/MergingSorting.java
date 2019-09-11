package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class MergingSorting{
    void mergeAndSort(String outputFile, String firstFile, String secondFile){

        try(
                BufferedReader reader1 = new BufferedReader( new FileReader( firstFile ) );
                BufferedReader reader2 = new BufferedReader( new FileReader( secondFile ) );
                BufferedWriter writer = new BufferedWriter( new FileWriter( outputFile ) )
        ){
            String line1;
            String line2;
            while( (line1 = reader1.readLine() ) != null && (line2 = reader2.readLine() ) != null ){
                System.out.println(line1 + " " + line2);
                int first = Integer.parseInt( line1 );
                int second = Integer.parseInt( line2 );
                if( first > second){
                    writer.write( Integer.toString(second) );
                    writer.newLine();
                    writer.write( Integer.toString(first) );
                    writer.newLine();
                } else {
                    writer.write( Integer.toString(first) );
                    writer.newLine();
                    writer.write( Integer.toString(second) );
                    writer.newLine();
                }
            }
        } catch( IOException e ){
            System.out.println("Ошибка при чтении файла " + e);
        }

    }
    void singleFile( String outputFile, String inputFile ){
        try(
                BufferedReader reader = new BufferedReader( new FileReader(inputFile) );
                BufferedWriter writer = new BufferedWriter( new FileWriter( outputFile ) )
                ){
            String line;
            while( (line = reader.readLine()) != null ){
                writer.write( line );
                writer.newLine();
            }

        } catch( IOException e ){
            System.out.println("Ошибка при обработке файла " + e);
        }
    }
}
