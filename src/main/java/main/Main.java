package main;

public class Main{
    public static void main(String[] args){

        String message = args.length > 0 ? "Your arguments: " : "No arguments";
        System.out.println( message );
        for( String arg : args ){
            System.out.println( arg );
        }

    }
}
