package projetoAp;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class LeituraCSV {
	public static void leCSV(String filePath) { //Local onde vai o endereço do arquivo, barras do endereço devem ser / ao inves de \
		try ( 	InputStream arquivo = new FileInputStream(filePath);
				InputStreamReader lerArquivo = new InputStreamReader(arquivo, StandardCharsets.UTF_8);
				BufferedReader buffer = new BufferedReader(lerArquivo);
				){
			String linha;
			while((linha = buffer.readLine())!= null) {
				String[] palavras = linha.split(",");
				
				for(String p: palavras) {
					System.out.println(p);
				}
						
			}
		}catch(IOException erro) {
			erro.printStackTrace();
		}
	}
}
