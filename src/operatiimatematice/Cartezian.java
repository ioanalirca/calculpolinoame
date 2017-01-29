package operatiimatematice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Cartezian extends JPanel {
	int size;
	static double maxValue;
	Polinom poli;

	public Cartezian(int s, double v) {
		size = s;
		maxValue = v;
		setPreferredSize(new Dimension(size, size));
	}

	public void setPoli(Polinom poli) {
		this.poli = poli;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(size / 2, 0, size / 2, size);
		g.drawLine(0, size / 2, size, size / 2);
		double[] tick = getTicks();
		int x = size / 10, y = size / 2, vA = 8;
		g.setFont(new Font("Sansserif", Font.PLAIN, size / 30));
		for (int i = 0; i < 9; i++) {
			g.drawLine(x, y + 5, x, y - 5);
			if (i != 4 && vA != 4) {
				if (i > 4)
					g.drawString(tick[i] + "", x - size / 40, y + size / 21);
				else
					g.drawString(tick[i] + "", x - size / 30, y + size / 21);
				if (vA > 4)
					g.drawString(tick[vA] + "", y - size / 13, x + size / 60);
				else
					g.drawString(tick[vA] + "", y - size / 12, x + size / 60);
			}
			g.drawLine(y + 5, x, y - 5, x);
			x += size / 10;
			vA--;
		}
		g.setColor(Color.RED);
		double sum = 0;
		for (int j = 0; j < poli.monom.size(); j++) {
			Monom temp = poli.monom.get(j);
			double rez = temp.dValoare(x);
			sum += rez;
		}

		double min = (-maxValue), max = maxValue, ratio = size / (max * 2), fx;
		for (; min <= max; min += 0.0025) {
			// O rotunjire bruta - interesant oricum
			min = Math.round(min * 1000.0) / 1000.0;
			fx = Math.round((this.f(min)) * 1000.0) / 1000.0;
			g.drawLine((int) (size / 2 + (ratio * min)), (int) (size / 2 - (ratio * fx)),
					(int) (size / 2 + (ratio * min)), (int) (size / 2 - (ratio * fx)));
		}
	}

	private double f(double min) {
		double sum = 0;
		for (int j = 0; j < poli.monom.size(); j++) {
			Monom temp = poli.monom.get(j);
			double rez = temp.dValoare(min);
			sum += rez;
		}
		return sum;
	}

	// Gaseste valorile punctelor din dreptul fiecarei liniute(segment) de la
	// axa
	// Multimiri
	private static double[] getTicks() {
		double increment = maxValue / 5, currentTick = -1 * (maxValue);
		double[] tick = new double[9];
		for (int i = 0; i < 9; i++) {
			currentTick += increment;
			tick[i] = Math.round(currentTick * 100.0) / 100.0;
		}
		return tick;
	}
}
