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
@Table(name = "services")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Service {

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
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "services_departments",
            joinColumns = { @JoinColumn(name = "service_id") },
            inverseJoinColumns = { @JoinColumn(name = "department_id") })
    private Set<Department> department = new HashSet<>();

    @JsonManagedReference(value = "e-s")
    @OneToMany(mappedBy="prioritizedService")
    private Set<Employee> employees;
}
