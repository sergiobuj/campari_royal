import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class PanelConsulta extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	public final static String BUTING="EnIngles";
	public final static String BUTFRA="EnFrances";
	private JTextField JTFlaTraduccion;
	private JTextField JTFlaConsulta; 
	private InterfazTraductor ventanaPrincipal;

	public PanelConsulta(InterfazTraductor ventana){
		ventanaPrincipal=ventana;
		TitledBorder borde = BorderFactory.createTitledBorder("Consulta.");
		setBorder(borde);
		JTFlaTraduccion =new JTextField();
		JTFlaConsulta=new JTextField();
		JLabel JLpalabra=new JLabel("Palabra:");
		JLabel JLtraduccion=new JLabel("Traducción:");
		JButton BUTingles= new JButton("En Ingles");
		JButton BUTfrances=new JButton("En Frances");
		setLayout(new GridLayout(2,3));
		JTFlaTraduccion.setEditable(false);
		add(JLpalabra);
		add(JTFlaConsulta);
		add(BUTingles);
		add(JLtraduccion);
		add(JTFlaTraduccion);
		add(BUTfrances); 
		BUTingles.setForeground(Color.BLACK);
		BUTingles.setActionCommand(BUTING);
		BUTfrances.setActionCommand(BUTFRA);
		BUTingles.addActionListener(this);
		BUTfrances.addActionListener(this);
	}
	public void actionPerformed(ActionEvent eventos){   
		String evento = eventos.getActionCommand();
		if (evento.equals(BUTING)){
			ventanaPrincipal.traducirIngles(JTFlaConsulta.getText());
		}else if(evento.equals(BUTFRA)){
			ventanaPrincipal.traducirFrances(JTFlaConsulta.getText());
		}

	}        
	public void refrescoTraduccion(String traduccion){
		JTFlaTraduccion.setText(traduccion);
	}  
}