package org.documents.controller;

import io.quarkus.logging.Log;
import jakarta.ws.rs.Produces;

import jakarta.ws.rs.Consumes;
import org.documents.dtos.GenericAnswer;
import org.documents.service.DocumentService;
import org.jboss.resteasy.reactive.PartFilename;
import org.jboss.resteasy.reactive.PartType;
import jakarta.ws.rs.core.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

@RestController
@RequestMapping("api/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("excelToMysql/{cve}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    public GenericAnswer fileUpload(
            @PartFilename("file") @PartType(MediaType.APPLICATION_OCTET_STREAM) InputStream file,
            @PathVariable String cve) {
        Log.debug("Starting fileUpload to convert to util data from the first column of an excel file");
        GenericAnswer answer = this.documentService.fileUpLoad(file, cve);

        Log.debug("Ending excelToMysql");
        return answer;
    }

}
