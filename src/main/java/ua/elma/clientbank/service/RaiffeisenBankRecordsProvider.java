package ua.elma.clientbank.service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.stereotype.Service;
import ua.elma.clientbank.model.RaiffeisenBankRecords;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RaiffeisenBankRecordsProvider implements BankRecordsProvider {
    private String dir = "/home/user/BP/";
    private String charsetName = "Windows-1251";
    private char separator = ';';
    private String extension = ".csv";
    private List<RaiffeisenBankRecords> bankRecords = new ArrayList<>();

    public RaiffeisenBankRecordsProvider() {
    }

    private String getListFileNames(String extension) {
        List<String> list = new ArrayList<>();
        File direct = new File(dir);
        if (direct.isDirectory()) {
            for (File item : direct.listFiles()) {
                if (item.getName().endsWith(extension)) {
                    list.add(item.getName());
                }
            }
        }
        for (String f : list) {
            System.out.println(f);
        }
        return list.get(0);
    }

    private void fileRename(String _file) {
        File file = new File(_file);
        String pref = "";
        String sux = "";
        int pos = file.getName().lastIndexOf(".");
        if (pos > 0) {
            pref = file.getName().substring(0, pos);
            System.out.println(pref);
            sux = file.getName().substring(pos);
            System.out.println(sux);
        }
        if (!file.getName().contains("_ttt_")) {
            System.out.println(pref + "_ttt_" + LocalDate.now() + sux);
            file.renameTo(new File(dir + pref + "_ttt_" + LocalDate.now() + sux));
            System.out.println(file.getName());
        }
    }

    @Override
    public List<RaiffeisenBankRecords> getBRlist() {
        String file = dir + getListFileNames(extension);
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(
                                new File(file)), charsetName))) {  //<---- to DO
            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(separator)
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
        }finally {
            fileRename(file);
        }
        return null;
    }

    private List<RaiffeisenBankRecords> addBankRecords(List<String[]> list) {
        for (String[] strings : list) {
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
                bankRec.setSum(Double.valueOf(strings[strings.length - 1]));
            }
            bankRecords.add((RaiffeisenBankRecords) bankRec);
        }
        return bankRecords;
    }
}
