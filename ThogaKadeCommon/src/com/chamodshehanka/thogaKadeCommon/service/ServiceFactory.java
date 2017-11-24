package com.chamodshehanka.thogaKadeCommon.service;

import java.rmi.Remote;

/**
 * @author chamodshehanka on 11/24/2017
 * @project ThogaKadeRMIHibernate
 **/
public interface ServiceFactory extends Remote{

    public enum ServiceType{
        CUSTOMER,ITEM
    }

    public SuperService getService(ServiceType serviceType)throws Exception;

}
