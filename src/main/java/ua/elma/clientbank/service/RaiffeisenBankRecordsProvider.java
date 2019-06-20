package ua.elma.clientbank.service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.stereotype.Service;
import ua.elma.clientbank.model.BankRecords;
import ua.elma.clientbank.model.RaiffeisenBankRecords;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class RaiffeisenBankRecordsProvider implements BankRecordsProvider {
    String file = "/home/user/BP/export.csv";
    String charsetName ="Windows-1251";
    List<RaiffeisenBankRecords> bankRecords = new ArrayList<>();

    @Override
    public List<RaiffeisenBankRecords> getBRlist() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(
                                new File(file)), charsetName))) {
            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(';')
                    .withIgnoreQuotations(true)
                    .build();

            CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withSkipLines(0)
                    .withCSVParser(parser)
                    .build();

            return addBankRecords(csvReader.readAll());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       return null;
    }

    private List<RaiffeisenBankRecords> addBankRecords(List<String[]> list){
        for (String[] strings: list
        ) {
            for (int i = 0; i < strings.length; i++) {
                BankRecords bankRec = new RaiffeisenBankRecords();
                bankRec.setCodeEDRPU(strings[0]);
                bankRec.setX(strings[7]);

               bankRecords.add((RaiffeisenBankRecords) bankRec);
            }
        }
        return bankRecords;
    }
}
