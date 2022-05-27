package com.elephantitech.userservice.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String mobileNumber;
	private String name;
	private String email;
	private String password;
	private String phoneNo;
	private String adharCard;
	private String drivingLicence;
	private String bloodGroup;
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Collection<Role> roles;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		User user = (User) o;
		return userId != null && Objects.equals(userId, user.userId);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
