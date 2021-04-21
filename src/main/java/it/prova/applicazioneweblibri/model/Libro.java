package it.prova.applicazioneweblibri.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "titolo")
	private String titolo;

	@Column(name = "genere")
	private String genere;

	@Column(name = "pagine")
	private Integer pagine;

	@Column(name = "data_pubblicazione")
	private Date dataPubblicazione;

	public Libro() {
		super();
	}

	public Libro(Long id, String titolo, String genere, Integer pagine, Date dataPubblicazione) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.genere = genere;
		this.pagine = pagine;
		this.dataPubblicazione = dataPubblicazione;
	}

	public Libro(String titolo, String genere, Integer pagine, Date dataPubblicazione) {
		super();
		this.titolo = titolo;
		this.genere = genere;
		this.pagine = pagine;
		this.dataPubblicazione = dataPubblicazione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public Integer getPagine() {
		return pagine;
	}

	public void setPagine(Integer pagine) {
		this.pagine = pagine;
	}

	public Date getDataPubblicazione() {
		return dataPubblicazione;
	}

	public void setDataPubblicazione(Date dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titolo=" + titolo + ", genere=" + genere + ", pagine=" + pagine
				+ ", dataPubblicazione=" + dataPubblicazione + "]";
	}

}
