package pilha;

import java.util.Scanner;

public class PilhaEncadeada {
	
	private int tamanhoPilha;
	private No topoPilha;
	
	public void Pilha(int valor) {
		No novoNo = new No(valor);
		topoPilha = novoNo;
		tamanhoPilha = 1;
	}
	
	public int getTamanho() {
		if (tamanhoPilha == 0) {
			System.out.println("A pilha está vazia.");
		}
		return tamanhoPilha;
	}
	
	// colocar no main getTopo().getValor();
	public No getTopo() {
		return topoPilha;
	}
	
	public void push(int valor) {
		No novoNo = new No(valor);

		novoNo.setProximoNo(topoPilha);
		topoPilha = novoNo;

		tamanhoPilha++;
	}
	
	public No pop() {
		if (tamanhoPilha == 0) {
			return null;
		}
		No auxiliar = topoPilha;
		topoPilha = topoPilha.getProximoNo();
		auxiliar.setProximoNo(null);
		
		tamanhoPilha--;
		return auxiliar;
	}
	
	
	public void visualisarPilha() {

		if (tamanhoPilha == 0) {
			System.out.println("\nA lista está vazia");
		} else {
			No atualNo = this.topoPilha;

			for (int i = 0; i < tamanhoPilha; i++) {
				System.out.println("\nO valor do " + (i + 1) + "º elemento é: " + atualNo.getValor());
				atualNo = atualNo.getProximoNo();
			}

		}

	}
	
	public void esvaziarPilha() {
		No atualCelula = this.topoPilha;
		No auxiliar;

		while (atualCelula != null) {
			auxiliar = atualCelula.getProximoNo();
			atualCelula.setValor(0);
			atualCelula.setProximoNo(null);
			atualCelula = auxiliar;
		}

		tamanhoPilha = 0;
		topoPilha = null;

	}
	
	public void menuPilhaEncadeada(Scanner scr) {
		int valor = 0, opcaoMenu;
		boolean loop = true;
		
		PilhaEncadeada pilha = new PilhaEncadeada();
		
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
							+ pilha.getTopo().getValor());
					break;
				case 3:
					System.out.println("Digite o valor do elemento que será adicionado: ");
					valor = scr.nextInt();
					pilha.push(valor);
					break;
				case 4:
					No auxiliar = pilha.pop();
					if (auxiliar != null) {
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
