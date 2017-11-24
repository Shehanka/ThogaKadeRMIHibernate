package com.chamodshehanka.thogaKadeServer.service.custom.impl;

import com.chamodshehanka.thogaKadeCommon.dto.CustomerDTO;
import com.chamodshehanka.thogaKadeCommon.service.custom.CustomerService;
import com.chamodshehanka.thogaKadeServer.business.BOFactory;
import com.chamodshehanka.thogaKadeServer.business.custom.CustomerBO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author chamodshehanka on 11/24/2017
 * @project ThogaKadeRMIHibernate
 **/
public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService{

    private final CustomerBO customerBO;

    public CustomerServiceImpl() throws RemoteException {
        customerBO = (CustomerBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOType.CUSTOMER);
    }

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception {
        return customerBO.addCustomer(customerDTO);
    }

    @Override
    public CustomerDTO searchByID(String id) throws Exception {
        return customerBO.searchByID(id);
    }
}
