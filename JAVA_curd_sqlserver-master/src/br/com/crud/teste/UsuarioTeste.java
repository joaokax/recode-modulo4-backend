package br.com.crud.teste;

import br.com.crud.dao.UsuarioDAO;
import br.com.crud.model.Usuario;

public class UsuarioTeste {

	public static void main(String[] args) {

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		
		// ------------ Cria um usuario e salva no banco
		Usuario usuario = new Usuario();
		usuario.setNome("Natalia");
		usuario.setIdade(28);
		usuario.setEmail("natt.natalia.teste@email.com");
		usuario.setTelefone("21933335555");
		
		usuarioDAO.save(usuario);
		
		
		
		// ------------ Atualiza o usuario com id = 1 com os dados do objeto usuario1
		/*Usuario usuario1 = new Usuario();
		usuario1.setId_usuario(1);
		usuario1.setNome("Lucas");
		usuario1.setIdade(26);
		usuario1.setEmail("lucas_lucasss@email.com");
		usuario1.setTelefone("21977772222");
		
		usuarioDAO.update(usuario1);
		*/
		
		
		// ------------ Remove o usuario com id
		//usuarioDAO.removeById(1);
		
		
		
		// ------------ Lista todos os usuarios do banco de dados
		for (Usuario a : usuarioDAO.getUsuario()) {
			System.out.println("Nome: " + a.getNome() + "\nIdade: " + a.getIdade());
		}
		
		
	}

}
