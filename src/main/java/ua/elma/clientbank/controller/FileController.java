package ua.elma.clientbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ua.elma.clientbank.model.BankRecords;
import ua.elma.clientbank.service.BankRecordsProvider;
import ua.elma.clientbank.service.RaiffeisenBankRecordsProvider;
import ua.elma.clientbank.payload.UploadFileResponse;
import ua.elma.clientbank.service.FileStorageService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileController {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private BankRecordsProvider bankRecordsProvider;


    /*private void uploadFile(MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
    printtt();
        //return null;// new UploadFileResponse(fileName, fileDownloadUri,
              //  file.getContentType(), file.getSize());
    }*/

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        for (MultipartFile multipartFile:files) {
            fileStorageService.storeFile(multipartFile);
        }
       /* return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());*/
        printtt();
       return null;
    }

    private void printtt(){

        for (BankRecords records: bankRecordsProvider.getBRlist()
        ) {
            System.out.println(records.getEDRPOU());
            System.out.println(records.getX());
        }

    }
}
