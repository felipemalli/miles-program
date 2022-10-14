package com.trybe.acc.java.programamilhas.service;

import com.trybe.acc.java.programamilhas.dao.PessoaDao;
import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.model.Pessoa;
import com.trybe.acc.java.programamilhas.result.MensagemResult;
import com.trybe.acc.java.programamilhas.util.HashUtil;
import com.trybe.acc.java.programamilhas.util.TokenUtil;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class PessoaService {

  @Inject
  private PessoaDao pessoaDao;

  @Inject
  private TokenUtil tokenUtil;

  @Inject
  private HashUtil hashUtil;

  /**
   * Cria uma pessoa usuária.
   */
  @Transactional
  public MensagemResult criar(String login, String senha)
          throws InvalidKeySpecException, NoSuchAlgorithmException {
    String hash = hashUtil.hash(senha);
    Pessoa pessoa = new Pessoa();
    pessoa.setLogin(login);
    pessoa.setHash(hash);
    pessoaDao.criar(pessoa);
    return new MensagemResult("Usuário criado.");
  }

  /**
   * Deleta uma pessoa usuária pelo token com id.
   */
  @Transactional
  public MensagemResult deletarPorId(String token) throws AcessoNaoAutorizadoException {
    Integer id = this.tokenUtil.obterIdUsuario(token);
    pessoaDao.deletarPorId(id);
    return new MensagemResult("Usuário deletado.");
  }
}