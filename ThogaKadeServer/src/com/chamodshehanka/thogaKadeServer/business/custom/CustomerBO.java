package com.chamodshehanka.thogaKadeServer.business.custom;

import com.chamodshehanka.thogaKadeCommon.dto.CustomerDTO;
import com.chamodshehanka.thogaKadeServer.business.SuperBO;

/**
 * @author chamodshehanka on 11/24/2017
 * @project ThogaKadeRMIHibernate
 **/
public interface CustomerBO extends SuperBO{

    boolean addCustomer(CustomerDTO customerDTO)throws Exception;

    CustomerDTO searchByID(String id)throws Exception;
}
