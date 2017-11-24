package com.chamodshehanka.thogaKadeServer.repository;

import java.sql.Connection;
import java.util.List;

/**
 * @author chamodshehanka on 11/24/2017
 * @project ThogaKadeRMIHibernate
 **/
public interface SuperRepository<T,ID> {

    public void setConnection(Connection connection)throws Exception;

    public boolean save(T t)throws Exception;

    public boolean delete(T t)throws Exception;

    public boolean update(T t)throws Exception;

    public  T findById(ID id)throws Exception;

    public List<T> findAll()throws Exception;
}
