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
@Table(name="BOOK")
public class Book {

	@Id
	@Column(name = "ID_BOOK")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "JUDUL",length=100 )
	private String title;
	@Column(name = "PENGARANG",length=100  )
	private String author;
	
	@Column(name = "IS_PINJAM" )
	private boolean isPinjam;
	
	 
	@OneToOne( fetch = FetchType.LAZY ,cascade=CascadeType.ALL)
	@JoinColumn(name="ID_PERPUS")
    private Perpustakaan perpustakaan;
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Perpustakaan getPerpustakaan() {
		return perpustakaan;
	}

	public void setPerpustakaan(Perpustakaan perpustakaan) {
		this.perpustakaan = perpustakaan;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isPinjam() {
		return isPinjam;
	}

	public void setPinjam(boolean isPinjam) {
		this.isPinjam = isPinjam;
	}

}
