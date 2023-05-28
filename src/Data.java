// Imports
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Data {
	
	// Carrega o conteúdo do arquivo texto passado no parâmetro filename e retorna uma String com o conteúdo do arquivo
    public static String loadTextFileToString(String filename) throws FileNotFoundException, IOException {

        InputStream is = new FileInputStream(filename); // Abre o arquivo texto para leitura
        InputStreamReader isr = new InputStreamReader(is); // Cria um InputStreamReader para ler o InputStream
        BufferedReader br = new BufferedReader(isr); // Cria um BufferedReader para ler o InputStreamReader

        StringBuilder sb = new StringBuilder(); // Cria um StringBuilder para concatenar o conteúdo do arquivo texto

        // Enquanto houver linhas no arquivo texto, lê uma linha e concatena no StringBuilder
		while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            sb.append(line).append('\n');
        }
		
		is.close(); // Fecha o InputStream
		
        return sb.toString(); // Retorna o conteúdo do arquivo texto
        
    }

    // Salva o conteúdo passado no parâmetro contents no arquivo texto passado no parâmetro filename
    public static void saveStringToTextFile(String filename, String contents) throws FileNotFoundException, IOException {

        OutputStream os = new FileOutputStream(filename); // Abre o arquivo texto para escrita
        OutputStreamWriter osw = new OutputStreamWriter(os); // Cria um OutputStreamWriter para escrever no OutputStream
        BufferedWriter bw = new BufferedWriter(osw); // Cria um BufferedWriter para escrever no OutputStream

        bw.write(contents); // Escreve o conteúdo no arquivo texto
        bw.flush(); // Força a escrita do conteúdo no arquivo texto
        
        os.close(); // Fecha o OutputStream

    }

}
