package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Usuario;

public class UsuarioDAO {
	
	public void save(Usuario usuario) {
		/*
		 * Isso � uma sql comum, os ? s�o os par�metros que n�s vamos adicionar na base
		 * de dados
		 */

		String sql = "INSERT INTO Usuario (Nome, Idade, Email, Telefone)" + "VALUES(?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conex�o com o banco
			conn = ConnectionFactory.createConnectionSQLServer();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro par�metro da sql
			pstm.setString(1, usuario.getNome());

			// Adicionar o valor do segundo par�metro da sql
			pstm.setInt(2, usuario.getIdade());

			// Adicionar o valor do terceiro par�metro da sql
			pstm.setString(3, usuario.getEmail());

			// Adicionar o valor do quarto par�metro da sql
			pstm.setString(4, usuario.getTelefone());
			

			// Executar a sql para inser��o dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fecha as conex�es
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void removeById(int id) {
		String sql = "DELETE FROM Usuario WHERE Id_usuario = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Usuario usuario) {
		String sql = "UPDATE Usuario SET Nome = ?, Idade = ?, Email = ?, Telefone = ? WHERE Id_usuario = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conex�o com o banco
			conn = ConnectionFactory.createConnectionSQLServer();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro par�metro da sql
			pstm.setString(1, usuario.getNome());

			// Adicionar o valor do segundo par�metro da sql
			pstm.setInt(2, usuario.getIdade());

			pstm.setString(3, usuario.getEmail());

			pstm.setString(4, usuario.getTelefone());
			
			// Adicionar o valor para par�metro ID da sql
			pstm.setInt(5, usuario.getId_usuario());

			// Executa a sql para inser��o dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conex�es
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Usuario> getUsuario() {

		String sql = "SELECT * FROM Usuario";

		List<Usuario> usuarios = new ArrayList<Usuario>();

		Connection conn = null;
		PreparedStatement pstm = null;

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, fa�a
			while (rset.next()) {
				Usuario usuario = new Usuario();

				// Recupera o id do banco e atribui ele ao objeto
				usuario.setId_usuario(rset.getInt("Id_usuario"));

				// Recupera o nome do banco e atribui ele ao objeto
				usuario.setNome(rset.getString("Nome"));

				// Recupera a idade do banco e atribui ele ao objeto
				usuario.setIdade(rset.getInt("Idade"));

				// Recupera o nome do banco e atribui ele ao objeto
				usuario.setEmail(rset.getString("Email"));

				// Recupera a idade do banco e atribui ele ao objeto
				usuario.setTelefone(rset.getString("Telefone"));				

				// Adiciona o contato recuperado, a lista de contatos
				usuarios.add(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return usuarios;
	}
}
