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
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.createConnection();
			//Obtém uma sentença SQL.
			stmt = conn.createStatement();
			//Executa a instrução SQL.
			rs = stmt
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
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
		return cursos;
	}

	public void incluirCurso(Curso curso) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = JdbcUtil.createConnection();
			//Obtém uma sentença SQL.
			stmt = conn.createStatement();
			//Executa a instrução SQL.
			stmt.executeUpdate("insert into curso (codigo, nome) "
					+ "values "
					+ "("
					+ "" + curso.getCodigo() + ", "
					+ "'" + curso.getNome() + "'"
					+ ")");
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn, stmt);
		}
	}

	public void excluirCurso(Curso curso) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = JdbcUtil.createConnection();
			//Obtém uma sentença SQL.
			stmt = conn.createStatement();
			//Executa a instrução SQL.
			stmt.executeUpdate("delete from curso where curso.codigo = "
					+ curso.getCodigo());
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn, stmt);
		}
	}
}
