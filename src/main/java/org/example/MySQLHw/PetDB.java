package org.example.MySQLHw;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDB {
    public static List<Pet> select() {
        List<Pet> pets = new ArrayList<>();
        try {
            Connection connection = ConnectorDB.getConnectorDB();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from pets");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String animal = resultSet.getString(2);
                int age = resultSet.getInt(3);
                Pet pet = new Pet(id, animal, age);
                pets.add(pet);
            }
            return pets;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Pet selectOne(int id) {
        Pet pet = null;
        try {
            Connection connection = ConnectorDB.getConnectorDB();
            String sql = "select * from pets where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int animalId = resultSet.getInt(1);
                String animal = resultSet.getString(2);
                int age = resultSet.getInt(3);
                pet = new Pet(animalId, animal, age);
            }
            return pet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static int insert (Pet pet){
    try {
        Connection connection = ConnectorDB.getConnectorDB();
        String sql = "INSERT INTO pets (animal, age) values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, pet.getPet());
        preparedStatement.setInt(2,pet.getAge());
        return preparedStatement.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e);
    }return 0;
    }
    public static int update (Pet pet){
        try {
            Connection connection = ConnectorDB.getConnectorDB();
            String sql = "UPDATE pets SET animal=?, age=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pet.getPet());
            preparedStatement.setInt(2,pet.getAge());
            preparedStatement.setInt(3,pet.getId());
            return preparedStatement.executeUpdate();
        }  catch (SQLException e) {
            System.out.println(e);
        }return 0;
    }
    public static int delete (int id){
        try {
            Connection connection = ConnectorDB.getConnectorDB();
            String sql = "DELETE from pets where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }return 0;
    }
}
