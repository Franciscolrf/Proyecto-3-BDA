/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import excepciones.PersistenciaException;

/**
 * Clase que se encarga de la conexión con la base de datos MongoDB
 * 
 * @author Fran
 */
public class ConexionBD {
    // Atributos
    private static final String DATABASE_NAME = "bazar";
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";

    private static MongoClient mongoClient;
    private static MongoDatabase database;


    /**
     * Constructor por defecto.
     */
    public ConexionBD() {
        
    }
    /**
     * Método para obtener el cliente de MongoDB
     * 
     * @return el cliente de MongoDB
     */
    public static MongoClient getMongoClient() {
        if (mongoClient == null) {
            // Configuración del cliente de MongoDB
            ConnectionString connectionString = new ConnectionString(CONNECTION_STRING);
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connectionString)
                    .build();

            // Creación del cliente de MongoDB
            mongoClient = MongoClients.create(settings);
        }
        return mongoClient;
    }

    /**
     * Método para obtener la base de datos
     * 
     * @return la base de datos
     */
    public static MongoDatabase getDatabase() {

        // Obtener el cliente de MongoDB
        MongoClient client = getMongoClient();

        // Obtener la base de datos
        return client.getDatabase(DATABASE_NAME);

    }

    /**
     * Método para cerrar la conexión con la base de datos
     */
    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
