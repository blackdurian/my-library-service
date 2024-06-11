package com.libary.my.service;

import com.libary.my.constant.RecordStatusEnum;
import com.libary.my.entity.Book;
import com.libary.my.entity.Borrower;
import com.libary.my.entity.Record;
import com.libary.my.exception.LibraryServiceException;
import com.libary.my.model.BookBorrowRequest;
import com.libary.my.model.BookReturnRequest;
import com.libary.my.model.BorrowerRegistrationRequest;
import com.libary.my.repository.BookRepository;
import com.libary.my.repository.BorrowerRepository;
import com.libary.my.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;


@RequiredArgsConstructor
@Service
@Slf4j
public class LibraryService {
    private final BookRepository bookRepository;
    private final BorrowerRepository borrowerRepository;
    private final RecordRepository recordRepository;

    public Borrower registerBorrower(BorrowerRegistrationRequest request) {
        return borrowerRepository.save(Borrower.builder()
                .email(request.getEmail())
                .name(request.getName())
                .build());
    }

    public void borrowBook(BookBorrowRequest request) throws LibraryServiceException {
        Optional<Book> optionalBook = bookRepository.findById(UUID.fromString(request.getBookId()));
        if(optionalBook.isEmpty()){
            throw new LibraryServiceException("Book no exist");
        }
        Book book = optionalBook.get();

        Optional<Borrower> optionalBorrower = borrowerRepository.findById(UUID.fromString(request.getBorrowerId()));
        if(optionalBorrower.isEmpty()){
            throw new LibraryServiceException("Borrower no registered");
        }
        Borrower borrower = optionalBorrower.get();

        Optional<Record> optionalRecord = recordRepository.findByBookIdAndStatus(book.getId(), RecordStatusEnum.IN_BORROWING.getStatus());
        if(optionalRecord.isPresent()){
            throw new LibraryServiceException("Book is borrowing");
        }

        recordRepository.save(Record.builder()
            .bookId(book.getId())
            .borrowerId(borrower.getId())
            .status(RecordStatusEnum.IN_BORROWING.getStatus())
            .borrowTime(LocalDateTime.now()).build());
    }

    public void returnBook(BookReturnRequest request) throws LibraryServiceException {
        Optional<Book> optionalBook = bookRepository.findById(UUID.fromString(request.getBookId()));
        if(optionalBook.isEmpty()){
            throw new LibraryServiceException("Book no exist");
        }
        Book book = optionalBook.get();

        Optional<Record> optionalRecord = recordRepository.findByBookIdAndStatus(book.getId(), RecordStatusEnum.IN_BORROWING.getStatus());
        if(optionalRecord.isEmpty()){
            throw new LibraryServiceException("Book is returned, no need return again");
        }
        Record record = optionalRecord.get();
        record.setStatus(RecordStatusEnum.RETURNED.getStatus());
        record.setReturnTime(LocalDateTime.now());

        recordRepository.save(record);
    }
}
