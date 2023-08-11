package dao;

public interface iDao<T> {
    //Todos los métodos que implementaran las clases de negocio

    T guardar(T t);
    T modMatricula(T t);
    T consultar(T t);

}