/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ug.beans;

import com.ug.dao.IFactura;
import com.ug.entities.Factura;
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
public class FacturaMB implements Serializable {

    @Inject
    private IFactura iFactura;

    private Factura factura;
    private List<Factura> facturaList;

    private String numeroFactura;
    private String cedula;

    @PostConstruct
    public void init() {
        facturaList = iFactura.findAllFacturas();
    }

    public void findFacturaByNumeroFactura() {
        facturaList.clear();
        factura = iFactura.findFacturaByNumeroFactura(numeroFactura);
        if (factura != null) {
            facturaList.add(factura);
        }
    }
    
    public void findFacturaByCedulaCliente() {
        facturaList.clear();
        factura = iFactura.findFacturaByCedulaCliente(cedula);
        if (factura != null) {
            facturaList.add(factura);
        }
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

}
