import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Write a description of class PanelResultados here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PanelResultados extends JPanel
    implements ActionListener
{
    // instance variables - replace the example below with your own
    private int x;
    
    public final static String LIMPIAR = "limpiar";
    public final static String CALCULAR = "calcular";
    
    private JLabel labTotal;
    private JTextField txtTotal;
    private JButton butLimpiar;
    private JButton butCalcular;

    /**
     * Constructor for objects of class PanelResultados
     */
    public PanelResultados()
    {
        setLayout(new GridLayout(2, 3));
        setPreferredSize(new Dimension(0, 65));

        TitledBorder border = 
            BorderFactory.createTitledBorder("Resultados");
        setBorder(border);
        
        labTotal = new JLabel("Total a pagar");
        txtTotal = new JTextField("$ 0");
        butLimpiar = new JButton("Limpiar");
        butCalcular = new JButton("Calcular");
        
        txtTotal.setEditable(false);
        txtTotal.setForeground(Color.BLUE);
        txtTotal.setBackground(Color.WHITE);
        
        add(new JLabel(" "));
        add(new JLabel(" "));
        add(butLimpiar);
        add(labTotal);
        add(txtTotal);
        add(butCalcular);
        
        butLimpiar.setActionCommand(LIMPIAR);
        butCalcular.setActionCommand(CALCULAR);
        
        butLimpiar.addActionListener(this);
        butCalcular.addActionListener(this);
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
    
    public void actionPerformed(ActionEvent evento){
        String comando = evento.getActionCommand();
        
        if(comando.equals(LIMPIAR)) {
            System.out.println("El usuario presiona Limpiar");
        } else if (comando.equals(CALCULAR)) {
            System.out.println("El usuario presiona Calcular");            
        }
    }
}
