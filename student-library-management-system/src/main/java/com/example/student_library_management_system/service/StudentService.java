package com.example.student_library_management_system.service;

import com.example.student_library_management_system.converters.StudentConverter;
import com.example.student_library_management_system.enums.CardStatus;
import com.example.student_library_management_system.model.Card;
import com.example.student_library_management_system.model.Student;
import com.example.student_library_management_system.repository.StudentRepository;
import com.example.student_library_management_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired//auto wire is used to create the ioc beans----object
    StudentRepository studentRepository;
    public String saveStudent(StudentRequestDto studentRequestDto){
        Student student=StudentConverter.convertStudentDtoIntoStudent(studentRequestDto);
        //whenever we are saving student card also should be saved--
        Card card=new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setExpiryDate(LocalDate.now().plusYears(4).toString());
        card.setStudent(student);
        student.setCard(card);
        //card into student
        //and student into card

        studentRepository.save(student);
        return "Student and Card saved successfully!!";

    }

    public Student getStudentById(int id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        } else{
            throw  new RuntimeException("Student not found with id:"+id);
        }
    }
    public List<Student> getAllStudents(){
        List<Student>studentList=studentRepository.findAll();
        return studentList;
    }
    /*
  Pagination - fetching or getting the records or data in the form of pages
  pagenumber - the number of page we want to see(0,1,2,3,4,5...)
  pagesize - total number of records in each page(fixed for each page)

  total number of record - 28, page size - 5
  0th page - 1-5
  1st page - 6-10
  2nd page - 11-15
  3rd page - 16-20
  4th page - 21-25
  5th page - 26-28

  total numbers of records-11, page size-3
  0th page - 1-3
  1st page - 4-6
  2nd page - 7-9
  3rd page - 10-11

  only pagination
   public List<Student> getStudentByPagination(int pageNo, int pageSize){
      List<Student> studentList = studentRepository.findAll(PageRequest.of(pageNo, pageSize)).getContent();
      return studentList;
  }
sorting - arranging the records based on asecnding or descending order
   */
    public List<Student> getStudentByPagination(int pageNo, int pageSize){
        List<Student> studentList = studentRepository.findAll(PageRequest.of(pageNo, pageSize, Sort.by("name").ascending())).getContent();
        return studentList;
    }

    public String deleteStudentById(int id){
        studentRepository.deleteById(id);
        return "Student with id: "+id+" got deleted successfully!";
    }

    public String updateStudent(int id,StudentRequestDto newStudentRequestDto){
        Student existingStudent=getStudentById(id);
        if(existingStudent!=null){
            existingStudent.setName(newStudentRequestDto.getName());
            existingStudent.setMobile(newStudentRequestDto.getMobile());
            existingStudent.setSem(newStudentRequestDto.getSem());
            existingStudent.setDob(newStudentRequestDto.getDob());
            /// ///////////////
            existingStudent.setDept(newStudentRequestDto.getDept());
            existingStudent.setGender(newStudentRequestDto.getGender());
            existingStudent.setEmail(newStudentRequestDto.getEmail());
            existingStudent.setAddress(newStudentRequestDto.getAddress());
            studentRepository.save(existingStudent);
            return "student updated successfully";
        }
        else{
            return "Student not found,cannot update";
        }
    } public Student getStudentByEmail(String email){
        Student student = studentRepository.getStudentByEmail(email);
        return student;
    }

    public List<Student> getStudentByDept(String dept){
        List<Student> student = studentRepository.getStudentByDept(dept);
        return student;
    }
}
