package book.grade.teachergradebook.service;

import book.grade.teachergradebook.entity.Subject;
import book.grade.teachergradebook.exception.SubjectNotFoundException;
import book.grade.teachergradebook.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    @Transactional
    public List<Subject> getAllSubjects(String name) {
        return subjectRepository.getSubjectsByNameContainsIgnoreCase(name);
    }

    @Override
    public Subject getSubject(UUID id) {
        return subjectRepository.findById(id).orElseThrow(() -> new SubjectNotFoundException("There is no subject with id " + id));
    }

    @Override
    @Transactional
    public Subject addNewSubject(Subject subject) {
        return subject = subjectRepository.saveAndFlush(subject);
    }

    @Override
    @Transactional
    public void deleteSubject(UUID id) {
        subjectRepository.deleteById(id);
    }


}
