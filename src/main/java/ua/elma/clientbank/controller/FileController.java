package ua.elma.clientbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ua.elma.clientbank.model.BankRecords;
import ua.elma.clientbank.model.RaiffeisenBankRecords;
import ua.elma.clientbank.service.BankRecordsProvider;
import ua.elma.clientbank.service.FileStorageService;
import ua.elma.clientbank.service.RaiffesenBankRecordsService;


@RestController
public class FileController {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private BankRecordsProvider bankRecordsProvider;

    @Autowired
    private RaiffesenBankRecordsService raiffesenBankRecordsService;


    @PostMapping("/uploadMultipleFiles")
    public void uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        for (MultipartFile multipartFile : files) {
            fileStorageService.storeFile(multipartFile);
        }
        printtt();
    }

    private void printtt() {

        for (BankRecords records : bankRecordsProvider.getBRlist()
        ) {
            if (raiffesenBankRecordsService.getOne(records.getLegalPersonID(), records.getPurposeOfPayment(), records.getSum())==null)
                raiffesenBankRecordsService.saveBankRecords((RaiffeisenBankRecords) records);
        }

    }
}
