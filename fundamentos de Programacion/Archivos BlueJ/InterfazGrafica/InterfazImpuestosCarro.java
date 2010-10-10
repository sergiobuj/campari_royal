import java.awt.*;
import javax.swing.*;

/**
 * Write a description of class InterfazImpuestosCarro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InterfazImpuestosCarro extends JFrame
{
    // instance variables - replace the example below with your own
    private int x;
    private PanelVehiculo panelVehiculo;
    private PanelDescuentos panelDescuentos;
    private PanelResultados panelResultados;

    /**
     * Constructor for objects of class InterfazImpuestosCarro
     */
    public InterfazImpuestosCarro()
    {
        this.setTitle("Cálculo de impuestos");
        setSize(290, 300);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        setLayout(new BorderLayout());
        
        panelVehiculo = new PanelVehiculo();
        add(panelVehiculo, BorderLayout.NORTH);
        
        panelDescuentos = new PanelDescuentos();
        add(panelDescuentos, BorderLayout.CENTER);
        
        panelResultados = new PanelResultados();
        add(panelResultados, BorderLayout.SOUTH);
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
    
    public static void main(String  [] misArgumentos) {
        InterfazImpuestosCarro interfazImpuestosCarro = 
            new InterfazImpuestosCarro();   
        //interfazImpuestosCarro.setVisible(true);
    }
}
