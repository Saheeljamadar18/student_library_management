package com.example.student_library_management_system.Controller;

import com.example.student_library_management_system.requestdto.AuthorRequestDto;
import com.example.student_library_management_system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author/apis")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping("/save")
    public String saveAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        String Response=authorService.saveAuthor(authorRequestDto);
        return "Author is saved successfully!!";
    }
}
