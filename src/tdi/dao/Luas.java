package tdi.dao;

import org.springframework.stereotype.Component;

@Component("luasDua")
public class Luas implements LuasDao {
	public double hitungLuas(double panjang, double lebar) {
		return panjang * lebar;
	}
}
