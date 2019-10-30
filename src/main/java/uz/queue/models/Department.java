package uz.queue.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "departments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private int id;

    @Column(name = "name", unique = true)
    private String name;

    @Nullable
    @Column(name = "description", unique = true)
    private String description;

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
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "department")
//    @JsonBackReference(value = "s-d")
    private Set<Service> services = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
//    @JsonBackReference(value = "e-d")
    @JsonManagedReference(value = "e-d")
    private Set<Employee> employees;
}
