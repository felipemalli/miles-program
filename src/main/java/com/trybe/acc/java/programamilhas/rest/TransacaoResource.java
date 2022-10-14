package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.dto.ResgateProdutoDto;
import com.trybe.acc.java.programamilhas.dto.TransferenciaDto;
import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.result.MensagemResult;
import com.trybe.acc.java.programamilhas.service.TransacaoService;
import com.trybe.acc.java.programamilhas.util.TokenUtil;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/transacao")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransacaoResource {

  @Inject
  private TransacaoService transacaoService;

  @Inject
  private TokenUtil tokenUtil;

  /**
   * Transfere da conta do token com id da pessoa usuária para a conta destino.
   */
  @POST
  @Path("/transferencia")
  public Response transferir(
          @QueryParam("token") String token, TransferenciaDto transferenciaDto
  ) throws AcessoNaoAutorizadoException {
    int idUsuario = tokenUtil.obterIdUsuario(token);
    transacaoService.transferir(idUsuario, transferenciaDto);
    MensagemResult mensagemResult = new MensagemResult("Transferência realizada.");
    return Response.status(Response.Status.OK).entity(mensagemResult).build();
  }

  /**
   * Resgata um produto pelo token com id da pessoa usuária.
   */
  @POST
  @Path("/resgate-produto")
  public Response resgatarProduto(
          @QueryParam("token") String token, ResgateProdutoDto resgateProdutoDto
  ) throws AcessoNaoAutorizadoException {
    int idUsuario = tokenUtil.obterIdUsuario(token);
    transacaoService.resgatarProduto(idUsuario, resgateProdutoDto);
    MensagemResult mensagemResult = new MensagemResult("Resgate realizado.");
    return Response.status(Response.Status.OK).entity(mensagemResult).build();
  }
}