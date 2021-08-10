package br.com.generation;

import java.util.Scanner;
import java.lang.Math;
public class Cliente {
	
	Scanner entrada = new Scanner(System.in);
	
	private String nome;
	private String sobrenome;
	private String cpf;
	private String senha;
	private double saldo;
	private double renda;
	
	
	
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
			saldo = saldo + valorSolicitado;
			System.out.println("Emprestimo concedido com sucesso!!! Valor a pagar: R$" + Math.round(valorSolicitado*taxaGen)+ ",00");
			System.out.println("Voce tem ate 2023 para nao ir pro serada rs");
			}
		}	
	}
	
	
	public void depositar(double saldo) {
		double valorDeposito=0;
		System.out.println("Digite o valor do deposito: ");
		valorDeposito = entrada.nextDouble();
		saldo = saldo + valorDeposito;
		System.out.println("Deposito realizado!");
		System.out.println(saldo);
	}
	
	
	
	
	
	public void mostraSaldo() {
		System.out.println("Seu saldo eh : " + saldo);
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
				saldo = saldo - valorSaque;
			    System.out.println("Saque concluido!");
			    System.out.println("Saldo atualizado: " + saldo);
			    }else{
			      System.out.println("Operacao cancelada.");
			      }
		}
	
	
	
	public static void login(String cpf, String senha, String cpfDigitado, String senhaDigitada) {
		//System.out.println(senhaDigitada);
	
		if(cpfDigitado.equals(cpf) || senhaDigitada.equals(senha)) {
			 System.out.println("Cpf e senhas corretos iniciando menu principal...");
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
}