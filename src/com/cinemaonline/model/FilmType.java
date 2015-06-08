package com.cinemaonline.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="FilmType")
public class FilmType {
	private long typeId;
	private String typename;
	private Set<Film> films;//该种类电影

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getTypeId() {
		return typeId;
	}
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="flimType")
	public Set<Film> getFilms() {
		return films;
	}
	public void setFilms(Set<Film> films) {
		this.films = films;
	}
	
	
	
}
