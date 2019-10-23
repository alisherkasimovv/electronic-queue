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

    // Identification number for operator board.
    // Will be used in the system. Should be unique.
    @Nullable
    @Column(name = "identification", unique = true)
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
