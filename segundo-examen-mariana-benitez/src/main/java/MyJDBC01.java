package main.java;

import java.sql.*;

public class MyJDBC01 {

    public static void main(String[] args) {
        try{

            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc","root", "root");

            Statement statement = connection.createStatement();

            // String consultaSelect = "SELECT * FROM estudiante";

            ResultSet primerResultSet = statement.executeQuery("SELECT * FROM estudiante");
            // ResultSet primerResultSet = statement.executeQuery(consultaSelect);

            while(primerResultSet.next()){
                System.out.println(primerResultSet.getString("id") + " " + primerResultSet.getString("nombre") + " " + primerResultSet.getString("apellido"));
            }

            System.out.println();

            String sentenciaUpdate = "INSERT INTO estudiante (dni, nombre, apellido) VALUES (90000, 'Pablo', 'Aimar');";

            statement.executeUpdate(sentenciaUpdate);

            ResultSet segundoResultSet = statement.executeQuery("SELECT * FROM estudiante");

            while(segundoResultSet.next()){
                System.out.println(segundoResultSet.getString("id") + " " + segundoResultSet.getString("nombre")+ " " + segundoResultSet.getString("apellido"));
            }

        }catch(Exception e){
            // Instrucciones a ejecutar en caso que ocurra la excepción
            e.printStackTrace();
        }

    }

}
