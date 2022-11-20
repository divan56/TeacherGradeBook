package book.grade.teachergradebook.mapper;

import book.grade.teachergradebook.dto.MarkDto;
import book.grade.teachergradebook.entity.Mark;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MarkMapper {

    MarkMapper INSTANCE = Mappers.getMapper(MarkMapper.class);

    MarkDto markToMarkDto (Mark mark);

}
