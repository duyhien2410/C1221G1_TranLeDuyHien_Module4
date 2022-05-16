package com.codegym.service.impl;

import com.codegym.model.BorrowedBook;
import com.codegym.repository.IBorrowedBookRepository;
import com.codegym.service.IBorrowedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowedBookService implements IBorrowedBookService {
    @Autowired
    IBorrowedBookRepository borrowedBookRepository;

    @Override
    public void save(BorrowedBook borrowedBook) {
        borrowedBookRepository.save(borrowedBook);
    }

    @Override
    public BorrowedBook findByBorrowedBook(String borrowed) {
        return borrowedBookRepository.findByBorrowedBook(borrowed);
    }

    @Override
    public void delete(BorrowedBook borrowedBook) {
        borrowedBookRepository.delete(borrowedBook);
    }
}
