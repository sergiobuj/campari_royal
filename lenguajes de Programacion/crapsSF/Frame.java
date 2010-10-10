import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;

public class Frame extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel panelIzq, panelDer, panel2, panel1, panel3;

	JButton dado;

	JLabel dado1, dado2, juego, money, money2, puntos, labBanner,avisos,juega;

	boolean player1 = true,player2 = false,primerTiro = true;

	Random random;

	JTextField commesa,commesa2;

	int punto, suma ,juegoNum = 0,dinero = 5000,dinero2 = 5000,laCommesa = 1000,laCommesa2 = 1000;


	private ImageIcon imadado1;

	private ImageIcon imadado2;

	private ImageIcon imadado3;

	private ImageIcon imadado4;

	private ImageIcon imadado5;

	private ImageIcon imadado6;

	private ImageIcon banner;

	static final String DICE = "dado";


	/**
	 * 
	 */

	/**
	 * @param args
	 */

	public Frame() throws IOException, ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		{
// hey felo .. si pone esa linea de arriba sin documentar aparece con el estilo de windows


//-------------------------------------------------------------------La Creación
			commesa = new JTextField("" + laCommesa);
			commesa2 = new JTextField("" + laCommesa2);
			imadado1 = new ImageIcon("number1.jpg");
			imadado2 = new ImageIcon("number2.jpg");
			imadado3 = new ImageIcon("number3.jpg");
			imadado4 = new ImageIcon("number4.jpg");
			imadado5 = new ImageIcon("number5.jpg");
			imadado6 = new ImageIcon("number6.jpg");
			banner = new ImageIcon("banner.png");
			random = new Random();
			panelIzq = new JPanel();
			panelDer = new JPanel();
			panel2 = new JPanel();
			panel1 = new JPanel();
			panel3 = new JPanel();
			dado = new JButton("Lanzar los dados!!");
			dado1 = new JLabel();
			dado2 = new JLabel();
			juega = new JLabel();
			labBanner = new JLabel();
			juego = new JLabel("" + juegoNum);
			money = new JLabel("" + dinero);
			puntos = new JLabel("" + punto);
			money2 = new JLabel("" + dinero2);
			avisos = new JLabel("¡¡¡JUEGO CRAPS!!!");
			avisos.setHorizontalAlignment((int) CENTER_ALIGNMENT);
//------------------------------------------------------------------------FramePpal		
			this.setSize(500, 550);
			this.setMinimumSize(new Dimension(500, 300));
			this.setResizable(false);
			this.setTitle("CRAPS");
			this.setLayout(new BorderLayout());
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setVisible(true);
//------------------------------------------------------------------paneles
			
			TitledBorder borderDer = BorderFactory.createTitledBorder("Juego");
			panelDer.setPreferredSize(new Dimension(100, 200));
			panelDer.setBorder(borderDer);
			panelDer.setLayout(new BorderLayout());
			
			panel1.setLayout(new BorderLayout());
			
			panel3.setLayout(new GridLayout(5, 2));
			
			TitledBorder borderIzq = BorderFactory
			.createTitledBorder("Jugadores y Apuestas");
			panelIzq.setPreferredSize(new Dimension(100, 150));
			panelIzq.setBorder(borderIzq);
			panelIzq.setLayout(new GridLayout(4, 2));
//------------------------------------------------------------------JTexts	
			commesa.setHorizontalAlignment((int) CENTER_ALIGNMENT);
			commesa.setPreferredSize(new Dimension(100, 50));
			commesa2.setHorizontalAlignment((int) CENTER_ALIGNMENT);
			commesa2.setPreferredSize(new Dimension(100, 50));

//------------------------------------------------------------------labels			
			money.setHorizontalAlignment((int) CENTER_ALIGNMENT);
			money2.setHorizontalAlignment((int) CENTER_ALIGNMENT);

//-------------------------------------------------------------------imágenes

			dado1.setIcon(new ImageIcon("number1.jpg"));
			dado2.setIcon(new ImageIcon("number3.jpg"));
			labBanner.setIcon(banner);

			
//------------------------------------------------------------ add de todos			
			this.add(labBanner, BorderLayout.NORTH);
			this.add(panelDer, BorderLayout.CENTER);
			this.add(panelIzq, BorderLayout.SOUTH);


			
			panelDer.add(dado,BorderLayout.NORTH);
			panelDer.add(avisos,BorderLayout.SOUTH);
			panelDer.add(panel1 , BorderLayout.CENTER);
			
			panel1.add(new JLabel("                 "),BorderLayout.NORTH);
			panel1.add(panel2,BorderLayout.CENTER);
			panel1.add(panel3,BorderLayout.SOUTH);
			
			panel2.add(dado1);
			panel2.add(new JLabel(""));
			panel2.add(dado2);
			JLabel aa,bb,cc;
					aa=new JLabel("Lanzamiento:");
					aa.setHorizontalAlignment((int) CENTER_ALIGNMENT);
					bb=new JLabel("Turno de");
					bb.setHorizontalAlignment((int) CENTER_ALIGNMENT);
					cc=new JLabel("Juego #:");
					cc.setHorizontalAlignment((int) CENTER_ALIGNMENT);
			panel3.add(aa);
			panel3.add(puntos);
			juega.setText(quienJuega());
			panel3.add(bb);
			panel3.add(juega);
			panel3.add(cc);
			panel3.add(juego);
			panel3.add(new JLabel(""));
			panel3.add(new JLabel(""));
			panel3.add(new JLabel(""));
			panel3.add(new JLabel(""));
			
			/*panelDer.add(dado);
			panel3.add(new JLabel(""));
			panel3.add(new JLabel(""));
			panelDer.add(panel2);
			panelDer.add(new JLabel(""));
			panelDer.add(new JLabel("Juego #:"));
			panelDer.add(juego);
			panelDer.add(new JLabel("Suma:"));
			panelDer.add(puntos);
*/
			panelIzq.add(new JLabel("Apuesta J. 1:"));
			panelIzq.add(new JLabel("Apuesta J. 2:"));
			panelIzq.add(commesa);
			panelIzq.add(commesa2);
			panelIzq.add(new JLabel("Dinero J. 1: "));
			panelIzq.add(new JLabel("Dinero J. 2: "));
			panelIzq.add(money2);
			panelIzq.add(money);

//--------------------------------------------------------------------actionListener
			dado.addActionListener(this);
			dado.setActionCommand(DICE);

		}
	}

	public int randomNum() {
		int rand = random.nextInt(6);
		rand += 1;
		return rand;

	}
	
	
	public String quienJuega(){
		String juega;
		if(player1){
			juega= "Jugador 1";
		return juega;	
			
		}else{
			juega= "Jugador 2";
		return juega;
		}
	}

	public void refrescaDatos() { //
		puntos.setText("" + suma);
		juego.setText("" + juegoNum);
		money.setText("" + dinero);
		money2.setText("" + dinero2);
		juega.setText(""+quienJuega());

	}

	public static void main(String[] args) throws IOException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {

		@SuppressWarnings({ "unused" })
		Frame frame = new Frame();
		frame.setVisible(true);

	}

	public int getCommesa() {
		try {
			laCommesa = Integer.parseInt(commesa.getText());
		} catch (NumberFormatException e) {

			JOptionPane.showMessageDialog(null, "La apuesta no es válida"
					+ '\n' + "solo números por favor.", "-ERROR-",
					JOptionPane.PLAIN_MESSAGE);
		}
		return laCommesa;

	}

	public int getCommesa2() {
		try {
			laCommesa2 = Integer.parseInt(commesa2.getText());
		} catch (NumberFormatException e) {

			JOptionPane.showMessageDialog(null, "La apuesta no es válida"
					+ '\n' + "solo números por favor.", "-ERROR-",
					JOptionPane.PLAIN_MESSAGE);
		}
		return laCommesa2;

	}

	public void actionPerformed(ActionEvent evento) {
		String evento1 = evento.getActionCommand();
		if (evento1.equals("dado")) {
			int uno = randomNum();
			int dos = randomNum();

			// imagenes de dado # 1

			switch (uno) {

			case (1):
				dado1.setIcon(imadado1);
				break;

			case (2):
				dado1.setIcon(imadado2);
				break;

			case (3):
				dado1.setIcon(imadado3);
				break;

			case (4):
				dado1.setIcon(imadado4);
				break;

			case (5):
				dado1.setIcon(imadado5);
				break;

			case (6):
				dado1.setIcon(imadado6);
				break;

			default:
				break;
			}
			// imagenes dado #2
			switch (dos) {

			case (1):
				dado2.setIcon(imadado1);
				break;

			case (2):
				dado2.setIcon(imadado2);
				break;

			case (3):
				dado2.setIcon(imadado3);
				break;

			case (4):
				dado2.setIcon(imadado4);
				break;

			case (5):
				dado2.setIcon(imadado5);
				break;

			case (6):
				dado2.setIcon(imadado6);
				break;
			default:
				break;
			}

			suma = uno + dos;

			String a = money.getText();
			int din = Integer.parseInt(a);
			String b = money2.getText();
			int din2 = Integer.parseInt(b);
			if (din <= 0) {
				JOptionPane.showMessageDialog(null, "Gana Jugador2",
						"-GANADOR-", JOptionPane.PLAIN_MESSAGE);
			}
			if (din2 <= 0) {

				JOptionPane.showMessageDialog(null, "Gana Jugador1.",
						"-GANADOR-", JOptionPane.PLAIN_MESSAGE);
			}

			if (player1) {
				if (primerTiro) {
					switch (suma) {
					case (7):
					case (11): {
						dinero += getCommesa();
						juegoNum++;
						refrescaDatos();
						player1 = false;
						player2 = true;
						dinero2 -= getCommesa();
						avisos.setText("Jugador 1... gana el lanzamiento!!!");
						avisos.setForeground(Color.GREEN);
						avisos.setBackground(Color.yellow);
						if (dinero2 <= 0) {

							JOptionPane.showMessageDialog(null,
									"Gana Jugador1.", "-GANADOR-",
									JOptionPane.PLAIN_MESSAGE);
						}
					}
						break;

					case (2):
					case (3):
					case (12): {
						dinero -= getCommesa();
						dinero2 += getCommesa();
						juegoNum++;
						refrescaDatos();
						player1 = false;
						player2 = true;
						avisos.setText("Jugador 1... mala suerte!!!");
						avisos.setForeground(Color.RED);
						if (dinero <= 0) {
							JOptionPane.showMessageDialog(null,
									"Gana Jugador2", "-GANADOR-",
									JOptionPane.PLAIN_MESSAGE);
						}
					}
						break;

					default: {
						primerTiro = false;
						punto = suma;
						refrescaDatos();
						player1 = true;
						player2 = false;
					}
						break;
					}
				} else if (!primerTiro) {
					if (suma == 7) {
						dinero -= getCommesa();
						dinero2 += getCommesa();
						juegoNum++;
						refrescaDatos();
						primerTiro = true;
						player1 = false;
						player2 = true;
						avisos.setText("Jugador 1... pierde...!!!");
						avisos.setForeground(Color.RED);
						if (dinero <= 0) {
							JOptionPane.showMessageDialog(null,
									"Gana Jugador2", "-GANADOR-",
									JOptionPane.PLAIN_MESSAGE);
						}
					}
					if (suma == punto) {
						dinero += getCommesa();
						dinero2 -= getCommesa();
						juegoNum++;
						refrescaDatos();
						primerTiro = true;
						player1 = false;
						player2 = true;
						avisos.setText("Jugador 1... muy bien!!!");
						avisos.setForeground(Color.GREEN);
						avisos.setBackground(Color.yellow);
						if (dinero2 <= 0) {
							JOptionPane.showMessageDialog(null,
									"Gana Jugador1", "-GANADOR-",
									JOptionPane.PLAIN_MESSAGE);
						}

					}

				}
				refrescaDatos();
			}

			else if (player2) {
				if (primerTiro) {
					switch (suma) {

					case (7):
					case (11): {
						dinero2 += getCommesa2();
						dinero -= getCommesa2();
						juegoNum++;
						refrescaDatos();
						player1 = true;
						player2 = false;
						avisos.setText("Jugador 2...qué buena suerte!!!");
						avisos.setForeground(Color.GREEN);
						avisos.setBackground(Color.yellow);
						if (dinero <= 0) {
							JOptionPane.showMessageDialog(null,
									"Gana Jugador2", "-GANADOR-",
									JOptionPane.PLAIN_MESSAGE);
						}

					}
						break;

					case (2):
					case (3):
					case (12): {
						dinero2 -= getCommesa2();
						dinero += getCommesa2();
						juegoNum++;
						refrescaDatos();
						player1 = true;
						player2 = false;
						avisos.setText("Jugador 2... será el próximo lanzamiento!!!");
						avisos.setForeground(Color.RED);
						if (dinero2 <= 0) {
							JOptionPane.showMessageDialog(null,
									"Gana Jugador1", "-GANADOR-",
									JOptionPane.PLAIN_MESSAGE);
						}
					}
						break;

					default: {
						primerTiro = false;
						punto = suma;
						refrescaDatos();
						player1 = false;
						player2 = true;
					}
						break;
					}
				} else if (!primerTiro) {
					if (suma == 7) {
						dinero2 -= getCommesa2();
						dinero += getCommesa2();
						juegoNum++;
						avisos.setText("Jugador 2... pierde!!!");
						avisos.setForeground(Color.RED);
						refrescaDatos();
						primerTiro = true;
						player1 = true;
						player2 = false;
						if (dinero2 <= 0) {
							JOptionPane.showMessageDialog(null,
									"Gana Jugador1", "-GANADOR-",
									JOptionPane.PLAIN_MESSAGE);
						}

					}
					if (suma == punto) {
						dinero2 += getCommesa2();
						dinero -= getCommesa2();
						juegoNum++;
						primerTiro = true;
						player1 = true;
						player2 = false;
						refrescaDatos();
						avisos.setText("Jugador ... ganó!!!");
						avisos.setForeground(Color.GREEN);
						avisos.setBackground(Color.yellow);
						if (dinero <= 0) {
							JOptionPane.showMessageDialog(null,
									"Gana Jugador2", "-GANADOR-",
									JOptionPane.PLAIN_MESSAGE);
						}
					}

				}

			}
			refrescaDatos();
		}

	}
}
