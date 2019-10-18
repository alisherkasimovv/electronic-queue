package uz.queue.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import javax.persistence.OneToMany;
import java.util.List;
import javax.persistence.*;
import java.util.*;

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

    @Nullable
    @Column(name = "difficulty")
    private int difficulty;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "services_departments",
            joinColumns = { @JoinColumn(name = "service_id") },
            inverseJoinColumns = { @JoinColumn(name = "department_id") })
    private Set<Department> department = new HashSet<>();

}
