/*
 * Programming Question
 * Version 1
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
import java.lang.*;
import java.io.File;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class assignment1 {
    public static void main(String[] args) throws IOException {

        int min = 2; //define min length of the string
        int max = 100; //define max length of the string
        Scanner sc = new Scanner(System.in); //create scanner
        System.out.println("Please name your output file:");
        String outPutFileName = sc.nextLine(); //read user input for the file name
        System.out.println("The string length is in between "+min+" and "+max+".");
        int length = getRandomInteger(min,max); //Calculate a random length within limits
        //int length = 30;
        System.out.println("The generated random length is: "+ length);
        System.out.println("Please type an integer no greater than the string length for number of * in the string:");
        int numOfStar = sc.nextInt(); //read user input for the number of * needed
        String input = generateBinaryString(length, numOfStar); //generate the input string for version 1 method
        System.out.println("The input is: ");
        System.out.println(input);
        //revealStr(input,0,outPutFileName);
        System.out.println("An out.txt file has been created.");
        System.out.println("Output is saved in the txt file");

        File f=new File(outPutFileName+".txt");
        f.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(f);
        PrintStream printStream = new PrintStream(fileOutputStream);
        System.setOut(printStream);

        System.out.println("The output is: ");

        long startTime = System.nanoTime();
        //revealStr(input,0); //Version 1 method
        revealStr(input,0);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("---------------------------------");
        System.out.println("The run time is: "+duration+" nanoseconds");


    }

    /**
     * This is a recursive way to find all possible sequences of binary strings
     * with masked "*" character at some positions.
     * @param str : the input string to be processed
     * @param index : the current index of pointer position
     */
    public static void revealStr(String str, int index) {

        //Convert String str into char
        char charStr[] = str.toCharArray();

        //End recursion condition: when the index meet String length get out of the recursion
        if(index == charStr.length){
            System.out.println(str);
            return;
        }

        //If the char at index is '*' then replace by '1' or '0'
        if(charStr[index] == '*'){

            charStr[index]='0'; //Replace '*' by '0'
            str = String.valueOf(charStr); //Convert char charStr back to String str
            revealStr(str, index+1); //Send the replaced str back to the revealStr method with index of "index+1"

            charStr[index]='1'; //Replace '*' by '1'
            str = String.valueOf(charStr); //Convert char charStr back to String str
            revealStr(str, index+1); //Send the replaced str back to the revealStr method with index of "index+1"

            charStr[index]='*'; //Backtrack as array is passed by reference to the function after converted back to String

            str = String.valueOf(charStr); //Convert char charStr back to String str
        }

        else{
            revealStr(str, index+1);
        }
    }

    /**
     * This is a get random integer method for length
     * @param max the max length of string
     * @param min the min length of string
     */
    private static int getRandomInteger(int min, int max) {
        Random ramInteger = new Random();
        return ramInteger.nextInt((max - min) + 1) + min;
    }

    /**
     * This is the method for generate a random string
     * @param n the length of the string
     * @param x the number of * needed in the string
     */
    static String generateBinaryString(int n, int x){

        StringBuilder builder = new StringBuilder(n);
        String res = "";

        String basePool = "01"; //Define the base pool for the 2 characters:'0','1'

        //Produce a string with n characters within the pool
        for (int i=0; i<n; i++){
            int index = (int)(basePool.length()*Math.random());
            builder.append(basePool.charAt(index));
        }

        //Create a list with n unique integers in random order
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<n; i++) {
            list.add(Integer.valueOf(i));
        }
        Collections.shuffle(list); //Shuffle to make the integer list random

        //Replace x characters in the string by *
        int counter = x-1;
        while(counter>=0){
            builder.setCharAt(list.get(counter),'*');
            counter--;
        }
        return builder.toString(); //Convert to string
    }
}
