package com.chamodshehanka.thogaKadeServer.repository.custom.impl;

import com.chamodshehanka.thogaKadeServer.entity.Customer;
import com.chamodshehanka.thogaKadeServer.repository.custom.CustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chamodshehanka on 11/24/2017
 * @project ThogaKadeRMIHibernate
 **/
public class CustomerRepositoryImpl implements CustomerRepository{

    private Connection connection;

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection = connection;
    }

    @Override
    public boolean save(Customer customer) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Customer VALUES (?,?,?,?)"
        );
        preparedStatement.setObject(1,customer.getId());
        preparedStatement.setObject(2,customer.getName());
        preparedStatement.setObject(3,customer.getAddress());
        preparedStatement.setObject(4,customer.getSalary());

        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean delete(Customer customer) throws Exception {
        Statement statement = connection.createStatement();
        return statement.executeUpdate("DELETE FROM customer WHERE id='"+customer.getId()+"'")>0;
    }

    @Override
    public boolean update(Customer customer) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE customer SET id=?,name=?,address=?,salary=?"
        );
        preparedStatement.setObject(1,customer.getId());
        preparedStatement.setObject(2,customer.getName());
        preparedStatement.setObject(3,customer.getAddress());
        preparedStatement.setObject(4,customer.getSalary());

        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public Customer findById(String s) throws Exception {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM customer WHERE id='"+s+"'");
        return resultSet.next() ? new Customer(
                resultSet.getString(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getDouble(4)
        ) : null;
    }

    @Override
    public List<Customer> findAll() throws Exception {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");
        ArrayList<Customer> customerArrayList = new ArrayList<>();
        while (resultSet.next()){
            Customer customer = new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4)
            );
            customerArrayList.add(customer);
        }
        return customerArrayList;
    }
}
