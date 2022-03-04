package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;
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
//@NoArgsConstructor
@RequiredArgsConstructor
public class Employee  implements Serializable {
	private static final long serialVersionUID = 1L;
@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmployee;
	
 private String  email,password;
	 private int numTel;

	 private String FirstName, LastName;
	 private float prime=0;
	 private java.util.Date dateNaissance;

	@Enumerated(EnumType.STRING)
	private Profession profession;
	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.REMOVE, mappedBy="employees")
		private Set<Comment> comments;
	 @OneToMany(cascade = CascadeType.REMOVE, mappedBy="employees")
		private Set<Post> posts;
	 @OneToMany(cascade = CascadeType.REMOVE, mappedBy="employees")
		private Set<likes> likes;
		@OneToMany(mappedBy="to")
	    private List<Followers> followers;

	    @OneToMany(mappedBy="from")
	    private List<Followers> following;
	 
	
	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy="employees")
		private Set<FeedBack> feedBacks;

	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy="employees")
		private Set<Participation> participation;
	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy="employees")
		private Set<Complain> complains;
	
	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy="employees")
		private Set<ParticipationProject> participationProjects;
	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy="employees")
		private Set<Task> tasks;
}
