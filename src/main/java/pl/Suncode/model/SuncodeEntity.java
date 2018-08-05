package pl.Suncode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tabela_testowa")
public class SuncodeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Long id;
	@Column
	private String kolumna1;
	@Column
	private String kolumna2;
	@Column
	private String kolumna3;
	@Column
	private Long kolumna4;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKolumna1() {
		return kolumna1;
	}
	public void setKolumna1(String kolumna1) {
		this.kolumna1 = kolumna1;
	}
	public String getKolumna2() {
		return kolumna2;
	}
	public void setKolumna2(String kolumna2) {
		this.kolumna2 = kolumna2;
	}
	public String getKolumna3() {
		return kolumna3;
	}
	public void setKolumna3(String kolumna3) {
		this.kolumna3 = kolumna3;
	}
	public Long getKolumna4() {
		return kolumna4;
	}
	public void setKolumna4(Long kolumna4) {
		this.kolumna4 = kolumna4;
	}
}
