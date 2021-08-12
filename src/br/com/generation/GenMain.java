package br.com.generation;

import java.io.Console;
import java.util.Scanner;

public class GenMain extends Cliente{
	public static void main(String[] args) {
		
		int verifica;
		String cpfDigitado = " ";
		String senhaDigitada = " ";
		String nomeDigitado = " ";
		double valorDepositado = 0;
		double renda= 0;
		int resposta=0;
		
		//Console console = System.console();
		Scanner entrada = new Scanner(System.in);
		Cliente cliente1 = new Cliente();
		

		cliente1.setValorInvestido(0.0);
		
		// ----------------------------CADASTRO INICIAL-------------------------------------------------------------------------
		
		System.out.println("==========================================================");
		System.out.println("||                                                      ||");
		System.out.println("||               Bem vindo a Gen Bank                   ||");
		System.out.println("||               Vamos abrir uma conta?                 ||");
		System.out.println("||         [1-Sim]                   [2-Não]            ||");
		System.out.println("==========================================================");
		resposta = entrada.nextInt();
		if(resposta == 1) {
		System.out.println("Nos informa o seu primeiro nome abaixo: ");
		do {
		nomeDigitado = entrada.nextLine();
		cliente1.setNome(nomeDigitado);
		}while(nomeDigitado.length() < 2); //VERIFICANDO O TAMANHO DO NOME, SE MENOR DO QUE 2 LETRAS DIGITAR NOVAMENTE!! 
		
		do{
		System.out.println("Digite o seu CPF, por favor.");
		cpfDigitado = entrada.nextLine();
		cliente1.setCpf(cpfDigitado);
		}while(cpfDigitado.length() < 11); // VERIFICANDO CPF, SE MENOR DO QUE 11 DIGITOS, DIGITAR NOVAMENTE!!
		
		
		for(int i=0;i<0;i++) {System.out.println("");} //-----------LIMPANDO A TELA DO CONSOLE------------------------------------------------------------

		
		do {
	    System.out.println("Cadastre sua senha");
	    senhaDigitada = entrada.nextLine();
	    cliente1.setSenha(senhaDigitada);
		}while(senhaDigitada.length() < 4); //VERIFICANDO SENHA, SE MENOR DO QUE 4 DIGITOS, DIGITAR NOVAMENTE!!
	    
	    
		System.out.println("Cadastro realizado com sucesso!!!");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<10;i++) {System.out.println("");}
		//----------------------------------------------------------------------------------------------------------------------------------------------
		                              //CONFIRMACAO DA ABERTURA CONTA NO GENBANK
		do {
		System.out.println("============================================================");
		System.out.println("||                                                        ||");
		System.out.println("||         Para efetivar a abertura da sua conta,         ||");
		System.out.println("||         realize seu deposito                           ||");
		System.out.println("||                                                        ||");
		System.out.println("============================================================");
		System.out.println("Valor: ");
		valorDepositado = entrada.nextDouble();
		cliente1.setSaldo(valorDepositado);

		} while( valorDepositado < 0 || valorDepositado > 10000);      // Iae
		for(int i=0; i<30; i++) {System.out.println("");}
		
		System.out.println("Falta pouco...");
		
		
		do {

			System.out.println("Nos informe sua renda anual: ");

		renda = entrada.nextDouble();
		cliente1.setRenda(renda);
		}while(renda < 0);
		
		
		
		
		
		
		login(cliente1.getCpf(), cliente1.getSenha());
		menu(cliente1);
		entrada.close();
		}else {
			System.out.println("Que pena :( Estaremos sempre aqui");
		}
		
	}

}
