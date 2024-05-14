package pojos;

import org.bson.types.ObjectId;

/**
 * Clase que representa una dirección.
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

    /*
     * Constructor por defecto.
     */
    public Direccion() {
    }

    /*
     * Constructor con todos los atributos.
     * @param ciudad Ciudad de la dirección.
     * @param numeroEdificio Número de edificio de la dirección.
     * @param calle Calle de la dirección.
     * @param colonia Colonia de la dirección.
     * @param codigoPostal Código postal de la dirección.
     */
    public Direccion(ObjectId _id, String ciudad, String numeroEdificio, String calle, String colonia, String codigoPostal) {
        this._id = _id;
        this.ciudad = ciudad;
        this.numeroEdificio = numeroEdificio;
        this.calle = calle;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    /*
     * Constructor con todos los atributos.
     * @param ciudad Ciudad de la dirección.
     * @param numeroEdificio Número de edificio de la dirección.
     * @param calle Calle de la dirección.
     * @param colonia Colonia de la dirección.
     * @param codigoPostal Código postal de la dirección.
     */
    public Direccion(String ciudad, String numeroEdificio, String calle, String colonia, String codigoPostal) {
        this.ciudad = ciudad;
        this.numeroEdificio = numeroEdificio;
        this.calle = calle;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    // Getters y Setters

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
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

    /*
     * Método toString.
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
