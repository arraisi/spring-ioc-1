package tdi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "M_PERSON")
public class Person {
	@Id
	@Column(name = "ID_PERSON")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "AGE" )
	private int umur;
	@Column(name = "FIST_NAME", length = 70)
	private String namaDepan;
	@Column(name = "LAST_NAME", length = 100)
	private String namaBelakang;
	
	@OneToOne( cascade=CascadeType.ALL)
	@JoinColumn(name="ID_ALAMAT_FK")
	private Adress alamat;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUmur() {
		return umur;
	}

	public void setUmur(int umur) {
		this.umur = umur;
	}

	public String getNamaDepan() {
		return namaDepan;
	}

	public void setNamaDepan(String namaDepan) {
		this.namaDepan = namaDepan;
	}

	public String getNamaBelakang() {
		return namaBelakang;
	}

	public void setNamaBelakang(String namaBelakang) {
		this.namaBelakang = namaBelakang;
	}

	public Adress getAlamat() {
		return alamat;
	}

	public void setAlamat(Adress alamat) {
		this.alamat = alamat;
	}
	
	
}
