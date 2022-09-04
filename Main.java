package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int [] linearSearch(byte[] arr, int elementToSearch) {
        int index = -1;
        int size = 1;
        int i = 0;
        int [] indexes = new int [size];
            for (index = 0; index < arr.length; index++) {
                if (arr[index] == elementToSearch) {
                    indexes[i] = index;
                    size++;
                    i++;
                }
            }

        return indexes;
    }
    public static void print(int elementToSearch, int [] index) {
        for(int i = 0; i < index.length;i++) {
            if (index[i] == -1) {
                System.out.println(elementToSearch + " not found.");
            } else {
                System.out.println(elementToSearch + " found at index: " + index[i]);
            }
        }
    }

    public static void main(String[] args) {
        int number = 0;
        Scanner in = new Scanner(System.in);
        try{
            System.out.println("Введите число для поиска: ");
            number = in.nextInt();
        }catch(NumberFormatException ex){
            System.out.println(ex.getMessage());
        }
        File file = new File("C://Users//PC//IdeaProjects//untitled//sort.dat");
        byte[] buffer = new byte[0];
        try(FileInputStream fos=new FileInputStream("C://Users//PC//IdeaProjects//untitled//sort.dat"))
        {
            buffer = fos.readAllBytes();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
       print(number,linearSearch(buffer,number));
    }
}
