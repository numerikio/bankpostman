package ua.elma.clientbank.service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.stereotype.Service;
import ua.elma.clientbank.model.RaiffeisenBankRecords;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class RaiffeisenBankRecordsProvider implements BankRecordsProvider {
    String file = "/home/user/BP/export.csv";
    String charsetName = "Windows-1251";
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
                    .withSkipLines(1)
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

    private List<RaiffeisenBankRecords> addBankRecords(List<String[]> list) {
        for (String[] strings : list
        ) {
            RaiffeisenBankRecords bankRec = new RaiffeisenBankRecords();
            for (int i = 0; i < strings.length; i++) {

                bankRec.setLegalPersonID(strings[0]);
                bankRec.setMFO(Integer.valueOf(strings[1]));
                bankRec.setAccount(Long.valueOf(strings[2]));
                bankRec.setCurrency(strings[3]);
                //    bankRec.setDateOfOperation(new LocalDateTime(strings[4]));    <----------------- to do like service
                bankRec.setCode(strings[5]);
                bankRec.setBankMFO(Integer.valueOf(strings[6]));
                bankRec.setBankName(strings[7]);
                bankRec.setCorrespondentAccount(strings[8]);
                bankRec.setCorrespondentLegalPersonID(Long.valueOf(strings[9]));
                bankRec.setCorrespondentName(strings[10]);
                bankRec.setDocument(strings[11]);
                //    bankRec.setDocumentDate(new LocalDate(strings[12]));          <----------------- to do like service
                //    bankRec.setDebit(Double.valueOf(strings[13]));
                //    bankRec.setCredit(Double.valueOf(strings[14]));
                bankRec.setPurposeOfPayment(strings[15]);
                bankRec.setSum(Double.valueOf(strings[16]));
            }
            bankRecords.add((RaiffeisenBankRecords) bankRec);
        }
        return bankRecords;
    }
}
