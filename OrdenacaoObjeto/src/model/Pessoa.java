package model;

import java.io.*;
import model.Arquivo;

public class Pessoa {
	private String nome;
	private int idade;
	private String sobrenome;
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public void setSobreNome(String sobrenome){
		this.sobrenome = sobrenome;
	}
	
	public String getNome(){
		return this.nome;
	}
	public int getIdade(){
		return this.idade;
	}
	
	public String getSobreNome(){
		return this.sobrenome;
	}
	
	@Override
	public String toString(){
		return this.nome + " " + this.sobrenome + "\t" + this.idade;
	}
	
	public static Pessoa[] carregar() throws IOException {
		Arquivo arquivo = new Arquivo("data\\pessoas.csv");
		String[] valores;
		String[] linhas = arquivo.linhas();
		Pessoa[] pessoas = new Pessoa[ linhas.length];
		
		for(int i = 0; i < linhas.length; i++){
			valores = linhas[i].split(";");
			pessoas[i] = new Pessoa();
			pessoas[i].setNome(valores[0]);
			pessoas[i].setSobreNome(valores[1]);
			pessoas[i].setIdade(Integer.parseInt(valores[2]));		
		}
		return pessoas;
	}
}