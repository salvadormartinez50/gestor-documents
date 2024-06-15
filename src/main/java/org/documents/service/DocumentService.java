package org.documents.service;

import org.documents.dtos.GenericAnswer;

import java.io.InputStream;

public interface DocumentService {
    GenericAnswer fileUpLoad(InputStream file, String cve);

}
