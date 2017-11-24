package com.chamodshehanka.thogaKadeClient.proxy;

import com.chamodshehanka.thogaKadeCommon.service.ServiceFactory;
import com.chamodshehanka.thogaKadeCommon.service.custom.CustomerService;
import com.chamodshehanka.thogaKadeCommon.service.custom.ItemService;
import com.chamodshehanka.thogaKadeServer.service.custom.impl.CustomerServiceImpl;
import com.chamodshehanka.thogaKadeServer.service.custom.impl.ItemServiceImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author chamodshehanka on 11/24/2017
 * @project ThogaKadeRMIHibernate
 **/
public class ProxyHandler {

    private static ProxyHandler proxyHandler;
    private ServiceFactory serviceFactory;
    private CustomerService customerService;
    private ItemService itemService;

    private ProxyHandler(){
        try {
            serviceFactory = (ServiceFactory) Naming.lookup("rmi://localhost:5050/ThogaKadeServer");
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }

    public static ProxyHandler getProxyHandler(){
        if (proxyHandler == null) proxyHandler = new ProxyHandler();
        return  proxyHandler;
    }

    public ServiceFactory getServiceFactory() {
        return serviceFactory;
    }

    public CustomerService getCustomerService() throws RemoteException {
        if (customerService == null) customerService = new CustomerServiceImpl();
        return customerService;
    }

    public ItemService getItemService() {
        if (itemService == null) itemService = new ItemServiceImpl();
        return itemService;
    }
}
