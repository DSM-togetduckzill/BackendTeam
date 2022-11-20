package com.example.tugetduckzillserver.domain.user.domain;

import com.example.tugetduckzillserver.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Getter // 접근자 자동 생성
@AllArgsConstructor(access = AccessLevel.PRIVATE) // 모든 필드 값을 파라미터로 받는 생성자 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 파라미터가 없는 기본 생성자 생성
@Builder // 파라미터를 활용하여 빌더 패턴을 자동으로 생성
@Table(name = "tbl_user") // 테이블 이름 지정
@Entity // 데이터베이스의 테이블과 일대일로 매칭되는 객체 단위
public class User {

    @Id // PK(Primary Key) 기본키
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @NotNull
    @Column(columnDefinition = "VARCHAR(16)")
    private String accountId;

    @NotNull // null 값 허용 X
    @Column(columnDefinition = "VARCHAR(15)")
    //데이타베이스의 테이블에 있는 컬럼과 동일하게 1:1로 매칭되기 때문에 Entity 클래스안에 내부변수로 정의
    private String name; // 이름

    @NotNull
    @Column(columnDefinition = "CHAR(60)")
    private String password; // 패스워드

    @NotNull
    @Column(columnDefinition = "VARCHAR(255)")
    private String introduce; // 한줄 소개

    @NotNull
    @Column(columnDefinition = "DATE")
    private LocalDate birthday; // 생일

    @NotNull
    @Column(columnDefinition = "VARCHAR(11)")
    private String phoneNumber; // 핸드폰 번호

    @NotNull
    @Column(columnDefinition = "VARCHAR(255)")
    private String profileImage; // 프로필 이미지

    @Builder
    public User(UUID id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public void update(UpdateUserInfoRequest request) {
        this.name = request.getName();
        this.introduce = request.getIntroduce();
        this.birthday = request.getBirthday();
        this.phoneNumber = request.getPhoneNumber();
        this.profileImage = request.getProfileImage();
    }

    public void update(String name, String introduce, LocalDate birthday, String phoneNumber, String profileImage) {
        this.name = name;
        this.introduce = introduce;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.profileImage = profileImage;
    }
}
