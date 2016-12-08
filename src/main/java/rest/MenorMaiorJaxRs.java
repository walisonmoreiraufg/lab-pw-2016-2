package rest;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/menormaiorjaxrs")
public class MenorMaiorJaxRs {

	@GET
	@Path("/calcular")
	@Produces("application/json")
	public Calculo calcular() {
	  Calculo c = new Calculo();
	  c.setResultado("Maior");
	  c.setDataDeProcessamento(new Date().toString());
	  return c;
	}
}