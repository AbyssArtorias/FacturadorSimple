/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ebj;

import Obj.Venta;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Dildo__Queen
 */
@Stateless
@LocalBean
public class VentasDAO {

    @PersistenceContext
    EntityManager em;

    public void create(Venta ventas) {
        em.persist(ventas);
    }

    public void edit(Venta ventas) {
        em.merge(ventas);
    }

    public void delete(Venta ventas) {
        em.remove(ventas);
    }

    public Venta findById(Long id) {
        return (Venta) (em.find(Venta.class, id));
    }

    public List<Venta> findAll() {
        Query q = em.createQuery("SELECT v FROM Venta v");
        return q.getResultList();
    }

}
