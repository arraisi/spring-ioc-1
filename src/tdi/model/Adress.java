package tdi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "M_ALAMAT")
public class Adress {

	@Id
	@Column(name = "ID_ALAMAT")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "KODE_POS", length = 10)
	private String kodePos;
	@Column(name = "KOTA", length = 70)
	private String kota;
	@Column(name = "NAMA_JALAN", length = 100)
	private String namaJalan;

	@OneToOne(mappedBy="alamat", cascade=CascadeType.ALL)
	private Person person;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKodePos() {
		return kodePos;
	}

	public void setKodePos(String kodePos) {
		this.kodePos = kodePos;
	}

	public String getKota() {
		return kota;
	}

	public void setKota(String kota) {
		this.kota = kota;
	}

	public String getNamaJalan() {
		return namaJalan;
	}

	public void setNamaJalan(String namaJalan) {
		this.namaJalan = namaJalan;
	}

}
