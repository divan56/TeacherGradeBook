package book.grade.teachergradebook.mapper;

import book.grade.teachergradebook.dto.StudentDto;
import book.grade.teachergradebook.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDto studentToStudentDto(Student student);
}
