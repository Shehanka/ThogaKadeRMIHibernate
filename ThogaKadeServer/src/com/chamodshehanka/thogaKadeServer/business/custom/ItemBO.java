package com.chamodshehanka.thogaKadeServer.business.custom;

import com.chamodshehanka.thogaKadeCommon.dto.ItemDTO;
import com.chamodshehanka.thogaKadeServer.business.SuperBO;

/**
 * @author chamodshehanka on 11/24/2017
 * @project ThogaKadeRMIHibernate
 **/
public interface ItemBO extends SuperBO{

    public boolean addItem(ItemDTO itemDTO)throws Exception;

}
