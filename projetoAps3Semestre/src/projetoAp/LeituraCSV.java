package projetoAp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class LeituraCSV {

    // Método genérico para ler o arquivo CSV e retornar uma lista de objetos
    public static <T> List<T> lerCSV(Function<String[], T> conversor) {
        List<T> lista = new ArrayList<>();  // Lista para armazenar os objetos

        try (
            InputStream arquivo = new FileInputStream(GerenciarArquivos.CaminhoCompleto());
            InputStreamReader lerArquivo = new InputStreamReader(arquivo, StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(lerArquivo)
        ) {
            String linha;
            while ((linha = buffer.readLine()) != null) {  // Lê linha por linha do arquivo
                String[] partes = linha.split(";");  // Divide a linha pelo delimitador ";"
                T objeto = conversor.apply(partes);  // Converte a linha em um objeto do tipo T
                lista.add(objeto);  // Adiciona o objeto à lista
            }
        } catch (IOException erro) {
            erro.printStackTrace();  // Em caso de erro, imprime a pilha de exceções
        }

        return lista;  // Retorna a lista de objetos
    }

    public static List<Aluno> leCsvAluno() {
		return lerCSV(new Function<String[],Aluno>() {
			
			@Override
			public Aluno apply(String[] partes) {
				int id = Integer.parseInt(partes[0]);
				String nome = partes[1];
				System.out.println("Id: " + id + " Nome: " + nome);
				return new Aluno(id, nome);
			}
		});
    }

    public static List<Curso> leCsvCurso() {
		return lerCSV(new Function<String[],Curso>() {

			@Override
			public Curso apply(String[] partes) {
				String nome = partes[0];
				String nivel = partes[1];
				int ano = Integer.parseInt(partes[2]);
				System.out.println("Nome do curso: " + nome + " - Nível: " + nivel + " - Ano: " + ano);
				return new Curso(nome, nivel, ano);
			}

		});
    }




	/*public static List<Aluno> leCsvAluno() {//Local onde vai o endereço do arquivo, barras do endereço devem ser / ao inves de \
		
		List<Aluno> alunos = new ArrayList<>();
		try ( 	InputStream arquivo = new FileInputStream(GerenciarArquivos.CaminhoCompleto());
				InputStreamReader lerArquivo = new InputStreamReader(arquivo, StandardCharsets.UTF_8);
				BufferedReader buffer = new BufferedReader(lerArquivo);
				){
			String linha;
			while((linha = buffer.readLine())!= null) {
				
				String[] palavras = linha.split(";");

				
				int id = Integer.parseInt(palavras[0]);
				String nome = palavras[1];

                System.out.println("Id: " +  id + " Nome: " + nome);
				
				Aluno aluno = new Aluno(id,nome);
				alunos.add(aluno);
						
			}
		}catch(IOException erro) {
			erro.printStackTrace();
		}
		return alunos;
	}
	
	public static List<Curso> leCsvCurso() {//Local onde vai o endereço do arquivo, barras do endereço devem ser / ao inves de \
		
		List<Curso> cursos = new ArrayList<>();
		try ( 	InputStream arquivo = new FileInputStream(GerenciarArquivos.CaminhoCompleto());
				InputStreamReader lerArquivo = new InputStreamReader(arquivo, StandardCharsets.UTF_8);
				BufferedReader buffer = new BufferedReader(lerArquivo);
				){
			String linha;
			while((linha = buffer.readLine())!= null) {
				String[] palavras = linha.split(";");
				
				String nome = palavras[0];
				String nivel = palavras[1];
				int ano = Integer.parseInt(palavras[2]);

                System.out.println("Nome do curso: " + nome + " - Nível: " + nivel +  " - Ano: " + ano);
				
				Curso curso1 = new Curso(nome, nivel, ano);
				cursos.add(curso1);

			}
		}catch(IOException erro) {
			erro.printStackTrace();
		}
		return cursos;
	}*/
}