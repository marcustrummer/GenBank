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
		cliente1.setRenda(60000);
		cliente1.setValorInvestido(0.0);

		System.out.println("Digite seu cpf");
		cpfDigitado = entrada.next();
	    System.out.println("Digite sua senha");
		senhaDigitada = entrada.next();
		login(cpfDigitado, senhaDigitada, cliente1.getCpf(), cliente1.getSenha());
		
		do{
			System.out.println("Digite a opcao desejada");
			System.out.println("1 --> Saque");
			System.out.println("2 --> Saldo");
			System.out.println("3 --> Deposito");
			System.out.println("4 --> Emprestimo");
			System.out.println("5 --> GenInvest");
			verifica = entrada.nextInt();
			
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i=0;i<60;i++) {System.out.println(" ");}
			}while(verifica != 0);
		
		
		entrada.close();
		
	}

}
