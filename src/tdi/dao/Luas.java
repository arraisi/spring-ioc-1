package tdi.dao;

import org.springframework.stereotype.Component;

@Component
public class Luas {
	public double hitungLuas(double panjang, double lebar) {
		return panjang * lebar;
	}
}
