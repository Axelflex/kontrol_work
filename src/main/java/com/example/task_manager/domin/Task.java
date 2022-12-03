package com.example.task_manager.domin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@Entity(name = "tasks")
public class Task {
    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    private Long id;
    private String text;
    private Status status;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usr_id")
    private User user;

    public Task(String text, Status status, User user) {
        this.text = text;
        this.status = status;
        this.user = user;
    }
}
