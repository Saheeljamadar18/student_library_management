package com.example.student_library_management_system.Controller;

import com.example.student_library_management_system.model.Student;
import com.example.student_library_management_system.requestdto.StudentRequestDto;
import com.example.student_library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/apis")
public class StudentController {
    @Autowired
      StudentService studentService;

    //for the saving of the data we have to create an save apis...
    @PostMapping("/save")

    public String saveStudent(@RequestBody StudentRequestDto studentRequestDto){
        try{
            String response = studentService.saveStudent(studentRequestDto);
            return response;
        }
        catch(Exception e){
        System.out.println("exception occured"+e.getMessage());
        return"exception occured"+e.getMessage();
        }

    }

    @GetMapping("/find/{id}")
    public Student findStudentById(@PathVariable int id){
        try {
            Student response = studentService.getStudentById(id);
            return response;
        } catch (Exception e){
            System.out.println("exception occurred:"+e.getMessage());
            throw  new RuntimeException("exception occurred:"+e.getMessage());
        }
    }

    @GetMapping("/findAll")
    public List<Student> findAll(){
        List<Student> response = studentService.getAllStudents();
        return response;
    }

    @GetMapping("/findAllByPage")
    public List<Student> findAllByPage(@RequestParam int pageNo,@RequestParam int pageSize){
        List<Student> response = studentService.getStudentByPagination(pageNo,pageSize);
        return response;
    }

    @GetMapping("/findByEmail")
    public Student findStudentByEmail(@RequestParam String email){
        Student response = studentService.getStudentByEmail(email);
        return response;
    }

    @GetMapping("/findByDept")
    public List<Student> findStudentByDept(@RequestParam String dept){
        List<Student> response = studentService.getStudentByDept(dept);
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable int id){
        String response = studentService.deleteStudentById(id);
        return response;
    }

    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable int id,@RequestBody StudentRequestDto studentRequestDto){
        String response = studentService.updateStudent(id, studentRequestDto);
        return response;
    }
}

