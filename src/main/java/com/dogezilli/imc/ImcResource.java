package com.dogezilli.imc;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.HashMap;
import java.util.Map;

@Path("imc")
public class ImcResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response calcularImc(@QueryParam("peso") Double peso, @QueryParam("altura") Double altura, @QueryParam("nome") String nome) {
        Double imc = peso / (altura * altura);
        Map<String, String> dados = new HashMap<String, String>();
        dados.put("mensagem", String.format("Olá %s, seu IMC é %.2f ", nome, imc));
        return Response.ok(dados).build();
    }
}
