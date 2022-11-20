package book.grade.teachergradebook.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private UUID id;

    private String firstName;

    private String lastName;

    private int grade;

    private List<MarkDto> marks;

}
