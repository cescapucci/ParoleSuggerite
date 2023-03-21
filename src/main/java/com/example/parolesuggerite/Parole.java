package com.example.parolesuggerite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parole {

    public static ArrayList<String> parole = new ArrayList<>();

    /**
     * lo riempie con le parole  da file
     */
    public static void riempi ()throws IOException {
        System.out.println("buongiornissimo");
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("C:\\\\Users\\\\francesca\\\\Desktop\\\\ParoleSuggerite\\\\src\\\\main\\\\java\\\\com\\\\example\\\\parolesuggerite\\\\Parole"));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                // read next line
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //guardo se ha caricato
        System.out.println("arrayList di parole da file");
        for (int i=0; i< parole.size();i++){
            System.out.println(parole.get(i));
        }
    }

    public int getSize(){
        return parole.size();
    }
}

/**
 * try{
 *             leggi = new BufferedReader(new FileReader("C:\\Users\\francesca\\Desktop\\ParoleSuggerite\\src\\main\\java\\com\\example\\parolesuggerite\\Parole"));
 *             for(int i=0; leggi.readLine() == null; i++)
 *                 tmp = leggi.readLine();
 *                 System.out.println(tmp);
 *                 parole.add(tmp);
 *         }finally {
 *             if(leggi != null)
 *                 leggi.close();
 *         }
 *
 *         System.out.println("array di parole");
 *         for (int i=0; i< parole.size();i++){
 *             System.out.println(parole.get(i));
 *         }
 */