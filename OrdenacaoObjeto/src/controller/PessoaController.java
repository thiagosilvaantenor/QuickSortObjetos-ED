package controller;

import java.io.*;
import model.Pessoa;

public class PessoaController {
	public PessoaController() {
		super();
	}

	public Pessoa[] ordena_nome() throws IOException {
		Pessoa[] pessoas = Pessoa.carregar();

		for (int i = 0; i < pessoas.length; i++) {
			for (int j = 0; j < pessoas.length - 1; j++) {
				if (pessoas[j].getNome().compareTo(pessoas[j + 1].getNome()) > 0) {
					Pessoa aux = pessoas[j];
					pessoas[j] = pessoas[j + 1];
					pessoas[j + 1] = aux;
				}
			}
		}
		return pessoas;
	}

	public Pessoa[] ordena_sobre_nome() throws IOException {
		Pessoa[] pessoas = Pessoa.carregar();

		ordenarQuick(pessoas);
		return pessoas;
	}

	private void ordenarQuick(Pessoa[] array) {
		quick(array, 0, array.length - 1);
	}

	private void quick(Pessoa[] array, int inicio, int fim) {
		if (fim > inicio) {
			int indexPivo = dividir(array, inicio, fim);
			quick(array, inicio, indexPivo - 1);
			quick(array, indexPivo + 1, fim);
		}
	}

	private int dividir(Pessoa[] array, int inicio, int fim) {
		Pessoa pivo = array[inicio];
		int pontDir = fim;
		int pontEsq = (inicio + 1);

		while (pontEsq <= pontDir) {
			while (pontEsq <= pontDir && array[pontEsq].getSobreNome().compareTo(pivo.getSobreNome()) <= 0) {
				pontEsq++;
			}

			while (pontDir >= pontEsq && array[pontDir].getSobreNome().compareTo(pivo.getSobreNome()) > 0) {
				pontDir--;
			}

			if (pontEsq < pontDir) {
				trocar(array, pontDir--, pontEsq++);
			}
		}

		trocar(array, inicio, pontDir);
		return pontDir;
	}

	private void trocar(Pessoa[] array, int i, int j) {

		Pessoa aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
}