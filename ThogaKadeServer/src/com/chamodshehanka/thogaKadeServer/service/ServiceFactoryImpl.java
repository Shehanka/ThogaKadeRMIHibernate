package com.chamodshehanka.thogaKadeServer.service;

import com.chamodshehanka.thogaKadeCommon.service.ServiceFactory;
import com.chamodshehanka.thogaKadeCommon.service.SuperService;
import com.chamodshehanka.thogaKadeServer.service.custom.impl.CustomerServiceImpl;
import com.chamodshehanka.thogaKadeServer.service.custom.impl.ItemServiceImpl;

import java.rmi.server.UnicastRemoteObject;

/**
 * @author chamodshehanka on 11/24/2017
 * @project ThogaKadeRMIHibernate
 **/
public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory{

    private static ServiceFactory serviceFactory;

    public ServiceFactoryImpl() throws Exception{

    }

    public static ServiceFactory getServiceFactory(ServiceFactory serviceFactory) throws Exception {
        if (serviceFactory == null) serviceFactory = new ServiceFactoryImpl();
        return serviceFactory;
    }

    @Override
    public SuperService getService(ServiceType serviceType) throws Exception {
        switch (serviceType){
            case CUSTOMER: return new CustomerServiceImpl();
            case ITEM: return new ItemServiceImpl();
            default: return null;
        }
    }
}
