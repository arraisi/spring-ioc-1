package main;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import tdi.config.KonfigurasiApps;
import tdi.dao.BankDao;
import tdi.model.Adress;
import tdi.model.Bank;
import tdi.model.Book;
import tdi.model.Perpustakaan;
import tdi.model.Person;
import tdi.service.VolService;

public class MainApps {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		// ctx.register(HelloWorldConfig.class);
		ctx.register(KonfigurasiApps.class);
		ctx.refresh();

		/*
		 * HelloWorld hw = ctx.getBean(HelloWorld.class);
		 * hw.setMessage("dddddddddddddddd "); hw.getMessage();
		 */

		VolService vol = ctx.getBean(VolService.class);
		System.out.println(vol.hitungLuasTinggi(10, 12, 20));

		BankDao bankDao = ctx.getBean(BankDao.class);
		
		Bank bank = new Bank();
		//bank.setId(1);
		bank.setJam(new Timestamp(System.currentTimeMillis()));
		bank.setNamaBank("ini entry dari hiberate hanya insert XXX ");
		bankDao.simpanHibernate(bank);
		
		List<Bank> listMap = bankDao.findAllHibernate();
		for (Bank map : listMap) {
			System.out.println(map.toString());
		}
		
		Adress alamat = new Adress();
		alamat.setKodePos("40224234");
		alamat.setKota("SMG");
		alamat.setNamaJalan("sfdsdfsdfsddfsdfds");
		bankDao.simpanHibernateAlamat(alamat);
		
		  alamat = new Adress();
		alamat.setKodePos("402884234");
		alamat.setKota("jog");
		alamat.setNamaJalan("sfdsdfsdfsddfsdfds");
		bankDao.simpanHibernateAlamat(alamat);
		
		Person person = new Person();
		person.setAlamat(alamat);
		person.setNamaBelakang("blkgsZDCZDssss");
		person.setNamaDepan("depanxCCCxxxxx");
		person.setUmur(42);
		
		bankDao.simpanHibernate(person);
		/*List<Bank> listBank = bankDao.findAll();
		for (Bank bank : listBank) {
			System.out.println(bank.getNamaBank());
		}
        int idUtama =  bankDao.simpan("Bank tes kembali ").intValue();
        
		System.out.println(" succes = " +idUtama);
		Bank bank = bankDao.findByIdNameParam(6, "B");
		bank.setNamaBank(" bank tes update ");
		bank.setJam(new Timestamp(System.currentTimeMillis()));
		System.out.println(" succes = " + bankDao.simpanUpdate(bank));*/
		Perpustakaan perpus = new Perpustakaan();
		Set<Book> daftarBuku = new HashSet<>();
		Book buku = new Book();
		buku.setAuthor("pengarangXX 1");
		buku.setPinjam(false);
		buku.setTitle("judulXX  1");
		buku.setPerpustakaan(perpus); 
		daftarBuku.add(buku);
		buku = new Book();
		buku.setAuthor("pengarangYY 1");
		buku.setPinjam(false);
		buku.setTitle("judulYY  1");
		buku.setPerpustakaan(perpus); 
		daftarBuku.add(buku);
		buku = new Book();
		buku.setAuthor("pengarangCC 1");
		buku.setPinjam(false);
		buku.setTitle("judulCC  1");
		buku.setPerpustakaan(perpus); 
		daftarBuku.add(buku);
		perpus.setDaftarBuku(daftarBuku);
		perpus.setNamaPerpustakaan("perpustakaanXXXCC 1 ");
		
		bankDao.simpanPerpusHibernate(perpus);
		
		perpus = new Perpustakaan();
		perpus.setIdPerpustakaan(5);
		
		bankDao.hapusPerpusHibernate(perpus);
		
	}

}
