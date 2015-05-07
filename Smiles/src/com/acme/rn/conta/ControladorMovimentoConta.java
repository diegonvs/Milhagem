package com.acme.rn.conta;

import com.acme.ado.conta.RepositorioMovimentoConta;

public class ControladorMovimentoConta {
	public static RepositorioMovimentoConta rmc = new RepositorioMovimentoConta();
	public void Inserir(MovimentoConta mc){
		if(mc.equals(null)){
			System.out.println("MovimentoConta Nulo!");
		}else{
			rmc.incluir(mc);
		}
	}
	
	/*public void BuscaporConta(IdentificadorConta ic){
		if(ic.equals(null)){
			System.out.println("Identificador Conta nulo!");
		}else{
			//TODO-
		}
		
	}*/
	
	public ControladorMovimentoConta() {
		// TODO Auto-generated constructor stub
		
	}

}
