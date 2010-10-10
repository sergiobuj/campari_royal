import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class PanelDiccionario extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTextField JTFingles;
	private JTextField JTFfrances;
	public PanelDiccionario(){
		TitledBorder borde = BorderFactory.createTitledBorder("Diccionario.");
		setBorder(borde);
		setLayout (new GridLayout(1,5));
		JTFingles = new JTextField("0");
		JTFfrances= new JTextField("0");
		JLabel JLingles=new JLabel ("Ingles:");
		JLabel JLfrances= new JLabel ("Frances:");
		JLabel JLespacio = new JLabel ("");
		JTFingles.setEditable(false);
		JTFfrances.setEditable(false);
		add(JLingles);
		add(JTFingles);
		add(JLespacio);
		add(JLfrances);
		add(JTFfrances);
	}
	public void refrescarDiccioIngles(int tamanio){
		JTFingles.setText(""+tamanio);
	}
	public void refrescarDiccioFrances(int tamanio){
		JTFfrances.setText(""+tamanio);
	}
}