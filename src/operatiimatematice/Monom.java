package operatiimatematice;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Monom {

	public String monom;
	public int putere;
	public int coeficient;
	public double dcoef;
	private String[] buffer;

	/**
	 * 
	 * @param monom
	 *            Daca functia de validare este adevarata atunci deja avem
	 *            putearea si coeficientul. Ramane doar de actualizat valoarea
	 *            variabilei monom.
	 */
	public Monom(String monom) {
		if (validare(monom)) {
			this.monom = monom;
		}
		dcoef = (double) coeficient;
	}

	public Monom(int coeficient, int putere) {
		this.putere = putere;
		this.coeficient = coeficient;
		dcoef = coeficient;
		this.monom = format();
	}

	public Monom(double dcoef, int coeficient, int putere) {
		this.putere = putere;
		this.coeficient = coeficient;
		this.dcoef = dcoef;
		this.monom = format();
	}

	private String format() {
		String container = new String(this.dcoef + "x^" + this.putere);
		return container;
	}

	public void deriv() {
		if (putere != 0) {
			dcoef = dcoef * putere;
			coeficient = (int) dcoef;
			putere -= 1;
		}
	}

	public void integ() {
		putere++;
		dcoef = dcoef / putere;
		coeficient = (int) dcoef;
	}

	public boolean isNegative() {
		return (this.coeficient < 0) ? true : false;
	}

	public String getMonom() {
		return (putere == 0) ? Double.toString(dcoef) : (dcoef + "x^" + putere);
	}

	public void afisare() {
		System.out.println("Putere: " + putere + " Coeficient: " + coeficient + "\n");
	}

	public int getCoeff() {
		return this.coeficient;
	}

	public int getPutere() {
		return this.putere;
	}

	public int valoare(int x) {
		return (int) (dcoef * Math.pow(x, putere));
	}

	public double dValoare(double x) {
		return dcoef * Math.pow(x, putere);
	}

	public void addCoef(int x) {
		this.coeficient += x;
		this.dcoef = (double) coeficient;
	}

	public Monom times(Monom mon1) {
		Monom ret;
		double c = this.dcoef * mon1.dcoef;
		int d = (int) c;
		int p = this.getPutere() + mon1.getPutere();
		ret = new Monom(c, d, p);
		return ret;
	}

	public Monom divide(Monom divizor) {
		Monom ret;
		double c = this.dcoef / divizor.dcoef;
		int d = (int) c;
		int p = this.getPutere() - divizor.getPutere();
		ret = new Monom(c, d, p);
		return ret;
	}

	public static Comparator<Monom> getCompByPutere() {
		Comparator<Monom> comp = new Comparator<Monom>() {
			@Override
			public int compare(Monom s1, Monom s2) {
				return Integer.compare(s1.putere, s2.putere);
			}
		};
		return comp;
	}

	private boolean validare(String monom) {
		// Verificam daca exista caractere ciudate - cu exceptia lui ^
		if (!monom.matches("^[a-zA-Z0-9\\^\\*\\- ]*"))
			return false;
		Pattern polyFormat = Pattern.compile("\\^");
		Matcher m = polyFormat.matcher(monom);
		String s = new String();
		while (m.find()) {
			s = m.group();
		}
		if (s.isEmpty()) {
			// nu contine ^ =>
			buffer = monom.split("[a-zA-Z]");
			if (buffer.length == 0) {
				coeficient = 1;
				putere = 1;
			} else {
				coeficient = (!buffer[0].isEmpty()) ? Integer.parseInt(buffer[0]) : 1;
				putere = (buffer[0] == monom) ? 0 : 1;
			}
		} else {
			// contine ^ =>
			buffer = monom.split("\\^"); // acum avem ceva de genul 2x si 4
			try {
				String nrStr = new String();
				/*
				 * Bucata mica de cod de mai jos am preluat-o de pe
				 * StackOverflow
				 * http://stackoverflow.com/questions/4030928/extract-digits-
				 * from-a-string-in-java Pare a fi mai rapida si mai interesanta
				 * ca regex + split
				 */
				for (int i = 0; i < buffer[0].length(); i++) {
					char c = buffer[0].charAt(i);
					if (c == 45)
						nrStr += c;
					if (c > 47 && c < 58)
						nrStr += c;
				}
				coeficient = (nrStr.isEmpty()) ? 1 : Integer.parseInt(nrStr);
				putere = Integer.parseInt(buffer[1]);
			} catch (NumberFormatException e) { //
				System.out.println("Formatul nu este valid");
			}
		}
		return true;
	}

}
