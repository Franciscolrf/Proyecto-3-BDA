package dtos;

/**
 * Clase que representa la informacion de una dirección en el sistema.
 * 
 * @author Fran
 */
public class DireccionDTO {

    // Atributos
    private String ciudad;
    private String numeroEdificio;
    private String calle;
    private String colonia;
    private String codigoPostal;

    // Constructores
    /*
     * Constructor vacío
     */
    public DireccionDTO() {
    }

    /**
     * Crea una instancia con la informacion de una direccion.
     * 
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

    // Getters y Setters

    /**
     * Obtiene la ciudad de la dirección del usuario.
     *
     * @return La ciudad de la dirección del usuario.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad de la dirección del usuario.
     *
     * @param ciudad La ciudad de la dirección del usuario.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene el número del edificio de la dirección del usuario.
     *
     * @return El número del edificio de la dirección del usuario.
     */
    public String getNumeroEdificio() {
        return numeroEdificio;
    }

    /**
     * Establece el número del edificio de la dirección del usuario.
     *
     * @param numeroEdificio El número del edificio de la dirección del usuario.
     */
    public void setNumeroEdificio(String numeroEdificio) {
        this.numeroEdificio = numeroEdificio;
    }

    /**
     * Obtiene la calle de la dirección del usuario.
     *
     * @return La calle de la dirección del usuario.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle de la dirección del usuario.
     *
     * @param calle La calle de la dirección del usuario.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene la colonia de la dirección del usuario.
     *
     * @return La colonia de la dirección del usuario.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece la colonia de la dirección del usuario.
     *
     * @param colonia La colonia de la dirección del usuario.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Obtiene el código postal de la dirección del usuario.
     *
     * @return El código postal de la dirección del usuario.
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Establece el código postal de la dirección del usuario.
     *
     * @param codigoPostal El código postal de la dirección del usuario.
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Representación de la dirección en forma de cadena.
     */
    @Override
    public String toString() {
        return "DireccionDTO{" + "ciudad=" + ciudad + ", numeroEdificio=" + numeroEdificio + ", calle=" + calle
                + ", colonia=" + colonia + ", codigoPostal=" + codigoPostal + '}';
    }
}
