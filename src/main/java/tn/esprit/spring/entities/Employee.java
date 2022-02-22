package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmployee;
	
	@NonNull private String  email,password;
	@NonNull private int numTel;

	@NonNull private String FirstName, LastName;
	@NonNull private float prime;
	@NonNull private java.util.Date dateNaissance;

	@Enumerated(EnumType.STRING)
	private Profession profession;
	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy="employees")
		private Set<Comment> comments;
	
	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy="employees")
		private Set<FeedBack> feedBacks;

	 @JsonIgnore
	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy="employees")
		private Set<Complain> complains;
	
	
}