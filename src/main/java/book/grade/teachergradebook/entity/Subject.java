package book.grade.teachergradebook.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "subjects")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    @Id
    @GeneratedValue
    @Column(name = "id")
    @ApiModelProperty(hidden = true)
    private UUID id;

    @Column(name = "name")
    private String name;

}
