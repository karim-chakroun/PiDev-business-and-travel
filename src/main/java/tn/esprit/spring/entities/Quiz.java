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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
public class Quiz  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idQuiz;
	private String nameQuiz;
	private int numQuestion;
	private int Score;
	private Type TypeQuiz;
	@ToString.Exclude
	@JsonIgnore
	@ManyToOne
	private Entreprise entreprises;
	
	
	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy="quizs")
		private Set<Question> questions;
	@JsonIgnore
	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy="quiz")
		private Set<Result> results;
}