package resteasy;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/alunos")
public class AlunoController {

	@GET
	@Path("/todos")
	@Produces("application/json")
	public List<Aluno> todos() {
	  List<Aluno> alunos = new ArrayList<>();
	  alunos.add(new Aluno("" + this, "João", "123"));
	  alunos.add(new Aluno("2", "José", "234"));
	  alunos.add(new Aluno("3", "Maria", "345"));
		return alunos;
	}
}