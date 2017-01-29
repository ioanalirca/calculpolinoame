package operatiimatematice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;

public class PolyInterpreter implements ActionListener {
	Panel panel;
	String[] monoame1;
	String[] monoame2;

	// Suntem dependenti de valorile existente pe panou
	public PolyInterpreter(Panel panel) {
		this.panel = panel;
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		panel.x = (panel.valoare.getText().isEmpty()) ? 0 : Integer.parseInt(panel.valoare.getText());

		if (command.equals("ok1")) {
			String buffer = panel.polinom.getText();
			Polinom poli = this.createPoli(buffer);

			/* Urm. linii de cod deseneaza pe ecran polinomul */
			int newX = (panel.x == 0) ? 5 : (int) Math.sqrt(panel.x * poli.getGrad()) * 5;

			Cartezian grafic = new Cartezian(400, newX);
			grafic.setLayout(null);
			grafic.setPoli(poli);
			grafic.setVisible(true);
			panel.secondColumn.add(grafic);
			grafic.setBounds(21, 23, 400, 400);

			panel.controlLabel.setText(
					"<html><p style='font-family:Arial;font-weight:100;line-height:15px;'>Rezultat polinom 1: <b>"
							+ poli.valoare() + "</b></p></html>");
			panel.statusLabel
					.setText("<html><p style='font-family:Arial;font-weight:100;line-height:15px;'>Polinom 1: <b>"
							+ poli.afisare() + "</b></p></html>");
		} else if (command.equals("ok2")) {
			String buffer = panel.polinom2.getText();
			Polinom poli = this.createPoli(buffer);
			panel.controlLabel2.setText(
					"<html><p style='font-family:Arial;font-weight:100;line-height:15px;'>Rezultat polinom 2: <b>"
							+ poli.valoare() + "</b></p></html>");
			panel.statusLabel2
					.setText("<html><p style='font-family:Arial;font-weight:100;line-height:15px;'>Polinom 2: <b>"
							+ poli.afisare() + "</b></p></html>");
		} else if (command.equals("plus")) {
			String buffer1 = panel.polinom.getText();
			String buffer2 = panel.polinom2.getText();
			Polinom poli3 = this.add(buffer1, buffer2);
			panel.controlLabel3.setText(
					"<html><p style='font-family:Arial;font-weight:100;line-height:15px;'>Rezultat suma polinoame: <b>"
							+ poli3.valoare() + "</b></p></html>");
			panel.statusLabel3
					.setText("<html><p style='font-family:Arial;font-weight:100;line-height:15px;'>Polinom 3: <b>"
							+ poli3.afisare() + "</b></p></html>");
		} else if (command.equals("minus")) {
			String buffer1 = panel.polinom.getText();
			String buffer2 = panel.polinom2.getText();
			Polinom poli3 = this.sub(buffer1, buffer2);
			panel.controlLabel4.setText(
					"<html><p style='font-family:Arial;font-weight:100;line-height:15px;'>Rezultat scadere polinoame: <b>"
							+ poli3.valoare() + "</b></p></html>");
			panel.statusLabel4
					.setText("<html><p style='font-family:Arial;font-weight:100;line-height:15px;'>Polinom 4: <b>"
							+ poli3.afisare() + "</b></p></html>");
		} else if (command.equals("times")) {
			String buffer1 = panel.polinom.getText();
			String buffer2 = panel.polinom2.getText();
			Polinom poli3 = this.times(buffer1, buffer2);
			panel.controlLabel5.setText(
					"<html><p style='font-family:Arial;font-weight:100;line-height:15px;'>Rezultat inmultire polinoame: <b>"
							+ poli3.valoare() + "</b></p></html>");
			panel.statusLabel5
					.setText("<html><p style='font-family:Arial;font-weight:100;line-height:15px;'>Polinom 5: <b>"
							+ poli3.afisare() + "</b></p></html>");
		} else if (command.equals("divide")) {
			String buffer1 = panel.polinom.getText();
			String buffer2 = panel.polinom2.getText();
			ArrayList<Polinom> polis = new ArrayList<Polinom>();
			polis = this.divide(buffer1, buffer2);
			panel.controlLabel6.setText(
					"<html><p style='font-family:Arial;font-weight:100;line-height:15px;'>Rezultat impartire polinoame: <b>"
							+ polis.get(0).valoare() + "   |   " + polis.get(1).valoare() + "</b></p></html>");
			panel.statusLabel6
					.setText("<html><p style='font-family:Arial;font-weight:100;line-height:15px;'>Polinom 6: <b>"
							+ polis.get(0).afisare() + "  |   " + polis.get(1).afisare() + "</b></p></html>");
		}
	}

	private Polinom createPoli(String buffer) {
		String monoame[];
		String finalBuffer;
		// Verificam in prealabil daca e vorba de vreo derivata sau integrala
		if (buffer.toLowerCase().contains("deriv")) {
			// Se doreste derivarea
			buffer.trim().replace("deriv", "");
			String actualBuffer = (buffer.contains("-")) ? buffer.replace("-", "+-") : buffer;
			finalBuffer = (actualBuffer.charAt(0) == '+') ? actualBuffer.substring(1) : actualBuffer;
			monoame = finalBuffer.split("\\+"); // omg
			Polinom poli = new Polinom(monoame, panel.x);
			poli.deriv();
			return poli;
		} else if (buffer.toLowerCase().contains("int")) {
			// Se doreste integrarea
			buffer.replace("int", "").trim();
			String actualBuffer = (buffer.contains("-")) ? buffer.replace("-", "+-") : buffer;
			finalBuffer = (actualBuffer.charAt(0) == '+') ? actualBuffer.substring(1) : actualBuffer;
			monoame = finalBuffer.split("\\+"); // omg
			Polinom poli = new Polinom(monoame, panel.x);
			poli.integ();
			return poli;
		} else {
			String actualBuffer = (buffer.contains("-")) ? buffer.replace("-", "+-") : buffer;
			finalBuffer = (actualBuffer.charAt(0) == '+') ? actualBuffer.substring(1) : actualBuffer;
			monoame = finalBuffer.split("\\+"); // omg
			Polinom poli = new Polinom(monoame, panel.x);
			return poli;
		}
	}

	private Polinom add(String buffer1, String buffer2) {
		Polinom poli1, poli2, poli3;
		poli1 = createPoli(buffer1);
		poli2 = createPoli(buffer2);
		poli3 = poli1.add(poli2);
		return poli3;
	}

	private Polinom sub(String buffer1, String buffer2) {
		Polinom poli1, poli2, poli3;
		poli1 = createPoli(buffer1);
		poli2 = createPoli(buffer2);
		poli3 = poli1.sub(poli2);
		return poli3;
	}

	private Polinom times(String buffer1, String buffer2) {
		Polinom poli1, poli2, poli3;
		poli1 = createPoli(buffer1);
		poli2 = createPoli(buffer2);
		poli3 = poli1.times(poli2);
		return poli3;
	}

	private ArrayList<Polinom> divide(String buffer1, String buffer2) {
		Polinom poli1, poli2;
		ArrayList<Polinom> polis = new ArrayList<Polinom>();
		poli1 = createPoli(buffer1);
		poli2 = createPoli(buffer2);
		polis = poli1.divide(poli2);
		return polis;
	}

}
