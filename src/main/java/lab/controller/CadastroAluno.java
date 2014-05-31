package lab.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import lab.model.Aluno;
import lab.model.AlunoService;

@ManagedBean
@RequestScoped
public class CadastroAluno {
	
	@ManagedProperty(value="#{alunoService}")
	private AlunoService alunoService;
	
	private Aluno aluno = new Aluno();

	//Para fazer "cache" e ganhar desempenho.
	private List<Aluno> alunos;

	public void setAlunoService(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public List<Aluno> getAlunos() {
		//Implementação de "cache" da lista de alunos.
		if (alunos == null) {
			alunos = alunoService.obterAlunos();
		}
		return alunos;
	}
	
	public String salvar() {
		alunoService.salvar(aluno);
		return "listagem?faces-redirect=true";
	}
	
	public String excluir(Aluno aluno) {
		alunoService.excluir(aluno);
		return "listagem?faces-redirect=true";
	}
}
