import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Write a description of class PanelDescuentos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PanelDescuentos extends JPanel
{
	// instance variables - replace the example below with your own
	private int x;
	private JCheckBox cbPPago;
	private JCheckBox cbSPublico;
	private JCheckBox cbTCuenta;

	/**
	 * Constructor for objects of class PanelDescuentos
	 */
	public PanelDescuentos()
	{
	    setLayout(new GridLayout(2, 2));

	    TitledBorder border = 
            BorderFactory.createTitledBorder("Descuentos");
        setBorder(border);
        
        cbPPago = new JCheckBox("Pronto pago");
        cbSPublico = new JCheckBox("Servicio Público");
        cbTCuenta = new JCheckBox("Traslado de cuenta");
        
        add(cbPPago);
        add(cbSPublico);
        add(cbTCuenta);
	}

	/**
	 * An example of a method - replace this comment with your own
	 * 
	 * @param  y   a sample parameter for a method
	 * @return     the sum of x and y 
	 */
	public int sampleMethod(int y)
	{
		// put your code here
		return x + y;
	}
}
