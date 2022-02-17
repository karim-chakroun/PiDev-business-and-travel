package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

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
public class Employee extends User implements Serializable {

	
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
		private Set<Rating> ratings;
	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy="employees")
		private Set<FeedBack> feedBacks;
	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy="employees")
		private Set<Response> responses;
	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy="employees")
		private Set<Participation> participation;
	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy="employees")
		private Set<Complain> complains;
	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy="employees")
		private Set<Project> projects;
}
