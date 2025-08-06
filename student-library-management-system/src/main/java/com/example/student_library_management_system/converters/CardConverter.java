package com.example.student_library_management_system.converters;

import com.example.student_library_management_system.model.Card;
import com.example.student_library_management_system.requestdto.CardRequestDto;

public class CardConverter {
    public static Card converterCardRequestDtoIntoCards(CardRequestDto cardRequestDto){
        Card card=new Card();
        card.setCardStatus(cardRequestDto.getCardStatus());
        card.setExpiryDate(cardRequestDto.getExpiryDate());

        return card;
    }
}
