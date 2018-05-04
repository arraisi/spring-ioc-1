package tdi.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 

@Entity
@Table(name="PERPUSTAKAAN")
public class Perpustakaan {
	
	@Id
	@Column(name = "ID_PERPUSTAKAAN")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPerpustakaan;
	
	@OneToMany(mappedBy="perpustakaan",cascade= {CascadeType.ALL, CascadeType.REMOVE} )
	private Set<Book> daftarBuku;
	
	@Column(name = "NAMA_PERPUSTAKAAN",length=100  )
	private String namaPerpustakaan;

	
	
	public int getIdPerpustakaan() {
		return idPerpustakaan;
	}

	public void setIdPerpustakaan(int idPerpustakaan) {
		this.idPerpustakaan = idPerpustakaan;
	}

	public Set<Book> getDaftarBuku() {
		return daftarBuku;
	}

	public void setDaftarBuku(Set<Book> daftarBuku) {
		this.daftarBuku = daftarBuku;
	}

	public String getNamaPerpustakaan() {
		return namaPerpustakaan;
	}

	public void setNamaPerpustakaan(String namaPerpustakaan) {
		this.namaPerpustakaan = namaPerpustakaan;
	}
}
