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

    public void updateAlmacen(int idAlmacen){
        DbConfig dbConnection = new DbConfig("localhost","3306","mercafacil");

        Connection connection = dbConnection.connect();
        String query = String.format("SELECT * FROM almacenes WHERE idalmacenes=%d", idAlmacen);
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()){
                System.out.println("Se actualizará el almacen '"+resultSet.getString(4)+"' ");
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.print(e);
        }
    }
}
