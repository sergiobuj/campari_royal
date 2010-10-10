import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Write a description of class PanelVehiculo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PanelVehiculo extends JPanel
{
    // instance variables - replace the example below with your own
    private int x;
    private JTextField txtMarca;
    private JTextField txtLinea;
    private JTextField txtModelo;
    private JTextField txtValor;
    private JLabel lblMarca;
    private JLabel lblLinea;
    private JLabel lblModelo;
    private JLabel lblValor;
    
    /**
     * Constructor for objects of class PanelVehiculo
     */
    public PanelVehiculo()
    {
        setLayout(new GridLayout(5, 2));
        setPreferredSize(new Dimension(0, 130));
        
        TitledBorder border = 
            BorderFactory.createTitledBorder("Datos del Vehiculo");
        this.setBorder(border);
        
        lblMarca = new JLabel("Marca");
        lblLinea = new JLabel("Linea");
        lblModelo = new JLabel("Modelo");
        lblValor = new JLabel("Valor");
        
        txtMarca = new JTextField();
        txtLinea = new JTextField();
        txtModelo = new JTextField();
        txtValor = new JTextField("$ 0");
        txtValor.setEditable(false);
        txtValor.setForeground(Color.BLUE);
        txtValor.setBackground(Color.WHITE);
        
        add(lblMarca);
        add(txtMarca);
        add(lblLinea);
        add(txtLinea);
        add(lblModelo);
        add(txtModelo);
        add(lblValor);
        add(txtValor);
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
