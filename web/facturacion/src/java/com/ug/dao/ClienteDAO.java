/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ug.dao;

import com.ug.configs.HibernateUtil;
import com.ug.entities.Cliente;
import java.util.List;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Xndy
 */
@Singleton(name = "ClienteDAO")
@Lock(LockType.READ)
@ApplicationScoped
public class ClienteDAO implements ICliente{
    
    Session session = HibernateUtil.getSessionFactory().openSession();
    Criteria criteria;

    @Override
    public List<Cliente> findAllClientes() {
        criteria = session.createCriteria(Cliente.class);
        List<Cliente> clienteList = criteria.list();
        return clienteList;
    }
      
}
