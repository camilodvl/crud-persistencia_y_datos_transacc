package edu.com.iudigital.models;

import edu.com.iudigital.db.DbConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Almacen {



    private int id;
    private String nombreAlmacen;
    private String nombreGerente;
    private String apellidoGerente;
    private String Direccion;

    public void printAlmacen() {
        DbConfig dbConnection = new DbConfig("localhost","3306","mercafacil");

        Connection connection = dbConnection.connect();
        String query = "SELECT * FROM almacenes";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                System.out.print(resultSet.getString(1)+ " ");
                System.out.print(resultSet.getString(2)+ " ");
                System.out.print(resultSet.getString(3)+ " ");
                System.out.print(resultSet.getString(4)+ " ");
                System.out.print(resultSet.getString(5)+ " ");
                System.out.println("");
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.print(e);
        }

    }

    public Almacen getAlmacen(int idAlmacen){
        Almacen almacen = new Almacen();
        DbConfig dbConnection = new DbConfig("localhost","3306","mercafacil");

        Connection connection = dbConnection.connect();
        String query = String.format("SELECT * FROM almacenes WHERE idalmacenes=%d", idAlmacen);
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()){
                almacen.setId(Integer.parseInt(resultSet.getString(1)));
                almacen.setNombreGerente(resultSet.getString(2));
                almacen.setApellidoGerente(resultSet.getString(3));
                almacen.setNombreAlmacen(resultSet.getString(4));
                almacen.setDireccion(resultSet.getString(5));
            }else{
                System.out.println("No se ha encontrado registros");
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.print(e);
        }

        return almacen;
    };

    public void updateAlmacen(Almacen almacen){
        DbConfig dbConnection = new DbConfig("localhost","3306","mercafacil");

        Connection connection = dbConnection.connect();
        String query = String.format("UPDATE almacenes set " +
                "nombre_gerente='%s', " +
                "apellido_gerente='%s', " +
                "nombre_almacen='%s', " +
                "direccion='%s' where  idalmacenes=%d ", almacen.getNombreGerente(), almacen.getApellidoGerente(), almacen.getNombreAlmacen(),
                almacen.getDireccion(), almacen.getId());
        try {
            Statement statement = connection.createStatement();
            System.out.println("Actualizando");
            statement.executeUpdate(query);
            statement.close();
            connection.close();
            System.out.println("Almacen Actualizado");
        }catch (Exception e){
            System.out.print(e);
        }
    }

    public void deleteAlmacen(int idAlmacen){
        DbConfig dbConnection = new DbConfig("localhost","3306","mercafacil");

        Connection connection = dbConnection.connect();
        String query = String.format("DELETE FROM almacenes WHERE idalmacenes=%d",idAlmacen);
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
            statement.close();
            connection.close();
            System.out.println("Almacen Eliminado");
        }catch (Exception e){
            System.out.print(e);
        }
    }

    public void createAlmacen(Almacen almacen){
        DbConfig dbConnection = new DbConfig("localhost","3306","mercafacil");

        Connection connection = dbConnection.connect();
        String query = String.format("INSERT INTO almacenes (nombre_gerente, apellido_gerente, nombre_almacen, direccion) " +
                "VALUES ('%s', '%s', '%s', '%s') ",almacen.getNombreGerente(), almacen.getApellidoGerente(), almacen.getNombreAlmacen(), almacen.getDireccion());
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
            statement.close();
            connection.close();
            System.out.println("Almacen Creado");
        }catch (Exception e){
            System.out.print(e);
        }
    }


}
