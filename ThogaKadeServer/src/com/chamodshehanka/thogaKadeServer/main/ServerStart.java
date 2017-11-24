package com.chamodshehanka.thogaKadeServer.main;

import com.chamodshehanka.thogaKadeServer.service.ServiceFactoryImpl;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author chamodshehanka on 11/24/2017
 * @project ThogaKadeRMIHibernate
 **/
public class ServerStart {
    public static void main(String[] args) {
        System.setProperty("java.rmi.server.hostname","127.0.0.1");
        try {
            Registry registry = LocateRegistry.createRegistry(5050);
            System.out.println("Server is starting..........");
            registry.rebind("ThogaKadeServer",new ServiceFactoryImpl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
