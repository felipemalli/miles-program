package com.trybe.acc.java.programamilhas.service;

import com.trybe.acc.java.programamilhas.dao.LancamentoDao;
import com.trybe.acc.java.programamilhas.dao.PessoaDao;
import com.trybe.acc.java.programamilhas.dominio.TipoLancamentoEnum;
import com.trybe.acc.java.programamilhas.model.Lancamento;
import com.trybe.acc.java.programamilhas.model.Pessoa;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AdminService {

  @Inject
  private LancamentoDao lancamentoDao;

  @Inject
  private PessoaDao pessoaDao;

  /**
   * Lista todos os saldos.
   */
  public List<SaldoResult> listarSaldos() {
    List<Pessoa> pessoas = pessoaDao.listarTodas();
    List<Integer> saldos = new ArrayList<>();

    for (Pessoa pessoa : pessoas) {
      int saldo = 0;
      int idUsuario = pessoa.getId();

      List<Lancamento> lancamentos = lancamentoDao.listarLancamentosPorIdUsuario(idUsuario);

      for (Lancamento lancamento : lancamentos) {
        int idTipoLancamento = lancamento.getTipoLancamento().getId();
        if (
            idTipoLancamento == TipoLancamentoEnum.TRANSFERENCIA.getId()
            ||
            idTipoLancamento == TipoLancamentoEnum.RESGATE.getId()
        ) {
          saldo -= lancamento.getValor();
        } else {
          saldo += lancamento.getValor();
        }
      }

      saldos.add(saldo);
    }

    return saldos.stream()
            .map(SaldoResult::new)
            .collect(Collectors.toList());
  }
}