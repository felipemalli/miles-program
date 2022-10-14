package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.model.Lancamento;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@ApplicationScoped
public class LancamentoDao {

  @Inject
  private EntityManager entityManager;

  /**
   * Busca os lançamentos de uma conta especificada pelo id do seu proprietário.
   */
  public List<Lancamento> listarLancamentosPorIdUsuario(int idUsuario) {
    String hql = "from " + Lancamento.class.getSimpleName() + " where idpessoa = :idpessoa";
    TypedQuery<Lancamento> query = entityManager.createQuery(hql, Lancamento.class);
    query.setParameter("idpessoa", idUsuario);
    return query.getResultList();
  }

}