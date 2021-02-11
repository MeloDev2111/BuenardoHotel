package Apoyo;

import javax.swing.JOptionPane;

/* @author MeloDev */
public class Mensajes {
    public void mostrarError(String formato){
        System.out.println("Error de Formato.. "+
                "Ingrese un valor con formato: " + formato + "\n" );
    }
    public void mostrarErrorOptionPane(String formato){
        JOptionPane.showMessageDialog(null,
        formato,
        "ERROR",JOptionPane.ERROR_MESSAGE);
    }
    
    
}
