/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ug.beans;

import com.ug.dao.ClienteDAO;
import com.ug.dao.ICliente;
import com.ug.entities.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Tech2Go
 */
@Named
@ViewScoped
public class ClienteMB implements Serializable{
    
    @Inject
    private ICliente iCliente;
    
    private Cliente cliente;
    private List<Cliente> clienteList;
    
    @PostConstruct
    public void init(){
        clienteList = iCliente.findAllClientes();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }
    
    
    
    
    
}
