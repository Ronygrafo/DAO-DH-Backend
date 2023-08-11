package model;

/*Un  Odontologo tiene:
        ● ID Num
        ● apellido: String
        ● nombre: String
        ● matricula: String
*/

import org.apache.log4j.Logger;

public class Odontologo {

    private static final Logger logger= Logger.getLogger(Odontologo.class);

    private Integer id;
    private String nombre;
    private String apellido;
    private String matricula;

    public Odontologo(Integer id, String nombre, String apellido, String matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
