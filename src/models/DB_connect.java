package models;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;



public class DB_connect {
    private String motor;
    private String server;
    private String puerto;
    private String bd;
    private String username;
    private String password;
    private Connection red;


    public DB_connect () {
        //Utilizamos los datos del archivo csv para generar el url de conexion.
        try {
        File archivo = new File("DB_info.csv");
        Scanner datos = new Scanner(archivo);
        String linea= datos.nextLine();
        while(datos.hasNextLine()){
            linea = datos.nextLine();
        }
        String[] parte = linea.split(",");
        //asigno valores por cada dato.
        this.motor = parte[0];
        this.server = parte[1];
        this.puerto = parte[2];
        this.bd = parte[3];
        this.username = parte[4];
        this.password = parte[5];
        //imprimir los valores para ver si la asignacion fue correcta.
        //System.out.println("jdbc:" + motor + "://" + server + ":" + puerto + "/" + bd);
        datos.close();
            
        } catch (Exception e) {
            this.motor = null;
            this.server = null;
            this.puerto = null;
            this.bd = null;
            this.username = null;
            this.password = null;
            System.out.println("El url no fue generado correctamente, comunicate con equipo Data");
        }
    }

    public Connection Generate_Connection() throws ClassNotFoundException, SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // No encuentra los recursos
            
            this.red = (Connection)DriverManager.getConnection(("jdbc:" + motor + "://" + server + ":" + puerto + "/" + bd), username, password);

            
        } catch (Exception e) {
            System.out.println(e);

        }

        return this.red;
    }

    //Cierre de la conexion generada
    public void Finish () throws SQLException{
        this.red.close();
    }

    //Mandamos el url en forma de texto
    public String DBName(){
        String text = null;
        text = "jdbc:" + motor + "://" + server + ":" + puerto + "/" + bd;
        return text;
    }
}
