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
public class Entreprise extends User  implements Serializable{

	
	@NonNull private String nomEntreprise, CodeTva;
	
	@Enumerated(EnumType.STRING)
	private Domain domain;
	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy="entreprises")
		private Set<Invitation> invitations;
	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy="entreprises")
		private Set<Project> projects;
	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy="entreprises")
		private Set<Quiz> quizs;
	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy="entreprises")
		private Set<Voyage> voyages;
	 
	 
}
