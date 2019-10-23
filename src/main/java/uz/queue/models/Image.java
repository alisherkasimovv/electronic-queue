package uz.queue.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import java.util.*;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.*;

@Entity
@Table(name= "images")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Nullable
    @Column(name = "image", columnDefinition = "TEXT")
    private String image;

    /*
     * Relations
     */
    @Any (metaColumn =  @Column(name = "objectType"))
    @AnyMetaDef(idType = "long", metaType = "string",
            metaValues = {
                    @MetaValue(targetEntity = Department.class, value = "department"),
                    @MetaValue(targetEntity = Service.class, value = "service"),
                    @MetaValue(targetEntity = Employee.class, value="employee")
            })
    @Cascade( { org.hibernate.annotations.CascadeType.ALL})
    @JoinColumn(name = "objectId")
    private String objectType;
}
