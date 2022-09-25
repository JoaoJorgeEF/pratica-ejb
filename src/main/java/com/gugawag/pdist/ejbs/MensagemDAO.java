package com.gugawag.pdist.ejbs;

import java.util.List;
import com.gugawag.pdist.model.Mensagem;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MensagemDAO {
    @PersistenceContext(unitName="default")
    private EntityManager em;

    public void inserir(Mensagem mensagem) {
        em.persist(mensagem);
    }

    public List<Mensagem> listar(){
        return em.createQuery("FROM Mensagem").getResultList();
    }

    public int pesquisarPorId(long id){
        return em.createQuery("FROM Mensagem m WHERE m.id = :idMsg")
                .setParameter("idMsg", id)
                .getFirstResult();
    }
}
