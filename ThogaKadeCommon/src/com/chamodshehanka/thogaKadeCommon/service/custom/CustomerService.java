package com.chamodshehanka.thogaKadeCommon.service.custom;

import com.chamodshehanka.thogaKadeCommon.dto.CustomerDTO;
import com.chamodshehanka.thogaKadeCommon.service.SuperService;

/**
 * @author chamodshehanka on 11/24/2017
 * @project ThogaKadeRMIHibernate
 **/
public interface CustomerService extends SuperService{
    public boolean addCustomer(CustomerDTO customerDTO)throws Exception;

    public CustomerDTO searchByID(String id)throws Exception;
}
