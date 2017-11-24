package com.chamodshehanka.thogaKadeServer.business.custom.impl;

import com.chamodshehanka.thogaKadeCommon.dto.ItemDTO;
import com.chamodshehanka.thogaKadeServer.business.custom.ItemBO;
import com.chamodshehanka.thogaKadeServer.repository.RepositoryFactory;
import com.chamodshehanka.thogaKadeServer.repository.custom.ItemRepository;

/**
 * @author chamodshehanka on 11/24/2017
 * @project ThogaKadeRMIHibernate
 **/
public class ItemBOImpl implements ItemBO{

    private ItemRepository itemRepository;

    public ItemBOImpl() {
        this.itemRepository = (ItemRepository) RepositoryFactory
                .getRepositoryFactory().getRepository(RepositoryFactory.RepositoryType.ITEM);
    }

    @Override
    public boolean addItem(ItemDTO itemDTO) throws Exception {
        return false;
    }
}
