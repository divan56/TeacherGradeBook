package book.grade.teachergradebook.service;

import book.grade.teachergradebook.entity.Mark;
import book.grade.teachergradebook.entity.Student;
import book.grade.teachergradebook.entity.Subject;
import book.grade.teachergradebook.exception.StudentNotFoundException;
import book.grade.teachergradebook.exception.SubjectNotFoundException;
import book.grade.teachergradebook.repository.MarkRepository;
import book.grade.teachergradebook.repository.StudentRepository;
import book.grade.teachergradebook.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private MarkRepository markRepository;

    @Override
    @Transactional
    public Student rateStudent(UUID studentId, Mark mark) {
        String subjectName = mark.getSubject().getName();
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException("There is no student with id " + studentId));
        Subject subject = subjectRepository.getSubjectByName(subjectName).orElseThrow(() -> new SubjectNotFoundException("There is no subject with name " + subjectName));
        mark.setStudent(student);
        mark.setSubject(subject);
        markRepository.save(mark);
        return student;
    }

    @Override
    @Transactional
    public Student getStudentById(UUID id) {
        return studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("There is no student with id " + id));
    }

    @Override
    @Transactional
    public Student addNewStudent(Student student) {
        student = studentRepository.saveAndFlush(student);
        return student;
    }

    @Override
    @Transactional
    public void deleteStudentById(UUID id) {
        studentRepository.deleteById(id);
    }


    @Override
    @Transactional
    public List<Student> getStudentsByName(String name) {
        return studentRepository.findStudentsByFirstNameContainsIgnoreCase(name);
    }
}
