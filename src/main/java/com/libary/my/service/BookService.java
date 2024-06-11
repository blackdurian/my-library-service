package com.libary.my.service;

import com.libary.my.entity.Book;
import com.libary.my.exception.LibraryServiceException;
import com.libary.my.model.BookRegistrationRequest;
import com.libary.my.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book registerBook(BookRegistrationRequest request) throws LibraryServiceException {

        List<Book> booksWithSameIsbnDifferentTitleOrAuthor = bookRepository.findBooksWithSameIsbnDifferentTitleOrAuthor(request.getIsbn(), request.getTitle(), request.getAuthor());
        if(!booksWithSameIsbnDifferentTitleOrAuthor.isEmpty()){
            throw new LibraryServiceException("Same ISBN numbers must have the same title and same author.");
        }
        Book book = new Book();
        book.setAuthor(request.getAuthor());
        book.setIsbn(request.getIsbn());
        book.setTitle(request.getTitle());

        return bookRepository.save(book);
    }

}
