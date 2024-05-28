package com.ssafy.user.domain;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="users")
@NoArgsConstructor//JPA는 public, portected로 되어있는 default생성자 반드시 필요
@AllArgsConstructor
@Getter
@ToString
@Builder
@DynamicInsert
public class User {

	@Id
	private String userId;
	@Column(name="user_name", nullable=false)
	private String userName;
	@Column(nullable = false)
	private String password;
	private String email;
	private String joinTime;
	@ColumnDefault("0")
	private int role;

}
