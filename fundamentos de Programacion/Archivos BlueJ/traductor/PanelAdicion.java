import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class PanelAdicion extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	public final static String ADICION1 = "Adicion en Ingles";
	public final static String ADICION2 = "Adicion en Frances";
	private JLabel JLespacio;
	private JLabel JLenIngles;
	private JLabel JLenEspaniol;
	private JLabel JLenFrances;
	private JTextField JTFenEspaniol;
	private JTextField JTFenIngles;
	private JTextField JTFenFrances;
	private JButton BUTadicion1;
	private JButton BUTadicion2;
	private InterfazTraductor ventanaPrincipal;

	public PanelAdicion(InterfazTraductor ventana){
		ventanaPrincipal=ventana;
		TitledBorder borde = BorderFactory.createTitledBorder("Adición.");
		setBorder(borde);  
		setLayout(new GridLayout(3,3));
		JLespacio = new JLabel("");
		JLenIngles= new JLabel("En Ingles:");
		JLenEspaniol= new JLabel ("En Español");
		JLenFrances= new JLabel ("En Frances");
		JTFenEspaniol = new JTextField(null);
		JTFenIngles=new JTextField();
		JTFenFrances=new JTextField();
		BUTadicion1 = new JButton ("Adicion en Ingles");
		BUTadicion2 = new JButton ("Adicion en Frances");

		add(JLenEspaniol);
		add(JTFenEspaniol);
		add(JLespacio);
		add(JLenIngles);
		add(JTFenIngles);
		add(BUTadicion1);
		add(JLenFrances);
		add(JTFenFrances);
		add(BUTadicion2);

		BUTadicion1.setActionCommand(ADICION1);
		BUTadicion2.setActionCommand(ADICION2);
		BUTadicion1.addActionListener(this);
		BUTadicion2.addActionListener(this);

		limpiarIngles();
		limpiarFrances();
	}
	public void actionPerformed(ActionEvent eventos){
		String evento = eventos.getActionCommand();
		if (evento.equals(ADICION1)){
			ventanaPrincipal.adicionIngles(JTFenEspaniol.getText(),JTFenIngles.getText());
		}else if(evento.equals(ADICION2)){
			ventanaPrincipal.adicionFrances(JTFenEspaniol.getText(),JTFenFrances.getText());
		}

	}
	public String darEspaniol(){
		return JTFenEspaniol.getText();
	}
	public String darIngles(){
		return JTFenIngles.getText(); 
	} 
	public String darFrances(){
		return JTFenFrances.getText();
	}   
	public void limpiarIngles(){
		JTFenIngles.setText("");
	}
	public void limpiarFrances(){
		JTFenFrances.setText("");   
	}
}
