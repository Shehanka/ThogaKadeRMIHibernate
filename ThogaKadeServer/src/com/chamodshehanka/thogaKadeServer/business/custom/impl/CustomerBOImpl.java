package com.chamodshehanka.thogaKadeServer.business.custom.impl;

import com.chamodshehanka.thogaKadeCommon.dto.CustomerDTO;
import com.chamodshehanka.thogaKadeServer.business.custom.CustomerBO;
import com.chamodshehanka.thogaKadeServer.entity.Customer;
import com.chamodshehanka.thogaKadeServer.repository.RepositoryFactory;
import com.chamodshehanka.thogaKadeServer.repository.custom.CustomerRepository;
import com.chamodshehanka.thogaKadeServer.resource.DBConnection;

import java.sql.Connection;

/**
 * @author chamodshehanka on 11/24/2017
 * @project ThogaKadeRMIHibernate
 **/
public class CustomerBOImpl implements CustomerBO{

    private CustomerRepository customerRepository;

    public CustomerBOImpl() {
        this.customerRepository = (CustomerRepository) RepositoryFactory.getRepositoryFactory()
                .getRepository(RepositoryFactory.RepositoryType.CUSTOMER);
    }

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception {
        Connection connection = DBConnection.getConnection();
        customerRepository.setConnection(connection);
        return customerRepository.save(new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getSalary()
        ));
    }

    @Override
    public CustomerDTO searchByID(String id) throws Exception {
        Connection connection = DBConnection.getConnection();
        customerRepository.setConnection(connection);
        Customer customer = customerRepository.findById(id);
        return new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getAddress(),
                customer.getSalary()
        );
    }
}
