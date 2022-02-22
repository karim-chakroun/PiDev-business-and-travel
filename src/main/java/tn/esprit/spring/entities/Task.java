package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class Task  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTask;
	@Temporal (TemporalType.DATE)
	@NonNull private java.util.Date dateTask= new Date(System.currentTimeMillis());
	@NonNull private String nom, description;
	@Enumerated(EnumType.STRING)
	private Etat etat=Etat.todo;
	@ToString.Exclude
	@ManyToOne
	private Project projects;
	@ToString.Exclude
	@ManyToOne
	private Employee employees;
}
