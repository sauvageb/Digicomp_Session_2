package fr.formation.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO : Data Access Object
 */
public class FruitDao {

    List<Fruit> fetchAll() {
        List<Fruit> fruitList = new ArrayList<>();
        try {
            Statement st = ConnectionManager.getConnection().createStatement();
            ResultSet results = st.executeQuery("SELECT * FROM fruits");
            while (results.next()) {
                Long id = results.getLong("id");
                String name = results.getString("name");
                Date date = results.getDate("expiration_date");
                Fruit newFruit = new Fruit(id, name, date.toLocalDate());
                fruitList.add(newFruit);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return fruitList;
    }


    Fruit fetchById(Long id) {
        return null;
    }

    /**
     * Save and return the saved object with generated id
     *
     * @param fruit
     * @return fruit
     */
//    Fruit save(Fruit fruit) {
//        try {
//
//            String q = "INSERT INTO fruits(name, expiration_date) VALUES(" + ")";
//
//            String insertQuery = "INSERT INTO fruits(name, expiration_date) VALUES(?,?)";
//            PreparedStatement pst = ConnectionManager.getConnection().prepareStatement(insertQuery);
//            pst.setString();
//            pst.setDate();
//
//        } catch (SQLException e) {
//           e.printStackTrace();
//        }
//
//        return null;
//    }


}
