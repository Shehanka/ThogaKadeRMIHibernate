package com.chamodshehanka.thogaKadeServer.repository;

import com.chamodshehanka.thogaKadeServer.repository.custom.impl.CustomerRepositoryImpl;
import com.chamodshehanka.thogaKadeServer.repository.custom.impl.ItemRepositoryImpl;

/**
 * @author chamodshehanka on 11/24/2017
 * @project ThogaKadeRMIHibernate
 **/
public class RepositoryFactory {
    private static RepositoryFactory repositoryFactory;

    public static RepositoryFactory getRepositoryFactory() {
        if (repositoryFactory == null){
            repositoryFactory = new RepositoryFactory();
        }
        return repositoryFactory;
    }

    private RepositoryFactory(){}

    public SuperRepository getRepository(RepositoryType type){
        switch (type){
            case CUSTOMER: return new CustomerRepositoryImpl();
            case ITEM: return new ItemRepositoryImpl();
            default: return null;
        }
    }

    public enum RepositoryType{
        CUSTOMER, ITEM
    }
}

