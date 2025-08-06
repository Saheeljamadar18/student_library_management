package com.example.student_library_management_system.service;

import com.example.student_library_management_system.converters.BookConverter;
import com.example.student_library_management_system.model.Author;
import com.example.student_library_management_system.model.Book;
import com.example.student_library_management_system.model.Card;
import com.example.student_library_management_system.repository.AuthorRepository;
import com.example.student_library_management_system.repository.BookRepository;
import com.example.student_library_management_system.repository.CardRepository;
import com.example.student_library_management_system.requestdto.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    CardRepository cardRepository;
    public String saveBook(BookRequestDto bookRequestDto){
        Book book=BookConverter.convertBookRequestDtoIntoBook(bookRequestDto);
        //add the foreign key
        //using author-id we want to fetch all the details of the author
       Author author= authorRepository.findById(bookRequestDto.getAuthorId()).get();
       if(author!=null){
           book.setAuthor(author);
       }else{
           book.setAuthor(null);
       }
        //using card-id we want to fetch all the detail of the card
       Card card= cardRepository.findById(bookRequestDto.getCardId()).get();
        //these are two foreign key which are
        if(card!=null){
            book.setCard(card);

        }
        else{
            book.setCard(null);
        }
        bookRepository.save(book);
        return "book saved successfully!!";

    }
}
