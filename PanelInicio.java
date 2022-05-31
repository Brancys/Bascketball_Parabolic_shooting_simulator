package General;
import javax.swing.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kenkox
 */
public final class PanelInicio extends JPanel   {
    private Fondo fondoPrincipal; 
    private  RegistroAlumno panelAlumno;
    private static PanelInicio panelInicio = new PanelInicio();
    
    public RegistroAlumno getAlumno(){
        return panelAlumno;
    }
   
    private PanelInicio(){ 
	   setLayout(null);
	   panelAlumno = RegistroAlumno.getInstance();

	   fondoPrincipal = new Fondo( new ImageIcon(this.getClass().getResource("imagenes/fondob2.jpg")) );
	   inicializaComponentes();

    }
 
    public void inicializaComponentes(){
	   
	   fondoPrincipal.setBounds(0,0,1038,645);
	   panelAlumno.setBounds(80,320,330,210);
	   panelAlumno.setOpaque(false);
	   panelAlumno.setVisible(true);
	   
	   add(panelAlumno);
	   add(fondoPrincipal);

    }
    
    public static PanelInicio getInstance(){
	   return panelInicio;
    }


     
    

    
}
