package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.model.Lancamento;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import com.trybe.acc.java.programamilhas.service.ContaService;
import com.trybe.acc.java.programamilhas.util.TokenUtil;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/conta")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContaResource {

  @Inject
  private ContaService contaService;

  @Inject
  private TokenUtil tokenUtil;

  /**
   * Lista lançamentos pelo token com id do usuário.
   */
  @GET
  @Path("/extrato")
  public Response listarLancamentosPorIdUsuario(@QueryParam("token") String token)
          throws AcessoNaoAutorizadoException {
    int idUsuario = tokenUtil.obterIdUsuario(token);
    List<Lancamento> lancamentos = contaService.listaLancamentosPorIdUsuario(idUsuario);
    return Response.status(Response.Status.OK).entity(lancamentos).build();
  }

  /**
   * Lista saldo pelo token com id do usuário.
   */
  @GET
  @Path("/saldo")
  public Response listarSaldoPorIdUsuario(@QueryParam("token") String token)
          throws AcessoNaoAutorizadoException {
    int idUsuario = tokenUtil.obterIdUsuario(token);
    int saldo = contaService.listarSaldoPorIdUsuario(idUsuario);
    SaldoResult saldoResult = new SaldoResult(saldo);
    return Response.status(Response.Status.OK).entity(saldoResult).build();
  }

}