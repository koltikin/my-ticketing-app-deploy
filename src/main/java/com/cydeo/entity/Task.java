package com.cydeo.entity;

import com.cydeo.enums.Status;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "tasks")
@Where(clause = "is_deleted = false")
public class Task extends BaseEntity{

    @ManyToOne
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private User assignedEmployee;
    private String taskSubject;
    private String taskDetail;

    @Enumerated(EnumType.STRING)
    private Status taskStatus;

    @Column(columnDefinition = "DATE")
    private LocalDate assignedDate;


    @PrePersist
    protected void onPrePersist(){
        this.assignedDate = LocalDate.now();
        this.taskStatus = Status.OPEN;
    }
}
