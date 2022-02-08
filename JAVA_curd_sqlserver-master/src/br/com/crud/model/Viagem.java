package br.com.crud.model;

public class Viagem {
	private int Id_viagem;
	private String AeroportoPartida;
	private String AeroportoChegada;
	private String DataIda;
	private String DataVolta;
	private float Valor;
	private int Id_usuario;
	private Usuario usuario;
	private int Id_destino;
	private Destino destino;
	public int getId_viagem() {
		return Id_viagem;
	}
	public void setId_viagem(int id_viagem) {
		Id_viagem = id_viagem;
	}
	public String getAeroportoPartida() {
		return AeroportoPartida;
	}
	public void setAeroportoPartida(String aeroportoPartida) {
		AeroportoPartida = aeroportoPartida;
	}
	public String getAeroportoChegada() {
		return AeroportoChegada;
	}
	public void setAeroportoChegada(String aeroportoChegada) {
		AeroportoChegada = aeroportoChegada;
	}
	public String getDataIda() {
		return DataIda;
	}
	public void setDataIda(String dataIda) {
		DataIda = dataIda;
	}
	public String getDataVolta() {
		return DataVolta;
	}
	public void setDataVolta(String dataVolta) {
		DataVolta = dataVolta;
	}
	public float getValor() {
		return Valor;
	}
	public void setValor(float valor) {
		Valor = valor;
	}
	public int getId_usuario() {
		return Id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		Id_usuario = id_usuario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public int getId_destino() {
		return Id_destino;
	}
	public void setId_destino(int id_destino) {
		Id_destino = id_destino;
	}
	public Destino getDestino() {
		return destino;
	}
	public void setDestino(Destino destino) {
		this.destino = destino;
	} 
	
	
}
