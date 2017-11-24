package com.chamodshehanka.thogaKadeServer.repository.custom.impl;

import com.chamodshehanka.thogaKadeServer.entity.Item;
import com.chamodshehanka.thogaKadeServer.repository.custom.ItemRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * @author chamodshehanka on 11/24/2017
 * @project ThogaKadeRMIHibernate
 **/
public class ItemRepositoryImpl implements ItemRepository{

    private Connection connection;
    
    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection = connection;
    }

    @Override
    public boolean save(Item item) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO item VALUES (?,?,?,?)"
        );
        preparedStatement.setObject(1,item.getCode());
        preparedStatement.setObject(2,item.getDescription());
        preparedStatement.setObject(3,item.getUnitPrice());
        preparedStatement.setObject(4,item.getQtyOnHand());

        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean delete(Item item) throws Exception {
        Statement statement = connection.createStatement();
        return statement.executeUpdate("DELETE FROM item WHERE code='"+"'")>0;
    }

    @Override
    public boolean update(Item item) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE item SET code=?,description=?,unitPrice=?,qtyOnHand=?"
        );
        preparedStatement.setObject(1,item.getCode());
        preparedStatement.setObject(2,item.getDescription());
        preparedStatement.setObject(3,item.getUnitPrice());
        preparedStatement.setObject(4,item.getQtyOnHand());

        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public Item findById(String s) throws Exception {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM item WHERE code='"+"'");
        return resultSet.next() ? new Item(
                resultSet.getString(1),
                resultSet.getString(2),
                resultSet.getDouble(3),
                resultSet.getInt(4)
        ) : null;
    }

    @Override
    public List<Item> findAll() throws Exception {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM item");
        return null;
    }
}
