package Negocio;

/* @author MeloDev */
public class Cliente {
    private String idCliente;
    private TiposCliente tipo;
    private String tipoDocumento;
    private String numDocumento;
    private String nombres;
    private String apellidos;
    
    
    public void setTipo(String tipo){
        switch (tipo) {
            case "NATURAL":
                setTipo(TiposCliente.NATURAL);
                break;
            case "JURIDICO":
                setTipo(TiposCliente.JURIDICO);
                break;
            default:
                break;
        }
    }
    
    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public TiposCliente getTipo() {
        return tipo;
    }

    public void setTipo(TiposCliente tipo) {
        this.tipo = tipo;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", tipo=" + tipo + ", tipoDocumento=" + tipoDocumento + ", numDocumento=" + numDocumento + ", nombres=" + nombres + ", apellidos=" + apellidos + '}';
    }
    
    
}
