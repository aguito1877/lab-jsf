package lab.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class AlunoDao {
	private List<Aluno> alunoDataSource = new ArrayList<Aluno>();
	
	public List<Aluno> obterAlunos() {
		//Esse código deve realizar uma pesquisa no banco de dados. 
		return alunoDataSource;
	}
	
	public void incluirAluno(Aluno aluno) {
		//Esse código deve realizar uma inclusão no banco de dados. 
		alunoDataSource.add(aluno);
	}
	
	public void excluirAluno(Aluno aluno) {
		//Esse código deve realizar uma exclusão no banco de dados. 
		for (Aluno alunoTemp : alunoDataSource) {
			if (alunoTemp.getMatricula().equals(aluno.getMatricula())) {
				alunoDataSource.remove(alunoTemp);
				return;
			}
		}
	}
}
