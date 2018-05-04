package tdi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tdi.dao.LuasDao;


public class Volume implements VolService{
	@Autowired
	private LuasDao luasDua;
	
	public double hitungLuasTinggi(double panjang, double lebar,double tinggi) {
		System.out.println(" luas  = "+luasDua.hitungLuas(panjang, lebar));
		return luasDua.hitungLuas(panjang, lebar)*tinggi;
	}
	

}
