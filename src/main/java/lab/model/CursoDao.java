package lab.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class CursoDao {
	private List<Curso> cursoDataSource = new ArrayList<Curso>();
	
	public List<Curso> obterCursos() {
		//Esse código deve realizar uma pesquisa no banco de dados. 
		return cursoDataSource;
	}
	
	public void incluirCurso(Curso curso) {
		//Esse código deve realizar uma inclusão no banco de dados. 
		cursoDataSource.add(curso);
	}
	
	public void excluirCurso(Curso curso) {
		//Esse código deve realizar uma exclusão no banco de dados. 
		for (Curso cursoTemp : cursoDataSource) {
			if (cursoTemp.getCodigo().equals(curso.getCodigo())) {
				cursoDataSource.remove(cursoTemp);
				return;
			}
		}
	}
}
