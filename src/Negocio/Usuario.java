package Negocio;

public class Usuario {
    protected String idUsuario;
    protected String nombreCuenta;
    protected String contraseña;
    protected String tipoCuenta;

    public Usuario() {
    }
    
    public Usuario(String idUsuario, String nombreCuenta, String contraseña, String tipoCuenta) {
        this.idUsuario = idUsuario;
        this.nombreCuenta = nombreCuenta;
        this.contraseña = contraseña;
        this.tipoCuenta = tipoCuenta;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipodeCuenta) {
        this.tipoCuenta = tipodeCuenta;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombreCuenta=" + nombreCuenta + ", contrase\u00f1a=" + contraseña + ", tipoCuenta=" + tipoCuenta + '}';
    }
    
}
