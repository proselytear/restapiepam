package ua.epam.restapidemo.respository;

import ua.epam.restapidemo.model.Developer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeveloperRepository {
    public List<Developer> getAll() throws SQLException {
        String sql = "SELECT * FROM developers";
        Statement statement = ConnectionUtil.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        List<Developer> result = new ArrayList<>();

        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String specialty = resultSet.getString("specialty");
            result.add(new Developer(id, firstName, lastName, specialty));
        }

        return result;
    }
}
