package uz.queue.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private int id;

    @Nullable
    @ManyToOne
    @JoinColumn(columnDefinition = "integer", name = "service_id", referencedColumnName = "id")
    @JsonBackReference(value = "s-o")
    private Service service;

    @Nullable
    @Column(name = "index_number")
    private int indexNumber;

    // Who performed order
    @Column(name = "order_executor")
    private String orderExecutor;

    // Date when order is created
    @Nullable
    @Column(name = "registered_date")
    private LocalDateTime registeredDate;

    // Date when order is accepted by Employee
    @Nullable
    @Column(name = "accepted_date")
    private LocalDateTime acceptedDate;

    // Date when order is performed by Employee
    @Nullable
    @Column(name = "performed_date")
    private LocalDateTime performedDate;

    // Current Date, if order is passed, but not performed after waiting
    @Nullable
    @Column(name = "passed_date")
    private LocalDateTime passedDate;

    // Total waiting time in queue
    @Nullable
    @Column(name = "time_spent_waiting_in_queue")
    private long timeSpentWaitingInQueue;

    // Total Employee's waiting time before Customer came to desk,
    // Order has been cancelled
    @Nullable
    @Column(name = "visitor_waiting_time")
    private long visitorWaitingTime;

    // Total service performing time
    @Nullable
    @Column(name = "time_taken_to_complete")
    private long timeTakenToComplete;

    @Nullable
    @Column(name = "is_performed")
    private boolean orderPerformed = false;

    @Nullable
    @Column(name = "is_passed")
    private boolean orderPassed = false;

    /*
     * Timestamps
     */
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

}
