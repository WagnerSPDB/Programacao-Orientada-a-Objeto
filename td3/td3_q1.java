﻿package td3;
import java.util.Scanner;
public class App{
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		int n;
		float soma = 0;
		System.out.print("Digite quantas contas que deseja armazenar: ");
	    n = scan.nextInt();
	    ContaLuz[] vet = new ContaLuz[n];
	    
	    for(int i = 0; i < vet.length; i++){
	    	vet[i] = new ContaLuz();
	    	vet[i].codigo = i+1;
	    	System.out.println("\n---------- CONTA NOVA ----------\n");
	    	System.out.println("Digite a data de leitura da conta: formato <dd mm aaaa>: ");
	    	vet[i].diaLeitura = scan.nextInt();
	    	vet[i].mesLeitura = scan.nextInt();
	    	vet[i].anoLeitura = scan.nextInt();
	    	System.out.println("Digite a data de vencimento da conta: formato <dd mm aaaa>: ");
	    	vet[i].diaVencimento = scan.nextInt();
	    	vet[i].mesVencimento = scan.nextInt();
	    	vet[i].anoVencimento = scan.nextInt();
	    	System.out.println("Digite a quantidade de KW consumido no mes: ");
	    	vet[i].kwMes = scan.nextFloat();
	    	soma += vet[i].kwMes;
	    	System.out.println("Digite o valor a ser pago:");
	    	vet[i].valor = scan.nextFloat();
	    	System.out.println("Digite 1 se a conta estiver paga.");
	    	vet[i].situacao = scan.nextInt();
	    	if(vet[i].situacao == 1) {
	    		System.out.println("Digite a data de pagamento da conta: formato <dd mm aaaa>: ");
	    		vet[i].diaPagamento = scan.nextInt();
	    		vet[i].mesPagamento = scan.nextInt();
	    		vet[i].anoPagamento = scan.nextInt();
	    	}
	    }
	    System.out.println("----------Contas Cadastradas----------");
	    for(int i = 0; i < vet.length; i++) {
	    	vet[i].imprimir();	
	    }
	    System.out.println("\n----------SITUAÇÃO----------\n");
	    for(int i = 0; i < vet.length; i++) {
	    	vet[i].verificaPaga(i+1);
	    }
	    System.out.println("\nA média de consumo das contas é: "+vet[n-1].mediaConta(n, soma));
	    vet[0].maiorMenor(n, vet);
	}
}






package td3;

public class ContaLuz {
	int codigo, diaLeitura, mesLeitura, anoLeitura, diaVencimento, mesVencimento, anoVencimento, diaPagamento, mesPagamento, anoPagamento, situacao = 0;
	float kwMes, valor;
	
	public ContaLuz() {
	}
	
	void imprimir() {
		System.out.println("\nCódigo: "+this.codigo);
		System.out.println("Data de Leitura: "+this.diaLeitura+"/"+this.mesLeitura+"/"+this.anoLeitura);
		System.out.println("Data de Vencimento: "+this.diaVencimento+"/"+this.mesVencimento+"/"+this.anoVencimento);
		System.out.println("Consumo mensal em KW: "+this.kwMes);
		System.out.println("Total a pagar: R$"+this.valor);
		System.out.println("Data de Pagamento: "+this.diaPagamento+"/"+this.mesPagamento+"/"+this.anoPagamento);
		if(situacao == 1) {
			System.out.println("A conta já foi paga.");
		} else {
			System.out.println("A conta não foi paga.");
		}
	}
	
	void maiorMenor(int n, ContaLuz vet[]) {
		float maiorC = 0;
		float menorC = 9999;
		int maiorMes = 0;
		int menorMes = 0;
		float[] auxC = new float[n];
		int[] auxM = new int[n];
	    for(int i = 0; i < n; i++){
	    	auxC[i] = vet[i].kwMes;
	    	auxM[i] = vet[i].mesLeitura;
	    }
	    for(int i = 0; i < n; i++) {
	    	if(auxC[i] > maiorC) {
	    		maiorC = auxC[i];
	    		maiorMes = auxM[i];
	    	}
	    	if(auxC[i] < menorC) {
	    		menorC = auxC[i];
	    		menorMes = auxM[i];
	    	}
	    }
	        
	    System.out.println("O maior consumo é de "+maiorC+ " da conta do mês "+maiorMes);
	    System.out.println("O menor consumo é de "+menorC+ " da conta do mês "+menorMes);
	}
	
	float mediaConta(int n, float soma) {
		float media = 0;
		media = soma/n;
		return media;
	}
	
	void verificaPaga(int i) {
		if(this.situacao != 1) {
			System.out.println("Conta "+this.codigo+" não foi paga.");
		}else if(this.situacao == 1) {
			if(this.anoPagamento > this.anoVencimento) {
				System.out.println("A conta "+i+" foi paga após o vencimento.");
			}else if(this.mesPagamento > this.mesVencimento) {
				System.out.println("A conta "+i+" foi paga após o vencimento.");
			}else if(this.diaPagamento > this.diaVencimento) {
				System.out.println("A conta "+i+" foi paga após o vencimento.");
			}else {
				System.out.println("A conta "+i+" foi paga antes do vencimento!");
			}
		}
	}
}
