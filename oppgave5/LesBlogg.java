package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

		try {

		//Åpne filen for lesning
		File filer = new File(mappe + filnavn);
		Scanner test = new Scanner(filer);
		int antall = Integer.parseInt(test.nextLine());
		
		//opprette blogg med antall
		Blogg nyBlogg = new Blogg(antall);
		
		
		//Les inn et innlegg og finn ut om det er tekst/bilde
		for (int i = 0; i < antall; i++) {
				
			//konvertere til riktige typer
			String type = test.nextLine();
			int id = Integer.parseInt(test.nextLine());
			String bruker = test.nextLine();
			String dato = test.nextLine();
			int likes = Integer.parseInt(test.nextLine());
			String tekst = test.nextLine();
			
			if(type.equals(BILDE)) {
				String url = test.nextLine();
				Bilde a = new Bilde(id, bruker, dato, likes, tekst, url);
				nyBlogg.leggTil(a);
			} else if(type.equals(TEKST)) {
				 Tekst b = new Tekst(id, bruker, dato, likes, tekst);
				 nyBlogg.leggTil(b);
			}
		}
		test.close();
		return nyBlogg;
		
		}
		
		
		catch(FileNotFoundException e) {
			
		}
		
		
		
		return null;

	}
}
