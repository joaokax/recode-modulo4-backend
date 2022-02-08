package br.com.crud.teste;

import br.com.crud.dao.DestinoDAO;
import br.com.crud.model.Destino;

public class DestinoTeste {

	public static void main(String[] args) {

		DestinoDAO destinoDAO = new DestinoDAO();
		
		
		// ------------ Cria um destino e salva no banco
		Destino destino = new Destino();
		destino.setCidadeDestino("Rio de Janeiro");
		
		destinoDAO.save(destino);
		
		
		
		// ------------ Atualiza o destino com id = 1 com os dados do objeto destino1
		/*Destino destino1 = new Destino();
		destino1.setId_destino(1);
		destino1.setCidadeDestino("Lucas");
		
		destinoDAO.update(destino1);
		*/
		
		
		// ------------ Remove o destino com id
		//destinoDAO.removeById(1);
		
		
		
		// ------------ Lista todos os destinos do banco de dados
		for (Destino a : destinoDAO.getDestino()) {
			System.out.println("Cidade: " + a.getCidadeDestino());
		}
		
		
	}

	
}
