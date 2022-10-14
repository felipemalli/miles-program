package com.trybe.acc.java.programamilhas.service;

import com.trybe.acc.java.programamilhas.dao.DominioDao;
import com.trybe.acc.java.programamilhas.model.Parceiro;
import com.trybe.acc.java.programamilhas.model.Produto;
import com.trybe.acc.java.programamilhas.model.TipoLancamento;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DominioService {

  @Inject
  private DominioDao dominioDao;

  /**
   * Lista parceiros.
   */
  public List<Parceiro> listarParceiros() {
    return dominioDao.listarParceiros();
  }

  /**
   * Lista produtos.
   */
  public List<Produto> listarProdutos() {
    return dominioDao.listarProdutos();
  }

  /**
   * Lista tipo lançamentos.
   */
  public List<TipoLancamento> listarTipoLancamentos() {
    return dominioDao.listarTipoLancamentos();
  }

}