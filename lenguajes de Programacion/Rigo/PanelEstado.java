
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class PanelEstado extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel labMensaje;

	private JLabel dos;

	private JLabel tres;

	public PanelEstado() {
		// Inicializar los elementos de la barra
		labMensaje = new JLabel("++++PRÁCTICA RIGO++++");
		labMensaje.setBorder(new LineBorder(Color.DARK_GRAY));

		dos = new JLabel("   Número de Rigo:  0");
		dos.setHorizontalTextPosition(JLabel.CENTER);
		dos.setBorder(new LineBorder(Color.DARK_GRAY));

		tres = new JLabel("   Tesoros debajo:  0");
		tres.setHorizontalTextPosition(JLabel.CENTER);
		tres.setBorder(new LineBorder(Color.DARK_GRAY));

		// Armar la barra
		setLayout(new GridBagLayout());

		GridBagConstraints gridBagConstraints1 = new GridBagConstraints(0, 0,
				1, 1, 1.0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 5, 0);
		add(labMensaje, gridBagConstraints1);

		GridBagConstraints gridBagConstraints2 = new GridBagConstraints(1, 0,
				1, 1, 0.2, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 5, 0);
		add(dos, gridBagConstraints2);

		GridBagConstraints gridBagConstraints3 = new GridBagConstraints(2, 0,
				1, 1, 0.1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 5, 0);
		add(tres, gridBagConstraints3);
	}

	public void actualizarBarraDeEstado(String mensaje) {
		labMensaje.setText(mensaje);
	}

	public void actualizaTesoros(int tesoros) {
		dos.setText("   Número de Rigo:  " + tesoros);
	}

	public void actualizaTesorosActuales(int tesorosDebajo) {
		tres.setText("   Tesoros debajo:  " + tesorosDebajo);
	}

}
