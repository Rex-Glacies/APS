
package projetoAp;


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
		String curso = c.getNome() + ";" + c.getNivel() + ";" + c.getAno();
		escrever(curso);
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
