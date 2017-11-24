package com.chamodshehanka.thogaKadeClient.ui.controller;

import com.chamodshehanka.thogaKadeClient.proxy.ProxyHandler;
import com.chamodshehanka.thogaKadeCommon.dto.CustomerDTO;
import com.chamodshehanka.thogaKadeCommon.service.ServiceFactory;
import com.chamodshehanka.thogaKadeCommon.service.custom.CustomerService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author chamodshehanka on 11/24/2017
 * @project ThogaKadeRMIHibernate
 **/
public class CustomerUIController implements Initializable{

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtSalary;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnDelete;

    private CustomerService customerService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            customerService = (CustomerService) ProxyHandler.getProxyHandler().getServiceFactory().getService(
                    ServiceFactory.ServiceType.CUSTOMER
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addCustomerAction(){
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        double salary = Double.parseDouble(txtSalary.getText());

        CustomerDTO customerDTO = new CustomerDTO(id,name,address,salary);

        try {
            boolean isAdded = ProxyHandler.getProxyHandler().getCustomerService().addCustomer(customerDTO);
            boolean i =customerService.addCustomer(customerDTO);
            if (isAdded){
                System.out.println("Added");
            }else {
                System.out.println("Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void searchById(){
        try {
            CustomerDTO customerDTO = ProxyHandler.getProxyHandler().getCustomerService().searchByID(txtId.getText());
            if(customerDTO != null){
                txtName.setText(customerDTO.getName());
                txtAddress.setText(customerDTO.getAddress());
                txtSalary.setText(String.valueOf(customerDTO.getSalary()));
            }else {
                System.out.println("Not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
