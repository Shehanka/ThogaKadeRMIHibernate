package com.chamodshehanka.thogaKadeCommon.service.custom;

import com.chamodshehanka.thogaKadeCommon.dto.ItemDTO;
import com.chamodshehanka.thogaKadeCommon.service.SuperService;

/**
 * @author chamodshehanka on 11/24/2017
 * @project ThogaKadeRMIHibernate
 **/
public interface ItemService extends SuperService{
    public boolean addItem(ItemDTO itemDTO)throws Exception;
}
