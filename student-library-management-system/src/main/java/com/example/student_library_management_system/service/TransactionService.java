package com.example.student_library_management_system.service;

import com.example.student_library_management_system.converters.TransactionConverter;
import com.example.student_library_management_system.model.Author;
import com.example.student_library_management_system.model.Book;
import com.example.student_library_management_system.model.Card;
import com.example.student_library_management_system.model.Transaction;
import com.example.student_library_management_system.repository.BookRepository;
import com.example.student_library_management_system.repository.CardRepository;
import com.example.student_library_management_system.repository.TransactionRepository;
import com.example.student_library_management_system.requestdto.TransactionRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    CardRepository cardRepository;
    @Autowired
    BookRepository bookRepository;
    public String saveTransaction(TransactionRequestDto transactionRequestDto){
      Transaction transaction=TransactionConverter.converterTransactionRequestDtoIntoTransaction(transactionRequestDto);
        //using author-id we want to fetch all the details of the author
        Book book= bookRepository.findById(transactionRequestDto.getBookId()).get();
        if(book!=null){
            transaction.setBook(book);
        }else{
            transaction.setBook(null);
        }
        //using card-id we want to fetch all the detail of the card
        Card card= cardRepository.findById(transactionRequestDto.getCardId()).get();
        //these are two foreign key which are
        if(card!=null){
            transaction.setCard(card);

        }
        else{
            transaction.setCard(null);
        }
      transactionRepository.save(transaction);
      return "transaction saved successfully";

    }
}





















