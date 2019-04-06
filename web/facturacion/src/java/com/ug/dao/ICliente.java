/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ug.dao;

import com.ug.entities.Cliente;
import java.util.List;

/**
 *
 * @author Tech2Go
 */
public interface ICliente {
    
    public List<Cliente> findAllClientes();
    
    
    public List<Cliente> findAllClientesByNombres(String nombre);
    
    
    public Cliente findClienteByCedula(String cedula);


    
    
}
