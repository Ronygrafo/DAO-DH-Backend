package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;

public class OdontologoDAOH2 implements iDao<Odontologo> {


    private static Logger logger= Logger.getLogger(OdontologoDAOH2.class);

    //Script para Escribir 1 Odontologo en la DB
    private static final String SQL_INSERT="INSERT INTO ODONTOLOGOS VALUES(?,?,?,?)";
    private static final String SQL_UPDATE="UPDATE ODONTOLOGOS SET MATRICULA=? WHERE ID =?";
    private static final String SQL_SELECT="SELECT * FROM ODONTOLOGOS";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("3° Operacion de guardado de un odontólogo");
        Connection connection=null;

        try{
            connection= DB.getConnnection();
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT);
            /*
            1. ID INT PRIMARY KEY
            2. NOMBRE VARCHAR(50)
            3. APELLIDO VARCHAR(50)
            4. MATRICULA VARCHAR(50)
            */
            psInsert.setInt(1,odontologo.getId());
            psInsert.setString(2, odontologo.getNombre());
            psInsert.setString(3, odontologo.getApellido());
            psInsert.setString(4,odontologo.getMatricula());
            psInsert.execute();
            logger.info("4° Odontologo guardado en la DB con el id: "+odontologo.getId());

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            try{
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public Odontologo modMatricula(Odontologo odontologo) {
        logger.info("5° Operacion de actualización de MATRICULA");
        Connection connection=null;

        try{
            connection= DB.getConnnection();
            PreparedStatement psUpdate= connection.prepareStatement(SQL_UPDATE);
            psUpdate.setString(1,"0505");
            psUpdate.setInt(2,1);
            psUpdate.execute();//<-- Punto para Rollback
            logger.warn("5° Matricula de Odontologo ACTUALIZADA en la DB con el id: "+odontologo.getId());

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            try{
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public Odontologo consultar(Odontologo odontologo) {

        Connection connection=null;

        try{
            connection= DB.getConnnection();
            Statement statement= connection.createStatement();
            ResultSet rs= statement.executeQuery(SQL_SELECT);
            while (rs.next()){
                System.out.println("ID: "+rs.getInt(1)+" .-Nombre:"+rs.getString(2)+" .-Apellido: "+rs.getString(3)+" .-Matricula: "+rs.getString(4));
            }

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            try{
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return odontologo;
    }
}
