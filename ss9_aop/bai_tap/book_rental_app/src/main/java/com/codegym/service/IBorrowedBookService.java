package com.codegym.service;

import com.codegym.model.BorrowedBook;

public interface IBorrowedBookService {
    void save(BorrowedBook borrowedBook);

    BorrowedBook findByBorrowedBook(String borrowed);

    void delete(BorrowedBook borrowedBook);
}
