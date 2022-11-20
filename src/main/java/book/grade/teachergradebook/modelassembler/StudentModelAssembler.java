package book.grade.teachergradebook.modelassembler;

import book.grade.teachergradebook.controller.StudentController;
import book.grade.teachergradebook.dto.StudentDto;
import book.grade.teachergradebook.entity.Student;
import book.grade.teachergradebook.mapper.StudentMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class StudentModelAssembler implements RepresentationModelAssembler <Student, EntityModel<StudentDto>> {

    @Override
    public EntityModel<StudentDto> toModel(Student entity) {
        StudentDto studentDto = StudentMapper.INSTANCE.studentToStudentDto(entity);
        return EntityModel.of(
                studentDto,
                linkTo(methodOn(StudentController.class).one(entity.getId())).withSelfRel(),
                linkTo(methodOn(StudentController.class).deleteStudent(entity.getId())).withRel("delete"),
                linkTo(methodOn(StudentController.class).rateStudent(entity.getId(), null)).withRel("rate"),
                linkTo(methodOn(StudentController.class).findStudents(null)).withRel("students"));
    }


    @Override
    public CollectionModel<EntityModel<StudentDto>> toCollectionModel(Iterable<? extends Student> entities) {
        List<EntityModel<StudentDto>> studentDtos = StreamSupport.stream(entities.spliterator(), false)
                .map(this::toModel)
                .toList();

        return CollectionModel.of(studentDtos);
    }
}
