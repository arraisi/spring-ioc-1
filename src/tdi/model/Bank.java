package tdi.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TMBANK")
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BANK" )
	private int id;

	@Column(name = "NAMA_BANK",length=75,nullable=false)
	private String namaBank;
	
	@Column(name = "JAM_ENTRY" )
	private Timestamp jam;

	public Timestamp getJam() {
		return jam;
	}

	public void setJam(Timestamp jam) {
		this.jam = jam;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNamaBank() {
		return namaBank;
	}

	public void setNamaBank(String namaBank) {
		this.namaBank = namaBank;
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", namaBank=" + namaBank + "]";
	}

}
