package operatiimatematice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class Panel {

	public JFrame mainFrame;
	public JLabel controlLabel, statusLabel, controlLabel2, statusLabel2, controlLabel3, statusLabel3, controlLabel4,
			statusLabel4, controlLabel5, statusLabel5, controlLabel6, statusLabel6;
	public JPanel pol1, pol2, messages, secondColumn;
	public JTextField polinom, polinom2, valoare;
	public JButton plus, minus, times, divide;
	public int x; // valoarea lui x

	public Panel() {
		prepareGUI();
	}

	private void prepareGUI() {
		JLabel headerLabel;
		mainFrame = new JFrame("Calculator polinoame");
		mainFrame.setSize(900, 530);
		mainFrame.setLayout(new GridLayout(1, 2));
		JPanel firstColumn = new JPanel();
		// JPanel secondColumn = new JPanel();
		mainFrame.add(firstColumn);
		// mainFrame.getContentPane().setLayout(null);
		secondColumn = new JPanel();
		secondColumn.setLayout(null);
		secondColumn.setBorder(BorderFactory.createTitledBorder("Trasare polinom 1"));
		mainFrame.add(secondColumn);
		secondColumn.setSize(new Dimension(400, 400));

		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(new GridLayout(0, 1));
		headerLabel = new JLabel("", JLabel.CENTER);
		headerLabel.setText("Introdu polinomul in format latex: ");
		headerPanel.add(headerLabel);

		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});

		JPanel pol0 = new JPanel();
		pol0.setLayout(new GridLayout(1, 0));
		pol0.add(new JLabel("x= ", JLabel.LEFT));
		valoare = new JTextField(5);
		pol0.add(valoare);

		pol1 = new JPanel();
		pol1.setLayout(new FlowLayout());
		pol2 = new JPanel();
		pol2.setLayout(new FlowLayout());

		polinom = new JTextField(20);
		polinom2 = new JTextField(20);

		pol1.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.red));
		pol1.add(new JLabel("Polinom1: ", JLabel.LEFT));
		pol1.add(polinom);

		pol2.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.green));
		pol2.add(new JLabel("Polinom2: ", JLabel.LEFT));
		pol2.add(polinom2);

		/**
		 * Partea de mai jos se ocupa cu afisarea corespunzatoare a mesajelor
		 * Exista un panou messages - structurat in doua parti - Prima parte
		 * este pentru primul polinom - A doua parte pentru al doilea - Ultima
		 * parte Ofera rezultatele
		 */
		controlLabel = new JLabel("", JLabel.LEFT);
		controlLabel.setPreferredSize(new Dimension(350, 20));
		controlLabel.setText("Date despre polinomul 1");
		statusLabel = new JLabel("", JLabel.LEFT);
		statusLabel.setVerticalTextPosition(JLabel.TOP);
		statusLabel.setPreferredSize(new Dimension(350, 20));
		JPanel child_mess = new JPanel();
		child_mess.setLayout(new GridLayout(2, 1));
		child_mess.add(controlLabel);
		child_mess.add(statusLabel);
		child_mess.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.black));

		controlLabel2 = new JLabel("", JLabel.LEFT);
		controlLabel2.setPreferredSize(new Dimension(350, 20));
		controlLabel2.setText("Date despre polinomul 2");
		statusLabel2 = new JLabel("", JLabel.LEFT);
		statusLabel2.setVerticalTextPosition(JLabel.TOP);
		statusLabel2.setPreferredSize(new Dimension(350, 20));
		JPanel child_mess2 = new JPanel();
		child_mess2.setLayout(new GridLayout(2, 1));
		child_mess2.add(controlLabel2);
		child_mess2.add(statusLabel2);
		child_mess2.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.black));

		controlLabel3 = new JLabel("", JLabel.LEFT);
		controlLabel3.setPreferredSize(new Dimension(350, 20));
		controlLabel3.setText("Suma celor doua polinoame");
		statusLabel3 = new JLabel("", JLabel.LEFT);
		statusLabel3.setVerticalTextPosition(JLabel.TOP);
		statusLabel3.setPreferredSize(new Dimension(350, 20));
		JPanel child_mess3 = new JPanel();
		child_mess3.setLayout(new GridLayout(2, 1));
		child_mess3.add(controlLabel3);
		child_mess3.add(statusLabel3);
		child_mess3.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.black));

		controlLabel4 = new JLabel("", JLabel.LEFT);
		controlLabel4.setPreferredSize(new Dimension(350, 20));
		controlLabel4.setText("Diferenta celor doua polinoame");
		statusLabel4 = new JLabel("", JLabel.LEFT);
		statusLabel4.setVerticalTextPosition(JLabel.TOP);
		statusLabel4.setPreferredSize(new Dimension(350, 20));
		JPanel child_mess4 = new JPanel();
		child_mess4.setLayout(new GridLayout(2, 1));
		child_mess4.add(controlLabel4);
		child_mess4.add(statusLabel4);
		child_mess4.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.black));

		controlLabel5 = new JLabel("", JLabel.LEFT);
		controlLabel5.setPreferredSize(new Dimension(350, 20));
		controlLabel5.setText("Inmultirea celor doua polinoame");
		statusLabel5 = new JLabel("", JLabel.LEFT);
		statusLabel5.setVerticalTextPosition(JLabel.TOP);
		statusLabel5.setPreferredSize(new Dimension(350, 20));
		JPanel child_mess5 = new JPanel();
		child_mess5.setLayout(new GridLayout(2, 1));
		child_mess5.add(controlLabel5);
		child_mess5.add(statusLabel5);
		child_mess5.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.black));

		controlLabel6 = new JLabel("", JLabel.LEFT);
		controlLabel6.setPreferredSize(new Dimension(350, 20));
		controlLabel6.setText("Impartirea celor doua polinoame");
		statusLabel6 = new JLabel("", JLabel.LEFT);
		statusLabel6.setVerticalTextPosition(JLabel.TOP);
		statusLabel6.setPreferredSize(new Dimension(350, 20));
		JPanel child_mess6 = new JPanel();
		child_mess6.setLayout(new GridLayout(2, 1));
		child_mess6.add(controlLabel6);
		child_mess6.add(statusLabel6);
		child_mess6.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.black));

		// Adaugam acum butoanele cu operatiile elementare
		JPanel operatori = new JPanel();
		GridLayout op = new GridLayout(1, 4);
		op.setHgap(20);
		operatori.setLayout(op);
		plus = Panel.createSimpleButton("+");
		minus = Panel.createSimpleButton("-");
		times = Panel.createSimpleButton("x");
		divide = Panel.createSimpleButton("/");
		operatori.add(plus);
		operatori.add(minus);
		operatori.add(times);
		operatori.add(divide);

		firstColumn.add(headerPanel);
		firstColumn.add(pol0);
		firstColumn.add(pol1);
		firstColumn.add(pol2);
		firstColumn.add(operatori);
		firstColumn.add(child_mess);
		firstColumn.add(child_mess2);
		firstColumn.add(child_mess3);
		firstColumn.add(child_mess4);
		firstColumn.add(child_mess5);
		firstColumn.add(child_mess6);
		// firstColumn.add(messages);
		firstColumn.setVisible(true);

	}

	private static JButton createSimpleButton(String text) {
		JButton button = new JButton("<html><p style='font-size:16px;font-family:Arial;'>" + text + "</p></html>");
		button.setForeground(Color.BLACK);
		button.setBackground(Color.lightGray);
		Border line = BorderFactory.createLineBorder(Color.BLACK);
		Border margin = new EmptyBorder(5, 15, 5, 15);
		Border compound = new CompoundBorder(line, margin);
		button.setBorder(compound);
		return button;
	}

	public void showEventDemo() {
		JButton first_ok = new JButton("OK");
		JButton second_ok = new JButton("OK");
		first_ok.setActionCommand("ok1");
		second_ok.setActionCommand("ok2");
		plus.setActionCommand("plus");
		minus.setActionCommand("minus");
		times.setActionCommand("times");
		divide.setActionCommand("divide");
		// Idea rezidua in a trimite o instanta a acestui obiect cate
		// PolyInterpreter
		first_ok.addActionListener(new PolyInterpreter(this));
		second_ok.addActionListener(new PolyInterpreter(this));
		plus.addActionListener(new PolyInterpreter(this));
		minus.addActionListener(new PolyInterpreter(this));
		times.addActionListener(new PolyInterpreter(this));
		divide.addActionListener(new PolyInterpreter(this));
		// Folosim acum tokens pe care ii setam in acel action Controller

		pol1.add(first_ok);
		pol2.add(second_ok);

		mainFrame.setVisible(true);
	}

}
