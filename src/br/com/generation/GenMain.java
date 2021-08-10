package br.com.generation;

import java.util.Scanner;

public class GenMain extends Cliente{
	public static void main(String[] args) {
		
		int verifica;
		String cpfDigitado = " ";
		String senhaDigitada = " ";
		
		
		Scanner entrada = new Scanner(System.in);
		Cliente cliente1 = new Cliente();
		
		cliente1.setNome("Gabriel");
		cliente1.setSobrenome("Trummer");
		cliente1.setSenha("12345");
		cliente1.setCpf("123");
		cliente1.setSaldo(0.99);
		cliente1.setRenda(60000);
		cliente1.setValorInvestido(0.0);

		System.out.println("Digite seu cpf");
		cpfDigitado = entrada.next();
	    System.out.println("Digite sua senha");
		senhaDigitada = entrada.next();
		login(cpfDigitado, senhaDigitada, cliente1.getCpf(), cliente1.getSenha());
		menu(cliente1);
		entrada.close();
		
	}

}
