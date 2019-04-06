/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ug.dao;

import com.ug.configs.HibernateUtil;

import com.ug.entities.Factura;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Tech2Go
 */
@Singleton(name = "FacturaDAO")
@Lock(LockType.READ)
@ApplicationScoped
public class FacturaDAO implements IFactura{

    Session session = HibernateUtil.getSessionFactory().openSession();
    Criteria criteria;
    List<Factura> facturaList;
    
    @Override
    public List<Factura> findAllFacturas() {
        criteria = session.createCriteria(Factura.class);
        facturaList = criteria.list();
        return facturaList;
    }

    @Override
    public Factura findFacturaByNumeroFactura(String numeroFactura) {
        criteria = session.createCriteria(Factura.class);
        criteria.add(Restrictions.eq("numeroFactura", numeroFactura));
        criteria.setMaxResults(1);
        facturaList = criteria.list();
        if(facturaList != null && !facturaList.isEmpty()){
            return facturaList.get(0);
        }else{
            return null;
        }
    }
    
    @Override
    public Factura findFacturaByCedulaCliente(String cedula){
        criteria = session.createCriteria(Factura.class);
        criteria.createCriteria("cliente").add(Restrictions.eq("cedula", cedula));
        criteria.setMaxResults(1);
        facturaList = criteria.list();
        if(facturaList != null && !facturaList.isEmpty()){
            return facturaList.get(0);
        }else{
            return null;
        }
    }
    
    
}
