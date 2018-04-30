package tdi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tdi.dao.Luas;

@Component("volService")
public class Volume implements VolService{
	@Autowired
	private Luas luas;
	
	public double hitungLuasTinggi(double panjang, double lebar,double tinggi) {
		return luas.hitungLuas(panjang, lebar)*tinggi;
	}
	

}
