package br.com.generation;

import java.util.Scanner;

public class GenMain extends Cliente{
	public static void main(String[] args) {
		
		int verifica;
		String cpfDigitado = " ";
		String senhaDigitada = " ";
		
		Cliente cliente1 = new Cliente();
		Scanner entrada = new Scanner(System.in);
		
		
		cliente1.setNome("Gabriel");
		cliente1.setSobrenome("Trummer");
		cliente1.setSenha("12345");
		cliente1.setCpf("123");
		cliente1.setSaldo(0.99);
		

		System.out.println("Digite seu cpf");
		cpfDigitado = entrada.next();
	    System.out.println("Digite sua senha");
		senhaDigitada = entrada.next();
		login(cpfDigitado, senhaDigitada, cliente1.getCpf(), cliente1.getSenha());
		
		System.out.println("Digite a opcao desejada:");
		System.out.println("1 --> Saque");
		System.out.println("2 --> Saldo");
		System.out.println("3 --> Pix");
		verifica = entrada.nextInt();
		while(verifica < 1 || verifica > 3) {
			System.out.println("opcao invalida, digite uma opcao valida");
			System.out.println("1 --> Saque");
			System.out.println("2 --> Saldo");
			System.out.println("3 --> Pix");
				verifica = entrada.nextInt();
			}
		switch(verifica) {
		case 1:
			cliente1.sacar(cliente1.getSaldo());
			break;
		case 2:
			cliente1.mostraSaldo();
		    break;
		//case 3: 
			//cliente1.depositar(cliente1.getSaldo());
		//	break;
		}
		entrada.close();
		
	}

}
