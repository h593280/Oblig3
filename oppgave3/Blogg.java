package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO; 
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	private Innlegg [] innleggtabell;
	private int nesteLedig;

	public Blogg() {
		innleggtabell = new Innlegg [20];
	}

	//konstruktør 
	public Blogg(int lengde) {
		innleggtabell = new Innlegg [lengde];
		nesteLedig = 0;
	}

	public int getAntall() {
		return nesteLedig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		
		for (int i = 0; i < nesteLedig; i++) {
			if(innlegg.erLik(innleggtabell[i])) {
				return i;
			}
		}
		
		return -1;
	}
		

	public boolean finnes(Innlegg innlegg) {

		int pos = finnInnlegg(innlegg);
		if(pos >= 0) {
			return true;
		} 
		
	return false;
	}

	//feil
	public boolean ledigPlass() {
		
		for (int i = 0; i < innleggtabell.length; i++) {
			if(innleggtabell[i] == null) {
				return true;
			}
		}
		
		return false;
		
	}
	
	public boolean leggTil(Innlegg innlegg) {

			if(ledigPlass() && !finnes(innlegg)) {
				innleggtabell[nesteLedig] = innlegg;
				nesteLedig++;
				return true;
				}
		
		return false;
		
		}
		
	
	public String toString() {
		
		// 2\nTEKST\n1\nOle Olsen\n23-10-2019\n0\nen tekst\nBILDE\n2\nOline Olsen\n24-10-2019\n0\net bilde\nhttp://www.picture.com/oo.jpg\n
	
	String svar = getAntall() + "\n";
	for (int i = 0; i < nesteLedig; i++) {
		svar += innleggtabell[i].toString();
	}
	
	return svar;
	
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}