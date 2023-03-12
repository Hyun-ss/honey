package com.hyun.honey.domain.entity;

import com.hyun.honey.security.MyRole;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Member")
@Entity
public class MemberEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long mno;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String nickName;
    @Column(nullable = false)
    private long phone;
    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    //ROLE--enum
    @Builder.Default
    @Enumerated(EnumType.STRING)//설정하지 않으면 ORDINAL
    @ElementCollection(fetch = FetchType.EAGER)
    Set<MyRole> roles=new HashSet<>();
    //role 적용을 위한 편의메서드
    public MemberEntity addRole(MyRole role){
        roles.add(role);
        return this;
    }
}
