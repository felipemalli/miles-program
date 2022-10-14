package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.model.Parceiro;
import com.trybe.acc.java.programamilhas.model.Produto;
import com.trybe.acc.java.programamilhas.model.TipoLancamento;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@ApplicationScoped
public class DominioDao {

  @Inject
  EntityManager entityManager;

  /**
   * Lista parceiros.
   */
  public List<Parceiro> listarParceiros() {
    String hql = "from " + Parceiro.class.getSimpleName();
    TypedQuery<Parceiro> query = entityManager.createQuery(hql, Parceiro.class);
    return query.getResultList();
  }

  /**
   * Lista produtos.
   */
  public List<Produto> listarProdutos() {
    String hql = "from " + Produto.class.getSimpleName();
    TypedQuery<Produto> query = entityManager.createQuery(hql, Produto.class);
    return query.getResultList();
  }

  /**
   * Lista tipo lançamentos.
   */
  public List<TipoLancamento> listarTipoLancamentos() {
    String hql = "from " + TipoLancamento.class.getSimpleName();
    TypedQuery<TipoLancamento> query = entityManager.createQuery(hql, TipoLancamento.class);
    return query.getResultList();
  }

}