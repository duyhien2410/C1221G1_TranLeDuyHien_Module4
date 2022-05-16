package com.codegym.repository;

import com.codegym.model.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowedBookRepository extends JpaRepository<BorrowedBook, Integer> {
    BorrowedBook findByBorrowedBook(String borrowed);
}
