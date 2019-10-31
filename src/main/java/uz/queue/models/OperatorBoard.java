package uz.queue.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @NonNull
    @Column(name = "isReserved", nullable = false, columnDefinition = "boolean default 'false'")
    private Boolean isReserved;

    /*
     * Timestamps
     */
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    /*
     * Relations
     */
    @OneToOne(mappedBy = "board")
    @JsonManagedReference(value = "e-b")
    private Employee employee;
}
