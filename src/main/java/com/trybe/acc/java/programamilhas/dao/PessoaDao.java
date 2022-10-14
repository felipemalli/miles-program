package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.model.Pessoa;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@ApplicationScoped
public class PessoaDao {

  @Inject
  EntityManager entityManager;

  /**
   * Método responsável pela realização do login.
   * 
   * <p>
   * Não delete este método!
   * </p>
   */
  public Pessoa autenticar(String login, String hash) {
    String hql = "from " + Pessoa.class.getSimpleName() + " where login = :login and hash = :hash";
    Query query = entityManager.createQuery(hql);
    query.setParameter("login", login);
    query.setParameter("hash", hash);
    return (Pessoa) query.getSingleResult();
  }

  /**
   * Salva uma pessoa.
   */
  @Transactional
  public void criar(Pessoa pessoa) {
    entityManager.persist(pessoa);
  }

  /**
   * Busca todas as pessoas.
   */
  public List<Pessoa> listarTodas() {
    String hql = "from " + Pessoa.class.getSimpleName();
    TypedQuery<Pessoa> query = entityManager.createQuery(hql, Pessoa.class);
    return query.getResultList();
  }

  /**
   * Busca uma pessoa pelo id.
   */
  public Pessoa listaPorId(int id) {
    return entityManager.find(Pessoa.class, id);
  }

  /**
   * Deleta uma pessoa.
   */
  @Transactional
  public void deletar(Pessoa pessoa) {
    entityManager.remove(pessoa);
  }

}
