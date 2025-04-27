
package projetoAp;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class EscritaCSV {

	public static void escrever(String Linha) {
		try{

			OutputStream arquivo = new FileOutputStream(GerenciarArquivos.CaminhoCompleto(), true);
			OutputStreamWriter arquivoEscrito = new OutputStreamWriter(arquivo, StandardCharsets.UTF_8);
			PrintWriter escreve = new PrintWriter(arquivoEscrito, true);

			escreve.println(Linha);

		}catch(IOException erro) {
			erro.printStackTrace();
		}
	}

	public static void escreveCsvAluno(Aluno a) {
		String aluno = a.getId() + ";" + a.getNome();
		escrever(aluno);
	}

	public static void escreveCsvCurso(Curso c) {
		try {
			String curso = c.getNome() + ";" + c.getNivel() + ";" + c.getAno();
			escrever(curso);
			OutputStream arquivo = new FileOutputStream(GerenciarArquivos.CriarArquivoNota(c.getNome(), c.getNivel(), c.getAno()), true);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void escreveNota(Nota n) {
		try {
			String caminho = GerenciarArquivos.CaminhoCompleto();

			File arquivo = new File(caminho);

			if (arquivo.exists()) {
				String nota = n.getIdAluno() + ";" + n.getNp1() + ";" + n.getNp2() + ";" + (n.getReposicao() != -1 ? n.getReposicao() : 0) + ";" + (n.getExame() != -1 ? n.getExame() : 0);
				escrever(nota);	
			}
			

		} catch (Exception e) {
			System.out.println("Erro ao tentar acessar ou escrever no arquivo: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

	
   
	/*public static void escreveCsvAluno(Aluno a) {
		try{

			OutputStream arquivo = new FileOutputStream(GerenciarArquivos.CaminhoCompleto(), true);
			OutputStreamWriter arquivoEscrito = new OutputStreamWriter(arquivo, StandardCharsets.UTF_8);
			PrintWriter escreve = new PrintWriter(arquivoEscrito, true);

			escreve.println(a.getId() + ";" + a.getNome());

		}catch(IOException erro) {
			erro.printStackTrace();
		}
		
	}
	
	public static void escreveCsvCurso(Curso c) {
		try{	

			OutputStream arquivo = new FileOutputStream(GerenciarArquivos.CaminhoCompleto(), true);
			OutputStreamWriter arquivoEscrito = new OutputStreamWriter(arquivo, StandardCharsets.UTF_8);
			PrintWriter escreve = new PrintWriter(arquivoEscrito, true);
			
			escreve.println(c.getNome() + ";" + c.getNivel() + ";" + c.getAno());

		} catch(IOException erro) {
			erro.printStackTrace();
		}
		
	}*/
}
