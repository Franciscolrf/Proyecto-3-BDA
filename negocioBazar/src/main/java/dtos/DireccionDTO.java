package dtos;

public class DireccionDTO {
    private String ciudad;
    private String numeroEdificio;
    private String calle;
    private String colonia;
    private String codigoPostal;

    public DireccionDTO() {
    }

    /**
     * Crea una instancia con la informacion de una direccion.
     * @param ciudad
     * @param numeroEdificio
     * @param calle
     * @param colonia
     * @param codigoPostal
     */
    public DireccionDTO(String ciudad, String numeroEdificio, String calle, String colonia, String codigoPostal) {
        this.ciudad = ciudad;
        this.numeroEdificio = numeroEdificio;
        this.calle = calle;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNumeroEdificio() {
        return numeroEdificio;
    }

    public void setNumeroEdificio(String numeroEdificio) {
        this.numeroEdificio = numeroEdificio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        return "DireccionDTO{" + "ciudad=" + ciudad + ", numeroEdificio=" + numeroEdificio + ", calle=" + calle + ", colonia=" + colonia + ", codigoPostal=" + codigoPostal + '}';
    }
}