package Apoyo;

import java.util.Scanner;
import javax.swing.JOptionPane;

/* @author MeloDev */
public class Inputs {
    private Scanner in = new Scanner(System.in);
    private Mensajes msg = new Mensajes();
    
    public double inDouble(){
        double entrada = 0.0;
        boolean valido = false;
        do {
            in = new Scanner(System.in);
            try {
                entrada = in.nextDouble();
                valido = true;
            }catch (Exception e){
                msg.mostrarError("Double");
            }
        }while (!valido);
        return entrada;
    }
    
    public int inIntPositivo(){
        int entrada = 0;
        boolean valido = false;
        do {
            in = new Scanner(System.in);
            try {
                entrada = in.nextInt();
                if (entrada<=0){
                    msg.mostrarErrorOptionPane("Debe ingresar un valor numerico mayor a 0");
                }else{
                    valido = true;
                }
            }catch (Exception e){
                msg.mostrarError("Entero");
            }
            
        }while (!valido);
        return entrada;
    }
    
    public char inChar(){
        char entrada = ' ';
        boolean valido = false;
                
        do {
            in = new Scanner(System.in);//MODI
            String input = in.next();
            if (input.length() != 1) {
                msg.mostrarError("caracter");
            }else{
                entrada = input.charAt(0);
                valido = true;
            }
        }while (!valido);
        return entrada;
    }
    
    public String inString(){
        String entrada = "";
        boolean valido = false;
                
        do {
            in = new Scanner(System.in);//MODI
            String input = in.next();
            if ("".equals(input)) {
                msg.mostrarError("Debe ingresar un valor");
            }else{
                entrada = input;
                valido = true;
            }
        }while (!valido);
        
        return entrada;
    }
    
    public double inDoublePositivoOptionPane(String titulo){
        double entrada = -1;
        boolean valido = false;
        do {
            String input = JOptionPane.showInputDialog(titulo);
            
            try{
                entrada = Double.valueOf(input);
            }catch(Exception e){
                return -1;
            }
            if (entrada<=0){
                msg.mostrarErrorOptionPane("Debe ingresar un valor numerico mayor a 0");
            }else{
                valido = true;
            }
        }while (!valido);
        return entrada;
    }
}
