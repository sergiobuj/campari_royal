import javax.swing.*;
import java.awt.*;

public class InterfazTraductor extends JFrame
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static int INGLES = 1;
    public final static int FRANCES = 2;

    private PanelDiccionario panelDiccionario;
    private PanelConsulta panelConsulta;
    private PanelAdicion panelAdicion;
    
    private Traductor elTraductor;
    
    public InterfazTraductor()
    {

        elTraductor = new Traductor();
        
        setLayout(new BorderLayout());
        setSize(450,270);
        setResizable(false);
        setTitle("Traductor                              Taller 7          ");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panelConsulta = new PanelConsulta(this);
        panelDiccionario = new PanelDiccionario();
        panelAdicion = new PanelAdicion(this);
        add(panelConsulta, BorderLayout.NORTH);
        add(panelDiccionario, BorderLayout.CENTER);
        add(panelAdicion, BorderLayout.SOUTH);

    }

    public static void main (String[] elMain){
        InterfazTraductor interfazTraductor = new InterfazTraductor();   
        interfazTraductor.setVisible(true);
    }

    public void traducirFrances(String enEsp){
        panelConsulta.refrescoTraduccion("");
        if(!(enEsp.equals(""))){
            Traduccion traducido=elTraductor.buscarTraduccionDe(enEsp, FRANCES);
            if(traducido!=null){
                panelConsulta.refrescoTraduccion(traducido.darTraduccion());
            }else{
                JOptionPane.showMessageDialog(this,
                "No hay traduccion a esa palabra",
                "Error",
                JOptionPane.ERROR_MESSAGE);            
            }
        }else{
        JOptionPane.showMessageDialog(this,
        "Escriba una palabra para traducirla",
        "Error",
        JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    public void traducirIngles(String enEsp){
        panelConsulta.refrescoTraduccion("");
        if(!(enEsp.equals(""))){
            Traduccion traducido=elTraductor.buscarTraduccionDe(enEsp, INGLES);
            if(traducido!=null){
                panelConsulta.refrescoTraduccion(traducido.darTraduccion());
            }else{
                JOptionPane.showMessageDialog(this,
                "No hay traduccion a esa palabra",
                "Error",
                JOptionPane.ERROR_MESSAGE);            
            }
        }else{
        JOptionPane.showMessageDialog(this,
        "Escriba una palabra para traducirla",
        "Error",
        JOptionPane.ERROR_MESSAGE);
        }    
    }

    public void refrescarDiccionarios(){
        panelDiccionario.refrescarDiccioIngles(elTraductor.darTamanioDiccionario(INGLES));
        panelDiccionario.refrescarDiccioFrances(elTraductor.darTamanioDiccionario(FRANCES));
    }
    
    public void adicionIngles(String enEsp,String enIng){
        if(panelAdicion.darEspaniol().equals("")){
            JOptionPane.showMessageDialog(this,
            "Escriba una palabra en Español",
            "Error",
            JOptionPane.ERROR_MESSAGE);        
        }else{
            if(panelAdicion.darIngles().equals("")){
                JOptionPane.showMessageDialog(this,
                "Escriba una palabra en Inglés",
                "Error",
                JOptionPane.ERROR_MESSAGE);            
            }else{
                elTraductor.agregarTraduccion(enEsp,enIng,INGLES);
                refrescarDiccionarios();
                panelAdicion.limpiarIngles();
            }
        }
        
    }
    
    public void adicionFrances(String enEsp, String enFra){
        if(panelAdicion.darEspaniol().equals("")){
            JOptionPane.showMessageDialog(this,
            "Escriba una palabra en Español",
            "Error",
            JOptionPane.ERROR_MESSAGE);        
        }else{
            if(panelAdicion.darFrances().equals("")){
                JOptionPane.showMessageDialog(this,
                "Escriba una palabra en Francés",
                "Error",
                JOptionPane.ERROR_MESSAGE);            
            }else{
                elTraductor.agregarTraduccion(enEsp,enFra,FRANCES);
                refrescarDiccionarios();
                panelAdicion.limpiarFrances();
            }
        }

    }
}
