package projetoAp;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class LeituraCSV {
	public static List<Aluno> leCsvAluno(String filePath) {//Local onde vai o endereço do arquivo, barras do endereço devem ser / ao inves de \
		
		List<Aluno> alunos = new ArrayList<>();
		try ( 	InputStream arquivo = new FileInputStream(filePath);
				InputStreamReader lerArquivo = new InputStreamReader(arquivo, StandardCharsets.UTF_8);
				BufferedReader buffer = new BufferedReader(lerArquivo);
				){
			String linha;
			while((linha = buffer.readLine())!= null) {
				
				String[] palavras = linha.split(";");
				for(String p: palavras) {		
					System.out.println(p);
				}
				
				int id = Integer.parseInt(palavras[0]);
				String nome = palavras[1];
				
				Aluno aluno = new Aluno(id,nome);
				alunos.add(aluno);
						
			}
		}catch(IOException erro) {
			erro.printStackTrace();
		}
		return alunos;
	}
	
	public static List<Curso> leCsvCurso(String filePath) {//Local onde vai o endereço do arquivo, barras do endereço devem ser / ao inves de \
		
		List<Curso> cursos = new ArrayList<>();
		try ( 	InputStream arquivo = new FileInputStream(filePath);
				InputStreamReader lerArquivo = new InputStreamReader(arquivo, StandardCharsets.UTF_8);
				BufferedReader buffer = new BufferedReader(lerArquivo);
				){
			String linha;
			while((linha = buffer.readLine())!= null) {
				String[] palavras = linha.split(";");
				
				for(String p: palavras) {
					System.out.println(p);
				}
				
				String nome = palavras[0];
				String nivel = palavras[1];
				int ano = Integer.parseInt(palavras[2]);
				
				Curso curso1 = new Curso(nome, nivel, ano);
				cursos.add(curso1);
				
						
			}
		}catch(IOException erro) {
			erro.printStackTrace();
		}
		return cursos;
	}
}
