package br.com.generation;

import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;
public class Cliente{
	
	Scanner entrada = new Scanner(System.in);
	static DecimalFormat df = new DecimalFormat("###.##");
	
	private static int saques=0;
	private String nome;
	private String sobrenome;
	private String cpf;
	static String senha;
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
	//-----------------------------------------------------------------------------------GETTERS AND SETTERS ------------------------------------------------------------------
	
	
	public static void menu(Cliente cliente1) {
		Scanner entrada = new Scanner(System.in);
		int verifica =0;
		do{
			System.out.println("============================================================");
			System.out.println("|| Digite a opção desejada:                               ||");
			System.out.println("|| [1] --> Saque                                          ||");
			System.out.println("|| [2] --> Saldo                                          ||");
			System.out.println("|| [3] --> Depósito                                       ||");
			System.out.println("|| [4] --> Empréstimo                                     ||");
			System.out.println("|| [5] --> GenInvest                                      ||");
			System.out.println("============================================================");
			verifica = entrada.nextInt();
			System.out.println();
			
			switch(verifica) {
			case 1:
				if(saques<3) {
				cliente1.sacar(cliente1.getSaldo());
				}else {System.out.println("Limite de saques atingido! Tente novamente amanhã..");
				}
				break;
			case 2:
				cliente1.mostraSaldo(cliente1.getSaldo());
			    break;
			case 3: 
				cliente1.depositar(cliente1.getSaldo());
		  	    break;
			case 4:
				cliente1.emprestimo(cliente1.getRenda());
				break;
			case 5:
				cliente1.genInvest(cliente1.getSaldo());
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
		System.out.println("============================================================");
		System.out.println("||     Obrigado por usar o GenBank, volte sempre! :)      ||");
		System.out.println("============================================================");
		
	}
	
	public void sacar(double saldo) {
		double valorSaque;         // DECLARAO DE VARIAVEIS
		int verifica = 0;
		
		
		System.out.println("Digite o valor do saque: ");
		valorSaque = entrada.nextDouble();
		System.out.println("Confirma valor do saque: " + valorSaque);
		System.out.println("[1-Sim]           [2-Não]");
		verifica = entrada.nextInt();
		
		if(saldo < valorSaque) {
			System.out.println("Saque não autorizado!! Realize um depósito, por favor!");
		}else if(verifica == 1) {
				this.saldo = saldo - valorSaque;
				this.saques = saques+1; 
			    System.out.println("Saque concluído!");
			    System.out.println("Saldo atualizado: " + this.saldo);
			    }else{
			      System.out.println("Operação cancelada.");
			      }
	}
	
	public  void mostraSaldo(double saldo) {
		System.out.println("============================================================");
		System.out.println("||                 Saldo disponível: "+ df.format(saldo) + "                  ||");
		System.out.println("============================================================");
		
	}
	
	public void emprestimo(double renda) {
		double emprestimoDisponivel =0;
		emprestimoDisponivel = renda * 0.6;            // 60 % da renda do cliente
		
		double taxaGen = 1.1788;      //17.88%
		double valorSolicitado=0;
		int resposta = 0;
		
		System.out.println("============================================================");
		System.out.println("||        Você deseja realizar um empréstimo?             ||");
		System.out.println("||         [1-Sim]                   [2-Não]              ||");
		System.out.println("============================================================");
		resposta = entrada.nextInt();
		
		
		if(resposta==1) {
			System.out.println("Disponibilizamos um empréstimo de até: R$ " + emprestimoDisponivel);
			System.out.println("Cobramos uma taxa de: " + (taxaGen+16.7012) + "% para pessoa física\n");
			System.out.println("Digite o valor que deseja: ");
			valorSolicitado = entrada.nextDouble();
			if(valorSolicitado > emprestimoDisponivel) {
				System.out.println("Valor acima do limite disponível.");
				
			}else{
			emprestimoDisponivel = emprestimoDisponivel - valorSolicitado;
			this.saldo = saldo + valorSolicitado;
			System.out.println("Empréstimo concedido com sucesso!!! Valor a pagar: R$" + Math.round(valorSolicitado*taxaGen)+ ",00");
			System.out.println("Data limite de pagamento: 12 de Agosto de 2022" );
			}
		}	
	}
	
	
	
	

	
	
	public void depositar(double saldo) {
		double valorDeposito=0;
		System.out.println("============================================================");
		System.out.println("||              Digite o valor do depósito:               ||");
		System.out.println("============================================================");
		valorDeposito = entrada.nextDouble();
		this.saldo = saldo + valorDeposito;
		System.out.println("Depósito realizado!");
	}
	
	protected void genInvest(double saldo) {
		double investimento=1.0576;    //  5.76% CDI 
		double valorAInvestir = 0;
		System.out.println("============================================================");
		System.out.println("||    Bem vindo ao Centro de Investimentos Generation     ||");
		System.out.println("============================================================");
		System.out.println("\n");
		System.out.println("Aqui seu investimento rende : 5,76 % do CDI ao ano.");
		
		System.out.println("Quanto gostaria de investir?");
		valorAInvestir = entrada.nextDouble();
		if(valorAInvestir > saldo) {
			System.out.println("Valor acima do seu saldo...Operação não realizada!");
		}else {
			this.saldo = saldo - valorAInvestir;
			valorInvestido = valorAInvestir;
			System.out.println("Obrigado por investir conosco! :) ");
			System.out.println("Seu dinheiro vai render: R$ " + df.format((valorAInvestir*investimento)) + " até agosto de 2022");
		}
		
		
	}
	
	
	
	public static void login(String cpf, String senha) {
		Scanner entrada = new Scanner(System.in);
		String cpfDigitado = " ";    // Para o eu esquecido, cpfDigitado e senha NAO EH IGUAL AO CPFDIG E SENHA DO MAIN
		String senhaDigitada = " ";
		int c=0;
		do {

			System.out.println("Digite o seu CPF, por favor.");
			cpfDigitado = entrada.nextLine();
			System.out.println("Digite sua senha , por favor.");
			senhaDigitada = entrada.nextLine();
			if(cpfDigitado.equals(cpf) && senhaDigitada.equals(senha)) {
				 System.out.println("CPF e senhas corretos iniciando funções do banco principal...");
				 c++;
			}else{
				System.out.println("CPF ou senha inválida, tente novamente!!");
				}
			
			
			try {   
				Thread.sleep(2000);// ----------------------TEMPO PARA LEITURA -----------------------------------------------------
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(int i=0;i<60;i++) {System.out.println("");}//---------------------LIMPANDO TELA PARA DIGITAR NOVAMENTE-------------------------------
		}while(c != 1);
		
	}

}