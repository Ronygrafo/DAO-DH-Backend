import dao.DB;
import model.Odontologo;
import service.OdontologoService;

public class Admin {


    public static void main(String[] args) {

        //Primero, la Clase DB, crea las Tablas
        DB.crearTablas();

        //Instanciamos un Nuevo Odontologo, y lo llevamos al Dao
        Odontologo odontologo= new Odontologo(1,"Glenda","Dune","1234");

        //Instaciamos el Service
        OdontologoService service = new OdontologoService();

        //Guadarmos el Odontologo creado en la DB
        service.guardarOdontologo(odontologo);

        //Actualizar Matricula
        service.modMatricula(odontologo);

        //Contal por Consola
        service.consultar(odontologo);


        //el orden el siguiente:
        //1 cliente--> se comunica con el service
        //2 el service---> se comunica con el daoh2 correspondiente
        //3 el daoh2--> se comunica siempre con la clase de negocio.

    }


}