package book.grade.teachergradebook.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "students")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "id")
    @ApiModelProperty(hidden = true)
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "grade")
    @Min(value = 0, message = "Grade must be > 0")
    @Max(value = 12, message = "Grade must be < 12")
    private int grade;

    @OneToMany(mappedBy = "student")
    @ApiModelProperty(hidden = true)
    private List<Mark> marks;

    public void addMark(Mark mark) {
        marks.add(mark);
    }
}
