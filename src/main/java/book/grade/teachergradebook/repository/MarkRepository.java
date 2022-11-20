package book.grade.teachergradebook.repository;

import book.grade.teachergradebook.entity.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MarkRepository extends JpaRepository<Mark, UUID> {
}