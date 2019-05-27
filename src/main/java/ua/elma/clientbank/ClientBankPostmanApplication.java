package ua.elma.clientbank;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientBankPostmanApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ClientBankPostmanApplication.class, args);
BankRecordsProvider provider = new RaiffeisenBankRecordsProvider();


		for (BankRecords records: provider.getBRlist()
			 ) {
			System.out.println(records.getCodeEDRPU());
			System.out.println(records.getX());
		}

	}


}
