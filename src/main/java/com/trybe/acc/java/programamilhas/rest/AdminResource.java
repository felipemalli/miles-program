package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import com.trybe.acc.java.programamilhas.service.AdminService;
import com.trybe.acc.java.programamilhas.util.TokenUtil;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/admin")
public class AdminResource {

  @Inject
  private AdminService adminService;

  @Inject
  private TokenUtil tokenUtil;

  /**
   * Lista todos os saldos.
   */
  @POST
  @Path("/saldos")
  @Produces(MediaType.APPLICATION_JSON)
  public Response listarSaldos(@QueryParam("token") String token)
      throws AcessoNaoAutorizadoException {
    tokenUtil.validarAdmToken(token);
    List<SaldoResult> saldoResult = adminService.listarSaldos();
    return Response.status(Response.Status.OK).entity(saldoResult).build();
  }

}