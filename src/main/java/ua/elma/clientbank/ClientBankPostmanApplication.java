package ua.elma.clientbank;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.List;

@SpringBootApplication
public class ClientBankPostmanApplication {
	static String file = "export.csv";
	public static void main(String[] args) {
		SpringApplication.run(ClientBankPostmanApplication.class, args);

		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								new File(file)), "Windows-1251"))){

			CSVParser parser = new CSVParserBuilder()
					.withSeparator(';')
					.withIgnoreQuotations(true)
					.build();

			CSVReader csvReader = new CSVReaderBuilder(reader)
					.withSkipLines(0)
					.withCSVParser(parser)
					.build();

			printList(csvReader.readAll());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static  void  printList(List<String[]> list){
		for (String[] strings: list
		) {
			for (int i = 0; i < strings.length; i++) {
				System.out.print(strings[i]);
				printTab();
			}
			System.out.println();
		}

	}
	static void printTab(){
		System.out.print("\t");
	}

}
