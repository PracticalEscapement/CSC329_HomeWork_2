package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void heapsort(House[] a) {
        PriorityQueueHeap pqh = new PriorityQueueHeap();
        for (int i=0; i<a.length; i++) {
            pqh.addHouse(a[i]);
        }
        int sortedNextOpen = 0;
        while (!pqh.isEmpty()) {
            a[sortedNextOpen] = pqh.getMostExpensive();
            sortedNextOpen++;
        }
    }
    public static void main(String[] args) {

        PriorityQueueHeap pqh = new PriorityQueueHeap();

        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String owner  = scanner.nextLine();
                int value = Integer.parseInt(scanner.nextLine());
                House house = new House();
                house.setOwner(owner);
                house.setValue(value);
                pqh.addHouse(house);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        PriorityQueueHeap copy = pqh.deepCopy();
        PriorityQueueHeap pqhCopy = new PriorityQueueHeap(copy);


        System.out.println(pqh.getLength());
        System.out.println(pqh.getMostExpensive().getValue());
        System.out.println(pqh.getMostExpensive().getValue());
        System.out.println(pqh.getMostExpensive().getValue());
        System.out.println(pqh.getLength());
        System.out.println(pqh.getMostExpensive().getValue());
        System.out.println(pqh.getMostExpensive().getValue());
        System.out.println(pqh.getLength());

        ArrayList<House> list = new ArrayList<>();

        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String owner  = scanner.nextLine();
                int value = Integer.parseInt(scanner.nextLine());
                House house = new House();
                house.setOwner(owner);
                house.setValue(value);
                list.add(house);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        House[] houses = list.toArray(new House[0]);
        for (House house : houses) {
            System.out.print(house.getValue() + ", ");
        }

        heapsort(houses);
        System.out.println("\n\n");

        for (House house : houses) {
            System.out.print(house.getValue() + ", ");
        }



    }
}