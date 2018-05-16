package web;

import DAO.CakesDAO;
import model.Cake;

import javax.persistence.EntityManager;
import java.util.List;

public class IndexBean {
    private final EntityManager em;
    private final CakesDAO cakesdao;

    public IndexBean(EntityManager em) {
        this.em = em;
        cakesdao = new CakesDAO(em);
    }

    public List<Cake> getCakes() {return new CakesDAO(em).findAllCakes();}
}
