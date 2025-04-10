package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat();
		List<Product> product = new ArrayList<>();
		
		System.out.print("Informe a quantidade de produtos: ");
		int n = sc.nextInt();
		
		for(int i = 1; i < n; i++) {
			System.out.println("Informe os dados do Produto " + i + ": ");
			System.out.print("O produto é comum, importado ou usado (c/i/u)? ");
			char typeProduct = sc.next().charAt(0);
			System.out.print("Nome do Produto: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Preço: ");
			sc.nextLine();
			double price = sc.nextDouble();
			if(typeProduct == 'i') {
				System.out.print("Valor da taxa do amor: ");
				double customsFee = sc.nextDouble();
				product.add(new ImportedProduct(name, price, customsFee));
			}else if(typeProduct == 'u') {
				System.out.print("Data de Fabricação: ");
				Date manufactureDate = sdf.parse(sc.next());
				product.add(new UsedProduct(name, price, manufactureDate));
			}else {
				product.add(new Product(name, price));
			}
		}
		
		sc.close();

	}

}
