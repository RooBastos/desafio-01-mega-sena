package br.com.desafiomegasena;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class DesafioMegaSena {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] numerosEscolhidos = new int[7];

		for (int i = 0; i < 7; i++) {
			boolean repete = true;
			do {
				try {
					System.out.println((i + 1) + "- Digite um número de 0 a 100:");
					numerosEscolhidos[i] = sc.nextInt();
					repete = false;
				} catch (InputMismatchException ime) {
					System.out.println("Você digitou um número não inteiro! Tente novamente.");
					sc.next();
				}
			} while (repete);
		}

		sc.close();

		Random random = new Random();

		int[] numerosSorteados = new int[7];

		for (int i = 0; i < 7; i++) {
			numerosSorteados[i] = random.nextInt(101);
		}

		System.out.println("Números Escolhidos: " + Arrays.toString(numerosEscolhidos));
		System.out.println("Números Sorteados: " + Arrays.toString(numerosSorteados));

		int acertos = 0;

		for (int numeroB : numerosEscolhidos) {
			for (int numeroA : numerosSorteados) {
				if (numeroA == numeroB) {
					acertos++;
					break;
				}
			}
		}

		System.out.printf("Você acertou: %d \n", acertos);

		switch (acertos) {

		case 5:
			System.out.println("Parabéns!! Você ganhou 10 mil reais!");
			break;

		case 6:
			System.out.println("Parabéns!!! Você ganhou 50 mil reais!");
			break;

		case 7:
			System.out.println("Parabéns!!!!! Você ganhou 200 mil reais!");
			break;

		default:
			System.out.println("Infelizmente, você não ganhou nada! Boa sorte da próxima vez!");
			break;
		}

	}

}
