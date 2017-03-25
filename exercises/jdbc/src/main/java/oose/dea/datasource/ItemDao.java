package oose.dea.datasource;

import oose.dea.datasource.util.DatabaseProperties;
import oose.dea.domain.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by alexanderstenkoning on 24/03/17.
 */
public class ItemDao {
    private Logger logger = Logger.getLogger(getClass().getName());
    private DatabaseProperties dbProps;

    public ItemDao(DatabaseProperties dbProps){
        this.dbProps = dbProps;
        tryLoadJdbcDriver();
    }

    public List findAll() {
        List items = new ArrayList<Item>();
        tryFindAll(items);
        return items;
    }

    private void tryFindAll(List<Item> items) {
        try {
            Connection connection = DriverManager.getConnection(dbProps.getDNS());
            PreparedStatement statement = connection.prepareStatement("SELECT * from items");
            addNewItemsFromDatabase(items, statement);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + dbProps.getDNS(), e);
        }
    }

    private void tryLoadJdbcDriver(){
        try {
            Class.forName(dbProps.getMySQL_Driver());
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Can't load JDBC Driver " + dbProps.getMySQL_Driver(), e);
        }
    }

    /*private List<Item> getListFromResultSet(ResultSet rs) throws SQLException {
        List items = new ArrayList<Item>();
        rs.first();
        while(rs.next()){
            String category = rs.getString("category");
            String sku = rs.getString("sku");
            String title = rs.getString("title");
            items.add(new Item(sku, category, title));
        }
        return items;
    }*/

    private void addNewItemsFromDatabase(List<Item> items, PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next())
        {
            addNewItemFromResultSet(items, resultSet);
        }
    }

    private void addNewItemFromResultSet(List<Item> items, ResultSet resultSet) throws SQLException {
        Item item = new Item(
                resultSet.getString("sku"), resultSet.getString("category"), resultSet.getString("title")
        );
        items.add(item);
    }
}
