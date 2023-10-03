package com.assignment.entites;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity()
@Table(name = "user", schema = "shop",
        uniqueConstraints = @UniqueConstraint(name = "student_email_unique", columnNames = "email"))
public class UserInfo {

    @Id
    @Column(name = "user_name", nullable = false)
    private String userName;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "email")
    private String email;
    @Column(name = "roles")
    private String roles;
    @Column(name = "status")
    private String status;

    @ToString.Exclude
    @Column(name = "password", nullable = false, columnDefinition = "text")
    private String password;
}
