package book.grade.teachergradebook.repository;

import book.grade.teachergradebook.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubjectRepository extends JpaRepository<Subject, UUID> {

    Optional<Subject> getSubjectByName(String name);

    List<Subject> getSubjectsByNameContainsIgnoreCase(String name);

}
