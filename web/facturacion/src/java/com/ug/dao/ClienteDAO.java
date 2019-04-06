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
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Xndy
 */
@Singleton(name = "ClienteDAO")
@Lock(LockType.READ)
@ApplicationScoped
public class ClienteDAO implements ICliente {

    Session session = HibernateUtil.getSessionFactory().openSession();
    Criteria criteria;
    List<Cliente> clienteList;

    @Override
    public List<Cliente> findAllClientes() {
        criteria = session.createCriteria(Cliente.class);
        clienteList = criteria.list();
        return clienteList;
    }

    @Override
    public List<Cliente> findAllClientesByNombres(String nombre) {
        criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("nombres", nombre));
        //criteria.add(Restrictions.eq("nombres", nombre));
        //criteria.add(Restrictions.like("nombres", "%" + nombre + "%"));
        clienteList = criteria.list();
        return clienteList;
    }

    @Override
    public Cliente findClienteByCedula(String cedula) {
        criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("cedula", cedula));
        criteria.setMaxResults(1);
        clienteList = criteria.list();
        if (clienteList != null && !clienteList.isEmpty()) {
            return clienteList.get(0);
        } else {
            return null;
        }
    }

}
