package operatiimatematice;

import java.util.ArrayList;
import java.util.*;

public class Polinoame2 {
	String[] monomStr;
	ArrayList<Monom> monom = new ArrayList<Monom>();
	public int x;

	public Polinoame2(int x) {
		this.x = x;
	}

	public Polinoame2 add(Polinoame2 poli2) {
		// Definim polinomul rezultant in care vom memora suma
		Polinoame2 poli3 = new Polinoame2(x);

		for (int i = 0; i < this.monom.size(); i++) {
			// De mentionat ca in acest moment polinoamele sunt minime si
			// sortate
			int p1 = this.monom.get(i).getPutere();
			int c1 = this.monom.get(i).getCoeff();

			int i_pow = poli2.getIndexPutere(p1);
			if (i_pow == -1) {
				// Nu am gasit deci adaugam efectiv un nou monom
				poli3.monom.add(new Monom(c1, p1));
			} else {
				// Am gasit ceva in polinomul 2 deci sumam
				int p3 = poli2.monom.get(i_pow).getPutere();
				int c3 = poli2.monom.get(i_pow).getCoeff();
				poli3.monom.add(new Monom(c1 + c3, p3));
				// Eliminam ce avem deja
				poli2.monom.remove(i_pow);
			}
		}
		// Pasul final mai e sa adaugam ce a ramas in poli2
		for (int j = 0; j < poli2.monom.size(); j++) {
			int p2 = poli2.monom.get(j).getPutere();
			int c2 = poli2.monom.get(j).getCoeff();
			poli3.monom.add(new Monom(c2, p2));
		}
		return poli3;
	}

	private int getIndexPutere(int putere) {
		for (int i = 0; i < monom.size(); i++) {
			Monom mon = monom.get(i);
			if (putere == mon.getPutere())
				return i;
		}
		return -1;
	}
}
