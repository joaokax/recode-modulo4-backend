package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Viagem;
import br.com.crud.model.Usuario;
import br.com.crud.model.Destino;



public class ViagemDAO {
	
	public void save(Viagem viagem) {
		/*
		 * Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
		 * de dados
		 */

		String sql = "INSERT INTO Viagem (AeroportoPartida, AeroportoChegada, DataIda, DataVolta, Valor, UsuarioId_usuario, DestinoId_destino)" + "VALUES(?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionSQLServer();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parâmetro da sql
			pstm.setString(1, viagem.getAeroportoPartida());
			
			pstm.setString(2, viagem.getAeroportoChegada());

			pstm.setString(3, viagem.getDataIda());

			pstm.setString(4, viagem.getDataVolta());

			pstm.setFloat(5, viagem.getValor());

			pstm.setInt(6, viagem.getId_usuario());
			
			pstm.setInt(7, viagem.getId_destino());

			// Executar a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fecha as conexões
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
		String sql = "DELETE FROM Viagem WHERE Id_viagem = ?";

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

	public void update(Viagem viagem) {
		String sql = "UPDATE Viagem SET AeroportoPartida = ?, AeroportoChegada = ?, DataIda = ?, DataVolta = ?, Valor = ?, UsuarioId_usuario = ?, DestinoId_destino = ?  WHERE Id_destino = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionSQLServer();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, viagem.getAeroportoPartida());
			
			// Adicionar o valor para parâmetro ID da sql
			pstm.setString(2, viagem.getAeroportoChegada());
			
			pstm.setString(3, viagem.getDataIda());
			
			pstm.setString(4, viagem.getDataVolta());
			
			pstm.setFloat(5, viagem.getValor());
			
			pstm.setInt(6, viagem.getId_usuario());
			
			pstm.setInt(7, viagem.getId_destino());
			

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
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

	public List<Viagem> getViagem() {

		String sql = "SELECT v.AeroportoPartida, v.AeroportoChegada, v.DataIda, v.DataVolta, v.Valor, u.Id_usuario, u.Nome as cliente, u.Email, d.Id_destino, d.CidadeDestino FROM Viagem as v inner join Usuario as u on v.UsuarioId_usuario = u.Id_usuario inner join Destino as d on v.DestinoId_destino = d.Id_destino";

		List<Viagem> viagens = new ArrayList<Viagem>();

		Connection conn = null;
		PreparedStatement pstm = null;

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {
				Viagem viagem = new Viagem();
				Usuario usuario = new Usuario();
				Destino destino = new Destino();

				// Recupera o nome do banco e atribui ele ao objeto
				viagem.setAeroportoPartida(rset.getString("AeroportoPartida"));	
				
				viagem.setAeroportoChegada(rset.getString("AeroportoChegada"));	

				viagem.setDataIda(rset.getString("DataIda"));	

				viagem.setDataVolta(rset.getString("DataVolta"));	

				viagem.setValor(rset.getFloat("Valor"));
				
				usuario.setId_usuario(rset.getInt("Id_usuario"));	

				usuario.setNome(rset.getString("cliente"));	
				
				usuario.setEmail(rset.getString("Email"));	
				
				viagem.setUsuario(usuario);
				
				destino.setId_destino(rset.getInt("Id_destino"));	

				destino.setCidadeDestino(rset.getString("CidadeDestino"));	

				viagem.setDestino(destino);


				// Adiciona o contato recuperado, a lista de contatos
				viagens.add(viagem);
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
		return viagens;
	}
}
