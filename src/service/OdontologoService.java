package service;

import dao.OdontologoDAOH2;
import dao.iDao;
import model.Odontologo;
import org.apache.log4j.Logger;

public class OdontologoService {

    private static final Logger logger= Logger.getLogger(OdontologoService.class);

    //necesitamos conectarnos al DAO-H2 correspondiente
    //necesitamos una relación de asociación

    private iDao<Odontologo> medicamentoiDao= new OdontologoDAOH2();

    /* OTRA FORMA DE HACERLO:

    public OdontologoService(iDao<Odontologo> odontologoiDao) {
        this.odontologoiDao = odontologoiDao;
        logger.info("Estoy llamando al iDao correspondiente para el guardado");
    }*/

    //Generar los métodos para interactuar con los iDao

    public Odontologo guardarOdontologo(Odontologo odontologo){

        logger.info("2° invoco al SERVICE para que inicie las operaciones de Guardado");

        return medicamentoiDao.guardar(odontologo);
    }

    public Odontologo modMatricula(Odontologo odontologo){

        logger.info(" SERVICE para que inicie ACTUALIZAR");

        return medicamentoiDao.modMatricula(odontologo);
    }

    public Odontologo consultar(Odontologo odontologo){

        logger.info("SERVICE para que inicie CONSULTAR");

        return medicamentoiDao.consultar(odontologo);
    }

}
