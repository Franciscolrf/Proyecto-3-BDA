package pojos;

import org.bson.types.ObjectId;

/**
 * Clase que representa una dirección.
 * 
 * @author Fran
 */
public class Direccion {

    // Atributos
    private ObjectId _id;
    private String ciudad;
    private String numeroEdificio;
    private String calle;
    private String colonia;
    private String codigoPostal;

    // Constructores

    /**
     * Constructor por defecto.
     */
    public Direccion() {
    }

    /**
     * Constructor con todos los atributos.
     * 
     * @param _id            Identificador de la dirección.
     * 
     * @param ciudad         Ciudad de la dirección.
     * 
     * @param numeroEdificio Número de edificio de la dirección.
     * 
     * @param calle          Calle de la dirección.
     * 
     * @param colonia        Colonia de la dirección.
     * 
     * @param codigoPostal   Código postal de la dirección.
     */
    public Direccion(ObjectId _id, String ciudad, String numeroEdificio, String calle, String colonia,
            String codigoPostal) {
        this._id = _id;
        this.ciudad = ciudad;
        this.numeroEdificio = numeroEdificio;
        this.calle = calle;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Constructor con todos los atributos.
     * 
     * @param ciudad         Ciudad de la dirección.
     * 
     * @param numeroEdificio Número de edificio de la dirección.
     * 
     * @param calle          Calle de la dirección.
     * 
     * @param colonia        Colonia de la dirección.
     * 
     * @param codigoPostal   Código postal de la dirección.
     */
    public Direccion(String ciudad, String numeroEdificio, String calle, String colonia, String codigoPostal) {
        this.ciudad = ciudad;
        this.numeroEdificio = numeroEdificio;
        this.calle = calle;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    // Getters y Setters

    /**
     * Obtiene el identificador único del objeto.
     *
     * @return El identificador único del objeto.
     */
    public ObjectId get_id() {
        return _id;
    }

    /**
     * Establece el identificador único del objeto.
     *
     * @param _id El identificador único del objeto.
     */
    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    /**
     * Obtiene la ciudad.
     *
     * @return La ciudad.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad.
     *
     * @param ciudad La ciudad.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene el número del edificio.
     *
     * @return El número del edificio.
     */
    public String getNumeroEdificio() {
        return numeroEdificio;
    }

    /**
     * Establece el número del edificio.
     *
     * @param numeroEdificio El número del edificio.
     */
    public void setNumeroEdificio(String numeroEdificio) {
        this.numeroEdificio = numeroEdificio;
    }

    /**
     * Obtiene la calle.
     *
     * @return La calle.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle.
     *
     * @param calle La calle.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene la colonia.
     *
     * @return La colonia.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece la colonia.
     *
     * @param colonia La colonia.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Obtiene el código postal.
     *
     * @return El código postal.
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Establece el código postal.
     *
     * @param codigoPostal El código postal.
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Método toString.
     * 
     * @return Una cadena que representa el objeto.
     */
    @Override
    public String toString() {
        return "Direccion{" +
                "ciudad='" + ciudad + '\'' +
                ", numeroEdificio='" + numeroEdificio + '\'' +
                ", calle='" + calle + '\'' +
                ", colonia='" + colonia + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                '}';
    }
}
