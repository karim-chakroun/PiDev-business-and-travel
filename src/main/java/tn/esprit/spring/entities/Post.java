package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
public class Post  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPost;
	@NonNull private String titre, body;
	
	@NonNull private java.util.Date datePost;
	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy="posts")
		private Set<Comment> comments;
	 @ToString.Exclude
		@OneToMany(cascade = CascadeType.ALL, mappedBy="posts")
		private Set<Rating> ratings;
}
