package application;

import dao.DaoFactory;
import dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao(); 
		
		System.out.println("=== TEST ONE: findById ===");
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("\n ==== TESTE TWO: findByDepartment ===");
		
		
	}
}