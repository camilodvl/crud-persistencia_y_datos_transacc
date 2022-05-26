package edu.com.iudigital;

import edu.com.iudigital.db.DbConfig;
import edu.com.iudigital.models.Almacen;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Almacen almacen = new Almacen();
        almacen.printAlmacen();
        almacen.updateAlmacen(2);

    }

}