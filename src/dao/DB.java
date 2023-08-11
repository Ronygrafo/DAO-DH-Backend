package dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    /*apellido: String
    nombre: String
    matricula: String
    */

    private static final Logger logger = Logger.getLogger(DB.class);


    private static final String SQL_DROP_CREATE="DROP TABLE IF EXISTS ODONTOLOGOS; CREATE TABLE ODONTOLOGOS " +
            "(ID INT PRIMARY KEY, NOMBRE VARCHAR(50) NOT NULL, APELLIDO VARCHAR(50) NOT NULL, MATRICULA VARCHAR(50) NOT NULL)";

    public static void crearTablas(){
        Connection connection= null;
        try{

            connection= getConnnection();
            Statement statement= connection.createStatement();
            statement.execute(SQL_DROP_CREATE);
            logger.info("1° lo primero es crear las tablas");
            logger.warn("Creación de tablas exitoso ✅");

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            try{
                connection.close();
                logger.warn("Conexión cerrada 🔘");
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }

    }
    public static Connection getConnnection() throws Exception{
        Class.forName("org.h2.Driver");
        logger.info("Conexion de Driver exitosa");
        return DriverManager.getConnection("jdbc:h2:~/odontologia","rrd","rrd");
    }
}