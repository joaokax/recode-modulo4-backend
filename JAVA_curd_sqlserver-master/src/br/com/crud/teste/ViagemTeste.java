package br.com.crud.teste;

import br.com.crud.dao.ViagemDAO;
import br.com.crud.model.Viagem;

public class ViagemTeste {

	public static void main(String[] args) {

		ViagemDAO viagemDAO = new ViagemDAO();
		
		
		// ------------ Cria uma viagem e salva no banco
		/*Viagem viagem = new Viagem();
		viagem.setAeroportoPartida("Santos Dumond");
		viagem.setAeroportoChegada("Congonhas");
		viagem.setDataIda("23/05/2022");
		viagem.setDataVolta("26/05/2022");
		viagem.setValor(320);
		viagem.setId_usuario(1);
		viagem.setId_destino(1);
		
		
		viagemDAO.save(viagem);*/
		
		
		
		// ------------ Atualiza a viagem com id = 1 com os dados do objeto viagem1
		/*Viagem viagem1 = new Viagem();
		viagem1.setId_destino(1);
		
		viagem1.setAeroportoPartida("AeroSP");
		viagem1.setAeroportoChegada("AeroRIO");
		viagem1.setDataIda("24/05/2022");
		viagem1.setDataVolta("27/05/2022");
		viagem1.setValor(310);
		viagem1.setId_usuario(2);
		viagem1.setId_destino(2);

		
		viagemDAO.update(viagem1);
		*/
		
		
		// ------------ Remove o viagem com id
		//viagemDAO.removeById(1);
		
		
		
		// ------------ Lista todos as viagens do banco de dados
		for (Viagem a : viagemDAO.getViagem()) {
		 System.out.println("Dados da sua viagem: " + "\nAeroporto: " + a.getAeroportoPartida() + "\nCliente: " + a.getUsuario().getNome() + "\nDestino: " + a.getDestino().getCidadeDestino());
		}
		
		
	}

	
	
}
