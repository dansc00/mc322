package com.unicamp.mc322.lab04.VacinaCovid;

import java.util.ArrayList;

import com.unicamp.mc322.lab04.Data.Data;
import com.unicamp.mc322.lab04.Posicao.Posicao;

public class VacinaCovid {

	private ArrayList<Usuario> usuarios; // lista de usuários
	private ArrayList<Posto> postos; // lista de postos de sáude
	private int idadeAtendida; // idade atendida no sistema

	public VacinaCovid() {
				
		this.postos = new ArrayList();
		this.usuarios = new ArrayList();
		this.idadeAtendida = 0;
	}
	
	public void setIdadeMinimaAtendida(int idade) {
		this.idadeAtendida = idade;
	}
	
	public int getIdadeMinimaAtendida() {
		return this.idadeAtendida;
	}
	
	public void cadastrarUsuario(String nomeUsuario, String cpf, Data data, Posicao enderecoUsuario) {
		
		Usuario u = new Usuario();
		u.nomeUsuario = nomeUsuario;
		u.cpf = cpf;
		u.idade = data.calcularIdade(data.getDiaNasc(), data.getMesNasc(), data.getAnoNasc());
		u.enderecoUsuario = enderecoUsuario;
		
		this.usuarios.add(u);
	}
	
	public void cadastrarPosto(String nomePosto, Posicao enderecoPosto, int maxAtendimento) {
		
		Posto p = new Posto();
		p.nomePosto = nomePosto;
		p.enderecoPosto = enderecoPosto;
		
		for(int i = 0; i < p.MAX_DIAS_ATENDIMENTO; i++) {
			
			p.maxAtendimento[i] = maxAtendimento;
		}
		
		this.postos.add(p);
	}
	
	public Reserva agendar(String cpf, String nomePosto) {
				
		int posUsuario = buscarUsuario(cpf, this.usuarios);
		int posPosto = buscarPosto(nomePosto, this.postos);
		int menorData = buscarMenorDataPossivel(this.postos.get(posPosto));
		Reserva r = new Reserva();
		
		if(posUsuario > 0) {
			
			if(this.usuarios.get(posUsuario).idade >= this.idadeAtendida) {
				
				if(this.usuarios.get(posUsuario).possuiAgendamento == false) {
					
					if(this.postos.get(posPosto).maxAtendimento[menorData] > 0) {
						
						this.usuarios.get(posUsuario).possuiAgendamento = true;
						this.postos.get(posPosto).maxAtendimento[menorData]--;
						
						r.usuarioReservado = this.usuarios.get(posUsuario);
						r.postoReservado = this.postos.get(posPosto);
						r.diaReservado = this.postos.get(posPosto).diasAtendimento[menorData];
						
						imprimirComprovanteAgendamento(r);
					}
					else {
						
						System.out.println("O posto " + nomePosto + " está com todas vagas preenchidas nesse dia."
								+ "Não foi possivel realizar o agendamento.");
					}
					
				}
				else {
				
					System.out.println("Usuário já possui agendamento marcado. Não foi possível realizar o agendamento");
				}
			}
			else {
				
				System.out.println("Usuário fora da idade atual de atendimento" + "(" + this.getIdadeMinimaAtendida()
				+ " anos)." + "Não foi possível realizar o agendamento.");
			}
		}
		else {
			
			System.out.println("Usuário não cadastrado. Não foi possível realizar o agendamento.");
			
		}
		
		return r;
	}
	
	public Reserva agendarPerto(String cpf) {
		
		Posicao dist = new Posicao(0,0);
		Reserva r = new Reserva();
		
		int posUsuario = buscarUsuario(cpf, this.usuarios);
		int posPosto = 0;
		double menorDist = dist.calculaDistancia(this.usuarios.get(posUsuario).enderecoUsuario.getCoordX(), this.postos.get(0).enderecoPosto.getCoordX(), this.usuarios.get(posUsuario).enderecoUsuario.getCoordY(), this.postos.get(0).enderecoPosto.getCoordY());
		double novaDist;
		
		for(int i = 1; i < this.postos.size(); i++) {
			
			novaDist = dist.calculaDistancia(this.usuarios.get(posUsuario).enderecoUsuario.getCoordX(), this.postos.get(i).enderecoPosto.getCoordX(), this.usuarios.get(posUsuario).enderecoUsuario.getCoordY(), this.postos.get(i).enderecoPosto.getCoordY());
			
			if(novaDist < menorDist) {
				
				menorDist = novaDist;
				posPosto = i;
			}			
		}
		
		r = agendar(cpf, this.postos.get(posPosto).nomePosto);
		imprimirComprovanteAgendamento(r);
		return r;
	}
	
