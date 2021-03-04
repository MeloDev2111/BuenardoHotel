package Modelo;

public enum TiposCliente {
    NATURAL("DNI"), JURIDICO("RUC");
    private String tipoDoc;

    private TiposCliente(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }
    
}
