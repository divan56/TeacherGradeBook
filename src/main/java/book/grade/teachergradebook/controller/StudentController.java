package book.grade.teachergradebook.controller;

import book.grade.teachergradebook.dto.StudentDto;
import book.grade.teachergradebook.entity.Mark;
import book.grade.teachergradebook.entity.Student;
import book.grade.teachergradebook.modelassembler.StudentModelAssembler;
import book.grade.teachergradebook.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/students")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentModelAssembler assembler;

    @GetMapping("/")
    public CollectionModel<EntityModel<StudentDto>> findStudents(@RequestParam(required = false) String name) {
        List<Student> students = studentService.getStudentsByName(name);
        return assembler.toCollectionModel(students);
    }

    @PostMapping("/rate/{id}")
    public EntityModel<StudentDto> rateStudent(
            @PathVariable UUID id,
            @RequestBody Mark mark
            ) {
        Student student = studentService.rateStudent(id, mark);
        return assembler.toModel(student);
    }

    @GetMapping("/{id}")
    public EntityModel<StudentDto> one(@PathVariable UUID id) {
        Student student = studentService.getStudentById(id);
        return assembler.toModel(student);
    }

    @PostMapping("/")
    public EntityModel<StudentDto> addNewStudent(@RequestBody @Valid Student student) {
        student = studentService.addNewStudent(student);
        return assembler.toModel(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable UUID id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
}
