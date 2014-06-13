package lab.model;

import java.sql.Connection;
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
	
	public List<Curso> obterCursos() {
		//Cria uma lista de cursos.
		List<Curso> cursos = new ArrayList<Curso>();
		try {
			Connection conn = JdbcUtil.createConnection();
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
		try {
			Connection conn = JdbcUtil.createConnection();
			//Obtém uma sentença SQL.
			Statement stmt = conn.createStatement();
			//Executa a instrução SQL.
			stmt.executeUpdate("insert into curso (codigo, nome) "
					+ "values "
					+ "("
					+ "" + curso.getCodigo() + ", "
					+ "'" + curso.getNome() + "'"
					+ ")");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void excluirCurso(Curso curso) {
		try {
			Connection conn = JdbcUtil.createConnection();
			//Obtém uma sentença SQL.
			Statement stmt = conn.createStatement();
			//Executa a instrução SQL.
			stmt.executeUpdate("delete from curso where curso.codigo = "
					+ curso.getCodigo());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
