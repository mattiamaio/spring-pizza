package org.generation.italy.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private String nome;
	
	@Lob
	private String descrizione;
	
	@NotNull
	private Double prezzo;
	
	@ManyToMany
	private List<Ingredienti> ingredienti;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public List<Ingredienti> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(List<Ingredienti> ingredienti) {
		this.ingredienti = ingredienti;
	}
	
	public String ingredientiToString() {
		List<String> ingredientiString = new ArrayList<>();
		for(Ingredienti i : ingredienti) {
			ingredientiString.add(i.getName());
		}
		return String.join(", ", ingredientiString);	
	}
	
}
