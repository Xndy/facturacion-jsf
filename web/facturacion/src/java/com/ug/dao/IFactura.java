/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ug.dao;


import com.ug.entities.Factura;
import java.util.List;

/**
 *
 * @author Tech2Go
 */
public interface IFactura {
    
    public List<Factura> findAllFacturas();
      
    public Factura findFacturaByNumeroFactura(String numeroFactura);
    
    
    public Factura findFacturaByCedulaCliente(String cedula);
    
}
