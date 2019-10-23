package uz.queue.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "operator_boards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperatorBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private int id;

    @Nullable
    @Column(name = "identification")
    private String identification;

    @Nullable
    @Column(name = "url")
    private String link;

    /*
     * Relations
     */
    @OneToOne(mappedBy = "board")
    private Employee employee;
}
