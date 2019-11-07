package uz.queue.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private int id;

    // Username of the employee and it should be unique.
    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Nullable
    @Column(name = "first_name")
    private String firstName;

    @Nullable
    @Column(name = "last_name")
    private String lastName;

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
    @Nullable
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(columnDefinition = "integer", name = "department_id", referencedColumnName = "id")
    @Fetch(FetchMode.JOIN)
    @JsonBackReference(value = "e-d")
    private Department department;

    @Nullable
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(columnDefinition = "integer", name = "service_id", referencedColumnName = "id")
    @Fetch(FetchMode.JOIN)
    @JsonBackReference(value = "e-s")
    private Service prioritizedService;

    @Nullable
    @OneToOne
    @JoinColumn(columnDefinition = "integer", name = "board_id", referencedColumnName = "id")
    @Fetch(FetchMode.JOIN)
    @JsonBackReference(value = "e-b")
    private OperatorBoard board;
}
