package com.example.javabasics.model;

import com.example.javabasics.Utility.DatabaseManager;
import com.example.javabasics.Utility.HashPass;
import com.example.javabasics.Utility.Query;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.*;
import java.util.ArrayList;

import static com.example.javabasics.Utility.HashPass.getSalt;
import static com.example.javabasics.Utility.HashPass.getSecurePassword;

public class Main {

        public static void main(String[] args) throws SQLException, NullPointerException, NoSuchAlgorithmException, NoSuchProviderException {

            /*
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/JavaBasics","postgres","admin");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
            ResultSet rs =statement.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
            }


            DatabaseManager databaseManager = new DatabaseManager();
            Connection connection= databaseManager.getConnection();
            for (int i =1;i<=3;i++) {

                PreparedStatement statement = connection.prepareStatement("select password from users where id = ?");
                statement.setInt(1,i);
                ResultSet rs =statement.executeQuery();
                if (rs.next()) {
                    String pass = rs.getString(1);
                    String salt = HashPass.salt;
                    pass = getSecurePassword(pass, salt);
                    System.out.println(pass);

                    PreparedStatement statement1 = connection.prepareStatement("update users set password=? where id =?");
                    statement1.setString(1, pass);
                    statement1.setInt(2, i);
                    statement1.executeUpdate();
                }
*/
            String salt = HashPass.salt;
            String password="123jhonakos";
            String password1  = getSecurePassword(password, salt);
            System.out.println(password1);
            System.out.println(HashPass.getSalt().toString());
        }











    }













