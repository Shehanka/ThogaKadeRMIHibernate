package com.chamodshehanka.thogaKadeServer.business;

import com.chamodshehanka.thogaKadeServer.business.custom.impl.CustomerBOImpl;
import com.chamodshehanka.thogaKadeServer.business.custom.impl.ItemBOImpl;

/**
 * @author chamodshehanka on 11/24/2017
 * @project ThogaKadeRMIHibernate
 **/
public class BOFactory {
    public enum BOType{
        CUSTOMER,ITEM
    }

    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBOFactory(){
        if (boFactory == null){
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public SuperBO getSuperBO(BOType boType){
        switch (boType){
            case ITEM: return new ItemBOImpl();
            case CUSTOMER: return new CustomerBOImpl();
            default: return null;
        }
    }
}
