package uz.queue.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import java.util.*;
import javax.persistence.*;

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

    @Column(name = "employee", unique = true)
    private int employee;

//    @Column(name = "services", unique = true)
//    private int services;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "department")
    private Set<Service> service = new HashSet<>();

}
