package com.example.student_library_management_system.converters;

import com.example.student_library_management_system.model.Transaction;

import com.example.student_library_management_system.requestdto.TransactionRequestDto;

public class TransactionConverter {
    public static Transaction converterTransactionRequestDtoIntoTransaction(TransactionRequestDto transactionRequestDto){
        Transaction transaction =new Transaction();
       transaction.setTransactionType(transactionRequestDto.getTransactionType());
       transaction.setDueDate(transactionRequestDto.getDueDate());


        return transaction;
    }
}
