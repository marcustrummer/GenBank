package br.com.generation;

import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;
public class Cliente {
	
	Scanner entrada = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("###.##");
	
	private String nome;
	private String sobrenome;
	private String cpf;
	private String senha;
	private double saldo;
	private double renda;
	private double valorInvestido;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	//-----------------------------------------------------------------------------------GETTERS AND SETTERS
	
	public void genInvest(double saldo) {
		double investimento=5.76;
		double valorAInvestir = 0;
		System.out.println("Bem vindo ao Centro de Investimentos Generation");
		System.out.println("Aqui seu saldo rende : " + investimento + "% do CDI ao ano!!!");
		System.out.println("Quanto gostaria de investir?");
		valorAInvestir = entrada.nextDouble();
		if(valorAInvestir > saldo) {
			System.out.println("Valor acima do seu saldo...Operacao nao realizada!");
		}else {
			this.saldo = saldo - valorAInvestir;
			valorInvestido = valorAInvestir;
			System.out.println("Obrigado por investir conosco! :) ");
			System.out.println("Seu dinheiro valera: R$ " + df.format((valorInvestido*5.75)) + " em agosto de 2022  (melhor que a nubank hein rs)");
		}
		
		
	}
	
	
	
	public void emprestimo(double renda) {
		double emprestimoDisponivel =0;
		emprestimoDisponivel = renda * 0.6;
		
		double taxaGen = 1.1788;
		double valorSolicitado=0;
		String resposta = "";
		
		
		System.out.println("Voce deseja realizar um emprestimo?  s/n");
		resposta = entrada.next();
		
		
		if(resposta.equals("s")) {
			System.out.println("Nos disponibilizamos um emprestimo de ate: " + emprestimoDisponivel);
			System.out.println("Nos cobramos uma taxa risoria de apenas: " + (taxaGen+16.7012) + "% para emprestimo pessoa fisica\n");
			System.out.println("Digite o valor que deseja realizar: ");
			valorSolicitado = entrada.nextDouble();
			if(valorSolicitado > emprestimoDisponivel) {
				System.out.println("Valor acima do limite disponivel");
				
			}else{
			emprestimoDisponivel = emprestimoDisponivel - valorSolicitado;
			this.saldo = saldo + valorSolicitado;
			System.out.println("Emprestimo concedido com sucesso!!! Valor a pagar: R$" + Math.round(valorSolicitado*taxaGen)+ ",00");
			System.out.println("Voce tem ate 2023 para nao ir pro serada rs");
			}
		}	
	}
	
	
	public void depositar(double saldo) {
		double valorDeposito=0;
		System.out.println("Digite o valor do deposito: ");
		valorDeposito = entrada.nextDouble();
		this.saldo = saldo + valorDeposito;
		System.out.println("Deposito realizado!");
	}
	
	
	
	
	
	public void mostraSaldo() {
		System.out.println("Seu saldo eh : " + df.format(saldo));
	}
	
	public void sacar(double saldo) {
		double valorSaque;         // DECLARAO DE VARIAVEIS
		String verifica = "";
		
		
		System.out.println("Digite o valor do saque: ");
		valorSaque = entrada.nextDouble();
		System.out.println("Confirma valor do saque: " + valorSaque);
		System.out.println("s/n");
		verifica = entrada.next();
		
		if(saldo < valorSaque) {
			System.out.println("Saque nao autorizado!! Tas liso ?");
		}else if(verifica.equals("s")) {
				this.saldo = saldo - valorSaque;
			    System.out.println("Saque concluido!");
			    System.out.println("Saldo atualizado: " + this.saldo);
			    }else{
			      System.out.println("Operacao cancelada.");
			      }
		}
	public static void menu(Cliente cliente1) {
		Scanner entrada = new Scanner(System.in);
		int verifica =0;
		do{
			System.out.println("Digite a opcao desejada");
			System.out.println("1 --> Saque");
			System.out.println("2 --> Saldo");
			System.out.println("3 --> Deposito");
			System.out.println("4 --> Emprestimo");
			System.out.println("5 --> GenInvest");
			verifica = entrada.nextInt();
			System.out.println();
			
			switch(verifica) {
			case 1:
				cliente1.sacar(cliente1.getSaldo());
				break;
			case 2:
				cliente1.mostraSaldo();
			    break;
			case 3: 
				cliente1.depositar(cliente1.getSaldo());
		  	    break;
			case 4:
				cliente1.emprestimo(cliente1.getRenda());
				break;
			case 5:
				cliente1.genInvest(cliente1.getSaldo());
			default:
	            System.out.println("Opcao invalida ");         // REVISAR ESSA OPCAO AQUI
	            break;
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(int i=0;i<60;i++) {System.out.println(" ");}
			}while(verifica != 0);
		entrada.close();
	}
	
	
	
	
	public static void login(String cpf, String senha, String cpfDigitado, String senhaDigitada) {
	
		if(cpfDigitado.equals(cpf) || senhaDigitada.equals(senha)) {
			 System.out.println("Cpf e senhas corretos iniciando Menu principal...");
		}
		else {
			System.out.println("cpf ou senha invalida");
		}
	}
	public double getRenda() {
		return renda;
	}
	public void setRenda(double renda) {
		this.renda = renda;
	}
	public double getValorInvestido() {
		return valorInvestido;
	}
	public void setValorInvestido(double valorInvestido) {
		this.valorInvestido = valorInvestido;
	}
}