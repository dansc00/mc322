package com.unicamp.mc322.lab02;

import java.util.Scanner;

public class User {
	
	Scanner input = new Scanner(System.in);
	private String username, cpf, birthDate, gender; // nome, cpf, data de nascimento e gênero do usuário
	public boolean assinature;  // assinante = true, não assinante = false;
	
	public Playlist playlists[]; // vetor de playlists
	public int numPlaylists; // numero maximo de playlists do usuário - numero de playlists atual
	public int maxPlaylists; // número máximo de playlists para o usuário
	
	public User(String username, String cpf, boolean assinature) { // construtor do usuário
		
		username = username;
		cpf = cpf;
		assinature = assinature;
		
		if(this.assinature) {
			
			this.numPlaylists = 10;
			this.maxPlaylists = this.numPlaylists;
			this.playlists = new Playlist[numPlaylists];
		}
		else {
			
			this.numPlaylists = 3;
			this.maxPlaylists = this.numPlaylists;
			this.playlists = new Playlist[numPlaylists];
		}
	}
	
	public void addPlaylist(Playlist playlist) {
		
		if(this.numPlaylists > 0) {
			
			this.playlists[this.maxPlaylists - this.numPlaylists] = playlist;
			this.numPlaylists--;
		}
		else {
			
			System.out.println("Número máximo de playlists atingida!");
		}
	}
	
	public void remPlaylist(Playlist playlist) {
		
		for(int i = 0; i < this.maxPlaylists - this.numPlaylists; i++) {
			
			if(this.playlists[i] == playlist) {
				
				this.playlists[i] = null;
				break;
			}
		}
		
		this.numPlaylists++;
	}
	
	public void transferPlaylist(User x, Playlist playlist) {
		
		x.addPlaylist(playlist);
		this.remPlaylist(playlist);
	}
	
	private void cancelAssinature() {
		
		this.assinature = false;
		
		if(this.maxPlaylists - this.numPlaylists > 3) {
			
			for(int i = this.maxPlaylists - this.numPlaylists; i > 3; i--) {
				
				this.playlists[i] = null;
			}
			
			this.numPlaylists = 0;
		}
		
		this.maxPlaylists = 3;
	}
	
	private void readBirthdate() {
		
		System.out.println("Digite a data de nascimento no formato XX/YY/ZZZZ: ");
		this.birthDate =  input.next();
	}
	
	private String checkAssinature(User x) {
		
		if(x.assinature) {
			return "Sim";
		}
		
		return "Não";
	}
	
	public void showPlaylists() {
		
		System.out.println("User: " + this.username + "\nNumber of Playlists: " + 
		(this.maxPlaylists - this.numPlaylists + "\n"));
		
		for(int i = 0; i < this.maxPlaylists - this.numPlaylists; i++) {
			
			System.out.println("Playlist " + (i+1) + ": " + this.playlists[i].namePlaylist + "\n"
			+ "		Number of songs: " + this.playlists[i].numSongs + 
		}
	}
	
	public void showInformation() {
		
		System.out.println("Nome: " + this.username + 
						   "\nCPF: " + this.cpf + 
						   "\nData de nascimento: " + this.birthDate +
						   "\nGênero: " + this.gender +
						   "\nAssinatura: " + checkAssinature(this));
	}
	
}