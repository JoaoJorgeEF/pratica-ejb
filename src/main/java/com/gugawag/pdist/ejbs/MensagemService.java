package com.gugawag.pdist.ejbs;

import java.util.List;
import com.gugawag.pdist.model.Mensagem;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless(name = "mensagemService")
@Remote
public class MensagemService {

    @EJB
    private MensagemDAO mensagemDAO;

    public List<Mensagem> listar(){
        return mensagemDAO.listar();
    }

    public void inserir(long id, String texto){
        Mensagem msg = new Mensagem(id, texto);
        mensagemDAO.inserir(msg);
    }
}
