import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author 

 */
public class FramePregunta extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel lblPregunta; 
	
	
	int esteTema = 0;
	
	InterfazGrafica frameP;
	JLabel  laPregunta;
	JButton bcorrecta;
	JButton bincorrecta1;
	JButton bincorrecta2;
	JButton bincorrecta3;
	
public FramePregunta(String pregunta, int tema, String correcta, String incorrecta1, String incorrecta2, String incorrecta3, InterfazGrafica interfazGrafica){
	frameP = interfazGrafica;
	this.setAlwaysOnTop(true);
	this.setMinimumSize(new Dimension(300, 300));
	this.setLayout(new GridLayout(6, 1));
	this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	
	laPregunta = new JLabel(pregunta);
	this.add(laPregunta);
	this.add(new JLabel(""));
	this.esteTema = tema;
	switch (esteTema) {
	case (1):
		this.setTitle("TEMA 1");
	break;
	case (2):
		this.setTitle("TEMA 2");
	break;
	case (3):
		this.setTitle("TEMA 3");
	break;
	case (4):
		this.setTitle("TEMA 4");
	break;
	}

	Random random = new Random();
	int ran1 = random.nextInt(4);
	ran1 += 1;
	switch (ran1) {
	case (4):
		add(this.bincorrecta1 = new JButton("A. " + incorrecta1));
		add(this.bincorrecta2 = new JButton("B. " + incorrecta2));
		add(this.bincorrecta3 = new JButton("C. " + incorrecta3));
		add(this.bcorrecta = new JButton("D. " + correcta));

		break;
	case (1):

		add(this.bcorrecta = new JButton("A. " + correcta));
		add(this.bincorrecta3 = new JButton("B. " + incorrecta3));
		add(this.bincorrecta2 = new JButton("C. " + incorrecta2));
		add(this.bincorrecta1 = new JButton("D. " + incorrecta1));


		break;
	case (2):
		
		add(this.bincorrecta1 = new JButton("B. " + incorrecta1));
		add(this.bincorrecta2 = new JButton("C. " + incorrecta2));
		add(this.bcorrecta = new JButton("A. " + correcta));
		add(this.bincorrecta3 = new JButton("D. " + incorrecta3));


		break;
	case (3):
		add(this.bincorrecta1 = new JButton("B. " + incorrecta1));
		add(this.bcorrecta = new JButton("A. " + correcta));
		add(this.bincorrecta2 = new JButton("C. " + incorrecta2));
		add(this.bincorrecta3 = new JButton("D. " + incorrecta3));

		break;

	}
	this.bincorrecta1.setActionCommand("");
	this.bincorrecta2.setActionCommand("");
	this.bincorrecta3.setActionCommand("");
	this.bcorrecta.setActionCommand("correcta");
	this.bincorrecta1.addActionListener(this);
	this.bincorrecta2.addActionListener(this);
	this.bincorrecta3.addActionListener(this);
	this.bcorrecta.addActionListener(this);
	this.pack();
}
	

	public void actionPerformed(ActionEvent arg0) {
		String respuesta = arg0.getActionCommand();
		
		if(respuesta.equals("correcta")){
			this.frameP.darPunto(esteTema,"si");
			this.dispose();
						
		}else{
			this.frameP.darPunto(esteTema,"no");
			JOptionPane.showMessageDialog(null, "incorrecta","no",JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			
		}
		frameP.setEnabled(true);
	}

	
	
	

}
