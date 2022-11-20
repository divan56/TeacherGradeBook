package book.grade.teachergradebook.controller;

import book.grade.teachergradebook.dto.SubjectDto;
import book.grade.teachergradebook.entity.Subject;
import book.grade.teachergradebook.modelassembler.SubjectModelAssembler;
import book.grade.teachergradebook.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private SubjectModelAssembler assembler;

    @GetMapping("/")
    public CollectionModel<EntityModel<SubjectDto>> getAllSubjects(@RequestParam(required = false) String name) {
        List<Subject> subjects = subjectService.getAllSubjects(name);
        return assembler.toCollectionModel(subjects);
    }

    @GetMapping("/{id}")
    public EntityModel<SubjectDto> getSubject(@PathVariable UUID id) {
        Subject subject = subjectService.getSubject(id);
        return assembler.toModel(subject);
    }

    @PostMapping("/")
    public EntityModel<SubjectDto> addNewSubject(@RequestBody Subject subject) {
        subject = subjectService.addNewSubject(subject);
        return assembler.toModel(subject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable UUID id) {
        subjectService.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }

}
