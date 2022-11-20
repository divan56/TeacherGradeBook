package book.grade.teachergradebook.service;

import book.grade.teachergradebook.entity.Subject;

import java.util.List;
import java.util.UUID;

public interface SubjectService {

    List<Subject> getAllSubjects(String name);

    Subject getSubject(UUID id);

    Subject addNewSubject(Subject subject);

    void deleteSubject(UUID id);
}
