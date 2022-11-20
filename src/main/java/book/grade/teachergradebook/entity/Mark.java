package book.grade.teachergradebook.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "marks")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mark {

    @Id
    @GeneratedValue
    @Column(name = "id")
    @ApiModelProperty(hidden = true)
    private UUID id;

    @Column(name = "mark")
    private char mark;

    @Column(name = "date")
    @CreationTimestamp
    @ApiModelProperty(hidden = true)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @ApiModelProperty(hidden = true)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
