package projetoAp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class LeituraCSV {

    
    public static <T> List<T> lerCSV(Function<String[], T> conversor) throws FileNotFoundException {
        List<T> lista = new ArrayList<>();

        try (
            InputStream arquivo = new FileInputStream(GerenciarArquivos.CaminhoCompleto());
            InputStreamReader lerArquivo = new InputStreamReader(arquivo, StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(lerArquivo)
        ) {
            String linha;
            while ((linha = buffer.readLine()) != null) {
                String[] partes = linha.split(";"); 
                T objeto = conversor.apply(partes); 
                lista.add(objeto);
            }
        } catch (IOException erro) {
            throw new RuntimeException("Erro ao ler o arquivo: " + erro.getMessage(), erro);
        }

        return lista;
    }

    public static List<Aluno> leCsvAluno() throws FileNotFoundException {
		List<Aluno> alunos = lerCSV(new Function<String[],Aluno>() {
			
			@Override
			public Aluno apply(String[] partes) {
				int id = Integer.parseInt(partes[0]);
				String nome = partes[1];
				System.out.println("Id: " + id + " Nome: " + nome);
				return new Aluno(id, nome);
			}
		});

		return alunos;
    }

    public static List<Curso> leCsvCurso() throws FileNotFoundException  {
		List<Curso> cursos = lerCSV(new Function<String[],Curso>() {

			@Override
			public Curso apply(String[] partes) {
				String nome = partes[0];
				String nivel = partes[1];
				int ano = Integer.parseInt(partes[2]);
				System.out.println("Nome do curso: " + nome + " - Nível: " + nivel + " - Ano: " + ano);
				return new Curso(nome, nivel, ano);
			}

		});

		return cursos;
    }

	public static List<Nota> leCsvNota() {
		List<Nota> notas = new ArrayList<>();
		boolean leituraFeitaComSucesso  = false;
		try {
			notas = lerCSV(new Function<String[],Nota>() {

			@Override
			public Nota apply(String[] partes) {
				int id = Integer.parseInt(partes[0]);
				float np1 = Float.parseFloat(partes[1]);
				float np2 = Float.parseFloat(partes[2]);
				float reposicao = Float.parseFloat(partes[3]);
				float exame = Float.parseFloat(partes[4]);
				System.out.println("Id do aluno: " + id + " - Nota NP1: " + np1 + " - Nota NP2: " + np2 +  " - Nota Reposição: " + reposicao + " - Nota Exame: " + exame);
				return new Nota(id, np1, np2, reposicao, exame);

			}
			});
			leituraFeitaComSucesso  = true;

		} catch (Exception e) {
			if (e instanceof FileNotFoundException) {
				System.out.println("Erro: Arquivo de notas não encontrado.");
			} else {
				System.out.println("Erro ao ler o arquivo de notas: " + e.getMessage());
			}
		}
								
			if (leituraFeitaComSucesso && notas.isEmpty()) {
				System.out.println("Nenhum aluno cursou este curso neste Ano.");
			}

			return notas;
				
		}

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
