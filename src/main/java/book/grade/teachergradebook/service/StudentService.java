package book.grade.teachergradebook.service;

import book.grade.teachergradebook.entity.Mark;
import book.grade.teachergradebook.entity.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    List<Student> getStudentsByName(String name);

    Student rateStudent(UUID id, Mark mark);

    Student getStudentById(UUID id);

    Student addNewStudent(Student student);

    void deleteStudentById(UUID id);

}
