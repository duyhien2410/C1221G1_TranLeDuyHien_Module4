package com.codegym.service;

import com.codegym.model.Upload;

import java.util.List;

public interface IUploadService {
    List<Upload> list();

    Object create(Upload upload);
}
