package Apoyo;


public class Validacion {
    
    private Mensajes msg = new Mensajes();
    
    public boolean isDNI(String a){
        if (a == null || "".equals(a)) {
            msg.mostrarErrorOptionPane("diferente de null");
            return false;
        }
        
        if (a.length()!=8) {
            msg.mostrarErrorOptionPane("8 digitos");
            return false;
        }
        
        for (char c : a.toCharArray()) {
            if (c<48 || c>57) {
                msg.mostrarErrorOptionPane("Digitos numericos");
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isNombre(String a){
        if (a == null || "".equals(a)) {
            msg.mostrarErrorOptionPane("diferente de null");
            return false;
        }
        
        for (char c : a.toCharArray()) {
            if ( (c<'A' || c>'Z' ) && (c<'a' || c>'z') && c!=' ' ) {
                msg.mostrarErrorOptionPane("Solo Letras");
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isAño(String a){
        if (a == null || "".equals(a)) {
            msg.mostrarErrorOptionPane("diferente de null");
            return false;
        }
        
        if (a.length()!=4) {
            msg.mostrarErrorOptionPane("4 digitos");
            return false;
        }
        
        for (char c : a.toCharArray()) {
            if (c<48 || c>57) {
                msg.mostrarErrorOptionPane("Digito numerico");
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isMes(String m){
        if (m == null || "".equals(m)) {
            msg.mostrarErrorOptionPane("diferente de null");
            return false;
        }
        
        if (m.length()!=2) {
            msg.mostrarErrorOptionPane("2 digitos");
            return false;
        }
        
        for (char c : m.toCharArray()) {
            if (c<48 || c>57) {
                msg.mostrarErrorOptionPane("Digito numerico");
                return false;
            }
        }
        int mes = Integer.valueOf(m);
        if (mes <1 || mes >12) {
            msg.mostrarErrorOptionPane("Entre 1 y 12");
            return false;
        }
        
        return true;
    }
    
    public boolean isDia(String d,String m, String a){
        if (d == null || "".equals(d)) {
            msg.mostrarErrorOptionPane("diferente de null");
            return false;
        }
        
        if (d.length()!=2) {
            msg.mostrarErrorOptionPane("2 digitos");
            return false;
        }
        
        for (char c : d.toCharArray()) {
            if (c<48 || c>57) {
                msg.mostrarErrorOptionPane("Digito numerico");
                return false;
            }
        }
        int dia = Integer.valueOf(d);
        int mes = Integer.valueOf(m);
        
        
        if (mes==1||mes==3||mes==5||mes==7||mes==8||mes==10||mes==12) {
            return isInRange(d, 1, 31);
        }
        
        if (mes==4||mes==6||mes==9||mes==11) {
            return isInRange(d, 1, 30);
        }
        
        if (mes==2) {
            if (isBisiesto(a)) {
                return isInRange(d, 1, 29);
            }else{
                return isInRange(d, 1, 28);
            }
        }
        
        return true;
    }
    
    public boolean isBisiesto(String a){
        int year = Integer.valueOf(a);
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
    
    public boolean isInRange(String d,int li,int ls){
        int num = Integer.valueOf(d);
        if (num <li || num >ls) {
            msg.mostrarErrorOptionPane("Entre "+li+" - "+ls);
            return false;
        }
        
        return true;
    }
    
    
    //VEMOS SI SE QUEDA
    public boolean isDouble(String cadena){
        double d;
        
        if (cadena==null || "".equals(cadena)) {
            msg.mostrarErrorOptionPane("input null");
            return false;
        }
        
        for (char c : cadena.toCharArray()) {
            //si no es un numero y no es . ->false
            //si es un numero o es . -> true
            if ( !(c>=48 && c<=57) && c!=46 ) {
               msg.mostrarErrorOptionPane("input contiene caracter"
                       + " diferente de punto o numero: "+c);
               return false;
            }
        }
        
        
        try {
            d = Double.valueOf(cadena);
        } catch (NumberFormatException e) {
            d=0;
        }
           
           
        if (d==0) {
            if (!"0".equals(cadena)) {
                msg.mostrarErrorOptionPane("input contiene doble .");
                return false;
            }
        }
        
        return true;
    }
        
    public boolean isZero(double d){
        
        if(d==0){
            msg.mostrarErrorOptionPane("El divisor no puede ser 0");
            return true;
        }
        return false;
    }
}
