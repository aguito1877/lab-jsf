package lab.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class CursoDao {

	public CursoDao() {
		try {
			//Carrega o driver do banco de dados.
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private List<Curso> cursoDataSource = new ArrayList<Curso>();
	
	public List<Curso> obterCursos() {
		//Cria uma lista de cursos.
		List<Curso> cursos = new ArrayList<Curso>();
		try {
			// URL de conexão JDBC com o banco de dados.
			String url = "jdbc:derby://localhost/db";
			// Obtém uma conexão com o banco de dados.
			Connection conn = DriverManager
					.getConnection(url, "app", "123");
			//Obtém uma sentença SQL.
			Statement stmt = conn.createStatement();
			//Executa a instrução SQL.
			ResultSet rs = stmt
					.executeQuery("select codigo, nome from curso");
			//Percorre todos os registros.
			while (rs.next()) {
				String codigo = rs.getString("codigo");
				String nome = rs.getString("nome");

				Curso curso = new Curso();
				curso.setCodigo(codigo);
				curso.setNome(nome);
				cursos.add(curso);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return cursos;
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
