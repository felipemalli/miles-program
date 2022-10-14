package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.dto.LoginDto;
import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.exception.ValidacaoException;
import com.trybe.acc.java.programamilhas.result.MensagemResult;
import com.trybe.acc.java.programamilhas.service.PessoaService;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pessoa")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PessoaResource {

  @Inject
  private PessoaService pessoaService;

  /**
   * Cria uma pessoa usuária.
   */
  @POST
  public Response create(LoginDto loginDto) {
    pessoaService.create(loginDto.getLogin(), loginDto.getSenha());
    MensagemResult mensagemResult = new MensagemResult("Usuário criado.");

    return Response.status(Response.Status.OK).entity(mensagemResult).build();
  }

  /**
   * Deleta uma pessoa usuária.
   */
  @DELETE
  public Response delete(@QueryParam("token") String token) {
    pessoaService.delete(token);
    MensagemResult mensagemResult = new MensagemResult("Usuário deletado.");

    return Response.status(Response.Status.OK).entity(mensagemResult).build();
  }
}