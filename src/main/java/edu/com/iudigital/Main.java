package edu.com.iudigital;

import edu.com.iudigital.db.DbConfig;
import edu.com.iudigital.models.Almacen;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Almacen almacen = new Almacen();

        System.out.println("***** Obteniendo lista de almacenes *****");
        almacen.printAlmacen();

        System.out.println("***** Modificando el almacen con id 2 *****");
        almacen=almacen.getAlmacen(2);
        System.out.println("Se recuperó el almacen con nombre "+ almacen.getNombreAlmacen());
        almacen.setNombreAlmacen("Nuevo nombre");
        almacen.updateAlmacen(almacen);

        System.out.println("***** Creando nuevo almacen *****");
        Almacen almacen1 = new Almacen();
        almacen1.setNombreGerente("Camilord");
        almacen1.setApellidoGerente("Rami");
        almacen1.setNombreAlmacen("Lo mejorcito");
        almacen1.setDireccion("EL carmen de vibo");
        almacen1.createAlmacen(almacen1);
        almacen1.printAlmacen();

        System.out.println("***** Eliminando almacen *****");
        almacen1.deleteAlmacen(5);
        almacen1.printAlmacen();



    }

}