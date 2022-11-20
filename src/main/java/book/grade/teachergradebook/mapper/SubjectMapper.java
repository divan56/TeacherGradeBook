package book.grade.teachergradebook.mapper;

import book.grade.teachergradebook.dto.SubjectDto;
import book.grade.teachergradebook.entity.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectMapper {
    SubjectMapper INSTANCE = Mappers.getMapper(SubjectMapper.class);

    SubjectDto subjectToSubjectDto(Subject subject);
}
