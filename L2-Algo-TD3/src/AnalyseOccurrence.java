import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class AnalyseOccurrence {
    // Fenêtre principale
    protected JFrame frame;
    // Dictionnaire pour compter les occurrences
	private DictionnaireStringInt compteur = new DictionnaireStringInt();

    // Les labels et composants de l'interface
	private JLabel lblNbMots;
	private JLabel lblPlusFrequent;
	private JComboBox comboChoixMot;
	private JLabel lblFrequence;

	private boolean enabled=true;


	/**
	 * Lanceur d'application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnalyseOccurrence window = new AnalyseOccurrence();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Création de l'application.
	 */
	public AnalyseOccurrence() {
		initialize();
	}

	/**
	 * Initialisation des contenus de la fenêtre
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 1));
		
		JPanel panelTexte = new JPanel();
		panelTexte.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Texte \u00E0 analyser", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frame.getContentPane().add(panelTexte);
		panelTexte.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelTexte.add(scrollPane);
		
		final JTextArea texteAnalyse = new JTextArea();
		scrollPane.setViewportView(texteAnalyse);
		
		JButton btAnalyse = new JButton("Analyser");

		btAnalyse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				analyseTexte(texteAnalyse.getText());
				lblNbMots.setText(String.valueOf(compteur.donnerNbCles()));
				lblPlusFrequent.setText(compteur.rechercherCleAvecValeurMax());
				
				enabled=false;
				getComboChoixMot().removeAllItems();
				String[] mots = compteur.construireTableauDesCles();
				
				for (int i = 0 ; i<mots.length ; i++) {
					getComboChoixMot().addItem(mots[i]);
				}
				enabled=true;
            }
		});
		panelTexte.add(btAnalyse, BorderLayout.SOUTH);
		
		JPanel panelAnalyse = new JPanel();
		panelAnalyse.setBorder(new TitledBorder(null, "R\u00E9sultats de l'analyse", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(panelAnalyse);
		panelAnalyse.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panelAnalyse.add(panel);
		panel.setBorder(null);
		
		JLabel lbl2 = new JLabel("Nombre de mots :");
		lbl2.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lbl2);
		
		lblNbMots = new JLabel("xxx");
		panel.add(lblNbMots);
		
		JPanel panel_1 = new JPanel();
		panelAnalyse.add(panel_1);
		
		JLabel lbl1 = new JLabel("Mot le plus fréquent : ");
		panel_1.add(lbl1);
		
		lblPlusFrequent = new JLabel("xxx");
		panel_1.add(lblPlusFrequent);
		
		JPanel panel_2 = new JPanel();
		panelAnalyse.add(panel_2);
		
		JLabel lbl3 = new JLabel("Fréquence du mot ");
		panel_2.add(lbl3);
		
		comboChoixMot = new JComboBox();

		comboChoixMot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (enabled)
					getLblFrequence().setText(String.valueOf(compteur.rechercherValeur(getComboChoixMot().getSelectedItem().toString())));
			}
		});
		panel_2.add(comboChoixMot);
		
		lblFrequence = new JLabel("0");
		panel_2.add(lblFrequence);
	}

	public JLabel getLblNbMots() {
		return lblNbMots;
	}
	public JLabel getLblPlusFrequent() {
		return lblPlusFrequent;
	}
	public JComboBox getComboChoixMot() {
		return comboChoixMot;
	}
	public JLabel getLblFrequence() {
		return lblFrequence;
	}
	
	
	public void analyseTexte(String txt) {
		
		Scanner sc = new Scanner(txt);
		compteur = new DictionnaireStringInt();
		
		/*
		 * Expression régulière qui permet de définir
		 * les limites des mots lu via la méthode next() du scanner.
		 * (espaces, ponctuation, saut de ligne, etc.)
		 */
		sc.useDelimiter("([^\\p{L}\\p{Nd}]|\\s)+");
		
		while (sc.hasNext()) {
			String motLu = sc.next().toLowerCase();
			compteur.ajouterModifier(motLu,compteur.rechercherValeur(motLu)+1);
		}
		sc.close();
	}
}
