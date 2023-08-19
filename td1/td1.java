package java;

import java.util.Scanner;
public class td1 {  
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int n;
    System.out.println("Digite a quantidade de botas: ");
    n = scan.nextInt();
    int vetM[] = new int[n];
    String vetL[] = new String[n];
    if (n < 2 || n > 10000 || n%2 != 0){
      System.out.println("Número de botas ímpar, tente novamente!");
      System.exit(0);
    }else{
      for(int i = 0; i < n; i++){
        System.out.println("\nDigite o tamanho da bota: ");
        vetM[i] = scan.nextInt();
        if(vetM[i] < 30 || vetM[i] > 60){
          System.out.println("Tamanho inválido, tente novamente!");
          System.exit(0);
        }
        System.out.println("Digite 'E' para esquerdo e 'D' para direito: ");
        vetL[i] = scan.next();
        if(vetL[i].compareTo("D") != 0 && vetL[i].compareTo("E") != 0){
          System.out.println("Alguma condição não foi atendida, tente novamente!");
          System.exit(0);
        }
      }
        int cont = 0;
        for(int i = 0; i < n; i++){
          for(int j = i+1; j < n; j++){
            if(vetM[i] == vetM[j]){
              if(vetL[i].compareTo("D") == 0 && vetL[j].compareTo("E") == 0 || vetL[i].compareTo("E") == 0 && vetL[j].compareTo("D") == 0){
                        cont++;
              }
            }
          }
        }
      System.out.println("\nO número de pares é: "+cont);
      }
    }
  } 