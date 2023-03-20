package com.example.parolesuggerite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parole {

    public ArrayList<String> parole = new ArrayList<>();

    /**
     * lo riempie con le parole  da file
     */
    public Parole() throws IOException {
        BufferedReader leggi = null;
        try{
            leggi = new BufferedReader(new FileReader("parole.txt"));
            for(int i=0; leggi.readLine() == null; i++)
                parole.add(leggi.readLine());
        }finally {
            if(leggi != null)
                leggi.close();
        }
    }
}
