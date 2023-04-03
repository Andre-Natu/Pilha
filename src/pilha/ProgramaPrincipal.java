package pilha;

import java.util.Scanner;


@SuppressWarnings("unused")
public class ProgramaPrincipal {

	public static void main(String[] args) {
		int posicaoCelula = 0, valor = 0, opcaoMenu;
		boolean loop = true;

		
		
		Scanner scr = new Scanner(System.in);
		
		while (loop) {
			try {
				System.out.println("\\nDigite a operação que deseja realizar:" 
				+ "\n1 - Ir para o menu da pilha encadeada." 
				+ "\n2 - Ir para o menu da pilha sequencial." + "\n3 - Finalizar o programa.");
				opcaoMenu = scr.nextInt();
				
				switch(opcaoMenu) {
				case 1:
					PilhaEncadeada pilhaEncadeada = new PilhaEncadeada();
					pilhaEncadeada.menuPilhaEncadeada(scr);
					break;
				case 2:
					PilhaSequencial pilhasequencial = new PilhaSequencial();
					pilhasequencial.menuPilhaSequencial(scr);
					break;
				case 3:
					System.out.println("Terminando o programa.");
					loop = false;
					break;
				default:
					System.out.println("Opção inválida.");
				}
			} catch (Exception e) {
				scr.next();
				System.out.println("Opção inválida, voltando para o menu.");
			}
		}
		scr.close();

	}

}
