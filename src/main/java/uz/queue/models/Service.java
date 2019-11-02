package uz.queue.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "services")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Service {

    // TODO Maybe services on orders could be detected by their UUID.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private int id;

    @Column(name = "name", unique = true)
    private String name;

    @Nullable
    @Column(name = "description")
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
    @Nullable
    @ManyToOne
    @JoinColumn(columnDefinition = "integer", name="department_id", referencedColumnName = "id")
    @JsonBackReference(value = "s-d")
    private Department department;

    @OneToMany(
            targetEntity = Employee.class,
            mappedBy = "prioritizedService",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference(value = "e-s")
    private Set<Employee> employees;

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "service",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference(value = "s-o")
    private Set<Order> orders;

    // TODO PreRemove for Orders should be added
    @PreRemove
    private void preRemove() {
        for (Employee employee : this.getEmployees())
            employee.setPrioritizedService(null);
    }
}
