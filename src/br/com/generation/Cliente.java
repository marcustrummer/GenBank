package br.com.generation;

import java.util.Scanner;

public class Cliente {
	
	Scanner entrada = new Scanner(System.in);
	
	private String nome;
	private String sobrenome;
	private String cpf;
	private String senha;
	private double saldo;
	
	
	
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
		System.out.println(saldo);
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
}