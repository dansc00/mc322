package com.unicamp.mc322.lab04.VacinaCovid;

import com.unicamp.mc322.lab04.Data.Data;
import com.unicamp.mc322.lab04.Posicao.Posicao;

public class Runner {
	
	public static void main(String[] args) {

        VacinaCovid app = new VacinaCovid();
        app.setIdadeMinimaAtendida(60);

        app.cadastrarUsuario("Jose da Silva", "123.456.789-01", 
                              new Data(1960,12,03), new Posicao(10,30));
        app.cadastrarUsuario("Maria Assuncao", "321.654.987-10", 
                              new Data(1999,4,11), new Posicao(-43,101));

        app.cadastrarPosto("SOUSAS", new Posicao(0,20), 5);
        app.cadastrarPosto("BARAO GERALDO", new Posicao(-20,40), 2);
        
        app.mudarDiasAtendimento(2, 3, 5, "SOUSAS");
        
        Reserva r1 = app.agendar("123.456.789-01", "SOUSAS");
        Reserva r2 = app.agendarPerto("321.654.987-10");

        app.imprimirSituacaoPostos();
        app.imprimirCadastroUsuarios();

	}
}
