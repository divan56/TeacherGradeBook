package book.grade.teachergradebook.modelassembler;

import book.grade.teachergradebook.controller.SubjectController;
import book.grade.teachergradebook.dto.SubjectDto;
import book.grade.teachergradebook.entity.Subject;
import book.grade.teachergradebook.mapper.SubjectMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SubjectModelAssembler implements RepresentationModelAssembler<Subject, EntityModel<SubjectDto>> {
    @Override
    public EntityModel<SubjectDto> toModel(Subject entity) {
        SubjectDto subjectDto = SubjectMapper.INSTANCE.subjectToSubjectDto(entity);
        return EntityModel.of(
                subjectDto,
                linkTo(methodOn(SubjectController.class).getSubject(entity.getId())).withSelfRel(),
                linkTo(methodOn(SubjectController.class).getAllSubjects(null)).withRel("all subjects"),
                linkTo(methodOn(SubjectController.class).addNewSubject(null)).withRel("add new subject"),
                linkTo(methodOn(SubjectController.class).deleteSubject(entity.getId())).withRel("delete")
                );
    }

    @Override
    public CollectionModel<EntityModel<SubjectDto>> toCollectionModel(Iterable<? extends Subject> entities) {
        List<EntityModel<SubjectDto>> subjectsDtos = StreamSupport.stream(entities.spliterator(), false)
                .map(this::toModel)
                .toList();
        return CollectionModel.of(subjectsDtos);
    }
}
