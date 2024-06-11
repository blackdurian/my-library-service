package com.libary.my.controller;

import com.libary.my.entity.Borrower;
import com.libary.my.exception.LibraryServiceException;
import com.libary.my.model.BookBorrowRequest;
import com.libary.my.model.BookReturnRequest;
import com.libary.my.model.BorrowerRegistrationRequest;
import com.libary.my.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @ResponseBody
    @PostMapping(value = "borrower", produces = MediaType.APPLICATION_JSON_VALUE)
    public Borrower registerBorrower (@RequestBody BorrowerRegistrationRequest request) throws LibraryServiceException {
        return libraryService.registerBorrower(request);
    }

    @ResponseBody
    @PostMapping(value = "library/borrow", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> borrowBook (@RequestBody BookBorrowRequest request) throws LibraryServiceException {
        libraryService.borrowBook(request);
        return ResponseEntity.ok().build();
    }

    @ResponseBody
    @PostMapping(value = "library/return", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> returnBook (@RequestBody BookReturnRequest request) throws LibraryServiceException {
        libraryService.returnBook(request);
        return ResponseEntity.ok().build();
    }
}
