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
import javax.persistence.ManyToOne;
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
public class Project  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProject;
	@NonNull private String description, libelle, nom, documents;

	@NonNull private java.util.Date dateDebut, dateFin;
	@NonNull private float budget;
	@NonNull private int intervenant=0;
	@NonNull private int nbreTask=0;
	@Enumerated(EnumType.STRING)
	
	private Etat etat= Etat.pending;
	
	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy="projects")
		private Set<ParticipationProject> participationProjects;

	@ToString.Exclude
	@ManyToOne
	private Entreprise entreprises;
	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy="projects")
		private Set<Task> tasks;
	
	
}
