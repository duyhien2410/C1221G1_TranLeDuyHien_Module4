package com.codegym.service.impl;

import com.codegym.model.Upload;
import com.codegym.service.IUploadService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UploadService implements IUploadService {

    private static List<Upload> uploadList = new ArrayList<>();

    static {
        uploadList.add(new Upload("Hoa Hải Đường", "Jack 5 triệu", "ballad", "https://www.youtube.com/watch?v=Bhg-Gw953b0"));
        uploadList.add(new Upload("Ai mang cô đơn đi", "K-icm", "pop-ballad", "https://www.youtube.com/watch?v=ilKg0DZrOwY"));
        uploadList.add(new Upload("Hãy trao cho anh", "MTP", "R&B", "https://www.youtube.com/watch?v=knW7-x7Y7RE"));
    }


    @Override
    public List<Upload> list() {
        return uploadList;
    }

    @Override
    public Object create(Upload upload) {
        uploadList.add(upload);
        return null;
    }
}
