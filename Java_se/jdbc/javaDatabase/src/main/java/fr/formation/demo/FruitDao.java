package fr.formation.demo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * DAO : Data Access Object
 */
public class FruitDao {

    public List<Fruit> fetchAll() {
        List<Fruit> fruitList = new ArrayList<>();
        String query = "SELECT * FROM fruits";

        try (Statement statement = ConnectionManager.getConnection().createStatement();
             ResultSet results = statement.executeQuery(query)) {

            while (results.next()) {
                Fruit newFruit = extractFruitFromResultSet(results);
                fruitList.add(newFruit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fruitList;
    }

    public Optional<Fruit> fetchById(Long id) {
        String query = "SELECT * FROM fruits WHERE id = ?";

        try (PreparedStatement pst = ConnectionManager.getConnection().prepareStatement(query)) {

            pst.setLong(1, id);
            try (ResultSet resultSet = pst.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(extractFruitFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    private Fruit extractFruitFromResultSet(ResultSet resultSet) throws SQLException {
        Long idFruit = resultSet.getLong("id");
        String name = resultSet.getString("name");
        LocalDate date = resultSet.getObject("expiration_date", LocalDate.class);
        return new Fruit(idFruit, name, date);
    }

    public Fruit save(Fruit fruit) throws RuntimeException {
        String insertQuery = "INSERT INTO fruits (name, expiration_date) VALUES (?, ?)";
        try (PreparedStatement pst = ConnectionManager.getConnection().prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {

            pst.setString(1, fruit.getName());
            pst.setDate(2, Date.valueOf(fruit.getExpirationDate()));
            pst.executeUpdate();

            ResultSet resultSet = pst.getGeneratedKeys();
                if (resultSet.next()) {
                    Long generatedKey = resultSet.getLong(1);
                    return new Fruit(generatedKey, fruit.getName(), fruit.getExpirationDate());
                } else {
                    throw new RuntimeException("Aucune clé générée");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'insertion du fruit : " + e.getMessage());
        }
    }

    public boolean deleteById(Long id) {
        String deleteQuery = "DELETE FROM fruits WHERE id = ?";
        try (PreparedStatement pst = ConnectionManager.getConnection().prepareStatement(deleteQuery)) {
            pst.setLong(1, id);
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Optional<Fruit> update(Fruit fruit) {
        String updateQuery = "UPDATE fruits SET name = ?, expiration_date = ? WHERE id = ?";
        try (PreparedStatement pst = ConnectionManager.getConnection().prepareStatement(updateQuery)) {
            pst.setString(1, fruit.getName());
            pst.setDate(2, Date.valueOf(fruit.getExpirationDate()));
            pst.setLong(3, fruit.getId());

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                return Optional.of(fruit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }



}

