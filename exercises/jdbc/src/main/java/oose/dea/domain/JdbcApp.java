package oose.dea.domain;

import oose.dea.datasource.ItemDao;
import oose.dea.datasource.util.DatabaseProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by alexanderstenkoning on 24/03/17.
 */
public class JdbcApp {

    public static void main(String[] args) {
        ItemDao itemDao = new ItemDao(new DatabaseProperties());
        List<Item> items = itemDao.findAll();
        for(Item item:items)
            System.out.println(item);
    }
}