	private void imprimirComprovanteAgendamento(Reserva r) {
		
		System.out.println("Agendamento concluido com sucesso!");
		System.out.println("");
		System.out.println("Comprovante de agendamento:");
		System.out.println("");
		System.out.println("CPF: " + r.usuarioReservado.cpf);
		System.out.println("Posto: " + r.postoReservado.nomePosto);
	}
	
	public void mudarDiasAtendimento(int dia1, int dia2, int dia3, String nomePosto) {
		
		int posPosto = buscarPosto(nomePosto, this.postos);
		
		this.postos.get(posPosto).diasAtendimento[0] = dia1;
		this.postos.get(posPosto).diasAtendimento[1] = dia2;
		this.postos.get(posPosto).diasAtendimento[2] = dia3;
	}
	
	public int buscarUsuario(String cpf, ArrayList<Usuario> usuarios) {
		
		int tam = usuarios.size();
		
		for(int i = 0; i < tam; i++) {
			
			if(usuarios.get(i).cpf.equals(cpf)) {
				
				return i;
			}
		}
		
		return 0;
	}
	
	public int buscarPosto(String nomePosto, ArrayList<Posto> postos) {
		
		int tam = postos.size();
		
		for(int i = 0; i < tam; i++) {
			
			if(postos.get(i).nomePosto.equals(nomePosto)) {
				
				return i;
			}
		}
		
		return 0;
	}
	
	public int buscarMenorDataPossivel(Posto posto) {
		
		Data d = new Data(0,0,0);
		int menor = posto.diasAtendimento[0] - d.getDiaSemanaAtual();
		int posMenor = 0;
		
		for(int i = 1; i < posto.MAX_DIAS_ATENDIMENTO; i++) {
			
			if(posto.diasAtendimento[i] - d.getDiaSemanaAtual() < menor && posto.maxAtendimento[i] > 0) {
				
				menor = posto.diasAtendimento[i] - d.getDiaSemanaAtual();
				posMenor = i;
			}
		}
		
		return posMenor;
	}
	
	public void imprimirCadastroUsuarios() {
		
		for(int i = 0; i < this.usuarios.size(); i++) {
			
			System.out.println("CADASTRO " + (i+1));
			System.out.println("Nome: " + this.usuarios.get(i).nomeUsuario);
			System.out.println("CPF: " + this.usuarios.get(i).cpf);
			System.out.println("Idade: " + this.usuarios.get(i).idade);
			System.out.println("Endereço: (" + this.usuarios.get(i).enderecoUsuario.getCoordX() + "," + this.usuarios.get(i).enderecoUsuario.getCoordY() + ")");
			System.out.println("Agendamento: " + this.usuarios.get(i).possuiAgendamento);
			System.out.println("");
		}
	}
	
	public void imprimirSituacaoPostos() {
		
		for(int i = 0; i < this.postos.size(); i++) {
		
			System.out.println("POSTO " + (i+1));
			System.out.println("Nome: " + this.postos.get(i).nomePosto);
			System.out.println("Endereço: (" + this.postos.get(i).enderecoPosto.getCoordX() + "," + this.postos.get(i).enderecoPosto.getCoordY() + ")");
			System.out.println("Dias de Atendimento(1 = domingo, 2 = segunda...): ");
			for(int j = 0; j < this.postos.get(i).diasAtendimento.length; j++) {
				
				System.out.println(this.postos.get(i).diasAtendimento[j]);
			}
		}
	}
	
}
