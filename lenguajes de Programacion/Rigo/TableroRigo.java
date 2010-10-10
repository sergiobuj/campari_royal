import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;

public class TableroRigo extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Buttons matrix[][];

	JButton crear;

	int fil, col;

	JPanel centro, relleno;
	
	JLabel titulo;

	JTextField filas = new JTextField();

	JTextField columnas = new JTextField();

	TableroRigo() {
		centro = new JPanel();
		titulo = new JLabel();

		titulo.setIcon(new ImageIcon("bannerinicio.jpg"));

		this.setLayout(new BorderLayout());
		this.add(centro, BorderLayout.CENTER);
		this.add(titulo, BorderLayout.NORTH);
		
	
		
		centro.setLayout(new GridLayout(4, 4));
		centro.setSize(300,200);
		this.setMinimumSize(new Dimension(500, 200));
		centro.add(new JLabel(""));
		centro.add(new JLabel(""));
		centro.add(new JLabel(""));
		centro.add(new JLabel(""));
		centro.add(new JLabel(""));
		centro.add(new JLabel("NUMERO FILAS"));
		
		centro.add(filas);
		centro.add(new JLabel(""));
		centro.add(new JLabel(""));
		centro.add(new JLabel("NUMERO COLUMNAS"));
		
		centro.add(columnas);
		centro.add(new JLabel(""));
		centro.add(new JLabel(""));
		crear = new JButton("crear tablero");
		this.add(crear, BorderLayout.SOUTH);
		crear.addActionListener(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		TableroRigo rigoGame;
		rigoGame = new TableroRigo();
		rigoGame.setVisible(true);

	}

	public void actionPerformed(ActionEvent arg0) {

		try {
			
			fil = Integer.parseInt(filas.getText());
			col = Integer.parseInt(columnas.getText());
			
			if(fil > 10 || col > 10 || fil <= 0 || col <= 0){

				JOptionPane.showMessageDialog(null, "El número de filas o columnas debe estar en el rango de 1 a 10",
									"RIGO", JOptionPane.PLAIN_MESSAGE);
				
			}else{
				Interfaz interfaz;
				try {
					interfaz = new Interfaz(fil, col);
					interfaz.setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				
				this.dispose();
			}

			
			

			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "no sirven los numeros",
					"RIGO", JOptionPane.PLAIN_MESSAGE);

		}

	}
	

}
