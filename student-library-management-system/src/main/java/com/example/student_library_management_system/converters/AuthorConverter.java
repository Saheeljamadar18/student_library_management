package com.example.student_library_management_system.converters;

import com.example.student_library_management_system.model.Author;
import com.example.student_library_management_system.requestdto.AuthorRequestDto;

public class AuthorConverter {
    public static Author convertAuthorRequestDtoIntoAuthor(AuthorRequestDto authorRequestDto){
        Author author=new Author();
        author.setName(authorRequestDto.getName());
        author.setCountry(authorRequestDto.getCountry());
        author.setGender(authorRequestDto.getGender());
        author.setEmail(authorRequestDto.getEmail());
        author.setRating(authorRequestDto.getRating());
        return author;

    }
}
