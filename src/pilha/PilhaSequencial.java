package pilha;

import java.util.Scanner;

public class PilhaSequencial {
	// contador é a variável responsável por controlar a lista e list é o array da lista em sí.
	private final int TAMANHO = 20;
	private int[] pilha = new int[TAMANHO];
	private int contador;
	
	public int getTamanho() {
		if (contador == 0) {
			System.out.println("A pilha está vazia.");
		}
		return contador;
	}
	
	public int getTopo() {
		return pilha[contador-1];
	}
	
	public void push(int valor) {
		contador++;
		pilha[contador-1] = valor;
		
	}
	
	public int pop() {
		if (contador == 0) {
			return 0;
		}
		pilha[contador-1] = 0;
		contador--;
		return pilha[contador-1];
	}
	
	public void visualisarPilha() {

		if (contador == 0) {
			System.out.println("\nA pilha está vazia");
		} else {
			for (int i = 0; i < contador; i++) {
				System.out.println("\nO valor do " + (i + 1) + "º elemento é: " + pilha[i]);
			}

		}

	}
	
	public void esvaziarPilha() {

		if (contador == 0) {
			System.out.println("\nA pilha está vazia");
		} else {
			for (int i = 0; i < contador; i++) {
				pilha[1] = 0;
			}
		
			contador = 0;
		}

	}
	
	public void menuPilhaSequencial(Scanner scr) {
		int valor = 0, opcaoMenu;
		boolean loop = true;
		
		PilhaSequencial pilha = new PilhaSequencial();
		
		while (loop) {
			try {
				System.out.println("\nDigite a operação que deseja realizar:"
						+ "\n1 - Obter tamanho da Pilha" + "\n2 - Obter o valor do topo da Pilha" 
						+ "\n3 - Adicionar um elemento no topo da Pilha"
						+ "\n4 - Remover um elemento do topo da Pilha" + "\n5 - Mostrar todos os elementos da Pilha"
						+ "\n6 - Esvaziar todos os elementos da Pilha" + "\n7 - Sair do menu da pilha encadeada");
				opcaoMenu = scr.nextInt();

				switch (opcaoMenu) {
				case 1:
					System.out.println("Tamanho da lista: " + pilha.getTamanho());
					break;
				case 2:
					System.out.println("\nO valor do topo da pilha é "
							+ pilha.getTopo());
					break;
				case 3:
					System.out.println("Digite o valor do elemento que será adicionado: ");
					valor = scr.nextInt();
					pilha.push(valor);
					break;
				case 4:
					int auxiliar = pilha.pop();
					if (auxiliar != 0) {
						System.out.println("Elemento do topo removido com sucesso.");
					} else {
						System.out.println("A pilha está vazia!");
					}
					break;
				case 5:
					pilha.visualisarPilha();
					break;
				case 6:
					pilha.esvaziarPilha();
					System.out.println("A lista foi esvaziada.");
					break;
				case 7:
					System.out.println("Saindo do menu da pilha encadeada");
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
	}
}
