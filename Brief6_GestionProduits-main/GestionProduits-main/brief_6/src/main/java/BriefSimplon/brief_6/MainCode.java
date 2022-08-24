package BriefSimplon.brief_6;

import Implementation.ImplCategory;
import Implementation.ImplProduct;

import java.util.Scanner;
import Classes.Category;
import Classes.Product;

public class MainCode {
	public static Scanner scan = new Scanner(System.in);
	public static Product product;
	public static Category category;
	public static ImplProduct imp;
	public static ImplCategory imc;

	public static void main(String[] args) {
		int choice1, choicep, choicec;
		System.out.println("___________________Menu_________________________");
		System.out.println("Choose your operation type");
		System.out.println("1 : Product");
		System.out.println("2 : Category");
		choice1 = scan.nextInt();
		product = new Product();
		 category = new Category();
		 imp = new ImplProduct();
	     imc = new ImplCategory();

		do {
			 
			if (choice1 == 1) {
				System.out.println("Choose your operation type");
				System.out.println("1 : Add product");
				System.out.println("2 : Edit product");
				System.out.println("3 : Delete product");
				System.out.println("4 : List product");
				choicep = scan.nextInt();
				switch (choicep) {
				case 1:
					
					addProduct(product);
					imp.add(product);
					break;

				case 2:
					editProduct(product);
					imp.edit(product);
					break;
				case 3:
					deleteProduct(product);
					imp.delete(product);
					break;

				case 4:
					
					listProducts();

					break;
				}

			} else if (choice1 == 2) {
				System.out.println("Choose your operation type");
				System.out.println("1 : Add category");
				System.out.println("2 : Edit category");
				System.out.println("3 : Delete category");
				System.out.println("4 : List category");
				choicec = scan.nextInt();
				switch (choicec) {
				case 1:
					addCategory(category);
					imc.add(category);
					break;

				case 2:
					editCategory(category);
					imc.edit(category);
					break;
				case 3:
					deleteCategory(category);
					imc.delete(category);
					break;

				case 4:
					imc.listAll(category);
					break;
				}

			} else {
				System.out.println("the number you enter is wrong !!");
			}

		} while (choice1 < 0 && choice1 > 2);

	}
	// ------------------------- The Product ----------------------------------\\

	public static void addProduct(Product product) {

		System.out.println("||------------------- Adding operation -------------------------||");
		
		System.out.println("               ===> Product identifier <====                ");
		product.setIdp(scan.nextInt());
		
		System.out.println("                       < Product name >                      ");
		product.setTitre(scan.next());
		
		System.out.println("                    < Product description >                 ");
		product.setDescription(scan.next());
		
		System.out.println("                       < Product price >                     ");
		product.setPrix(scan.nextFloat());
		
		System.out.println("                     < Category identifier >                ");
		System.out.println("0 Cosmetic Product _ 1 Alimentary Products_ 2 Traditional clothes");     
		product.setIdc(scan.nextInt());
		
		System.out.println("||------------------- Added successfully -------------------------||");

	}

	public static void editProduct(Product product) {
		System.out.println("||------------------- Editing operation -------------------------||");
		System.out.println("               ===> Product identifier <====                ");
		product.setIdp(scan.nextInt());
		
		System.out.println("                       < Product name >                      ");
		product.setTitre(scan.next());
		
		System.out.println("                    < Product description >                 ");
		product.setDescription(scan.next());
		
		System.out.println("||------------------- Edited successfully -------------------------||");
	}

	public static void deleteProduct(Product product) {

		System.out.println("||------------------- Deleting operation -------------------------||");
		System.out.println("     ===> Choose product's Identifier your want to delete <====      ");
		product.setIdp(scan.nextInt());
		System.out.println("||------------------- Deleted successfully -------------------------||");

	}

	public static void listProducts() {

		int optiondeliste,idc;

		System.out.println("||------------------- Listing operation -------------------------||");
		System.out.println("1 : All the products");
		System.out.println("2 : List the product by category");

		optiondeliste = scan.nextInt();
		if (optiondeliste == 1) {
			System.out.println(" - All the products - ");
			imp.listAll(product);
		} else if(optiondeliste==2){
			imc.listAll(category);
			System.out.println(" Choose the category id ");
			idc= scan.nextInt();
			imp.ListProductByCategory(idc);
		}

	}


	// ------------------------- The Category ----------------------------------\\
	public static void addCategory(Category category) {

		System.out.println("||------------------- Adding operation -------------------------||");
		System.out.println("                       < Category id >                      ");
		category.setIdc(scan.nextInt());
		System.out.println("                       < Category name >                      ");
		category.setNamec(scan.next());
		System.out.println("||------------------- Added successfully -------------------------||");

	}

	public static void editCategory(Category category) {
		System.out.println("||------------------- Editing operation -------------------------||");
		System.out.println("               ===> Product identifier <====                ");
		category.setIdc(scan.nextInt());
		System.out.println("                       < Product name >                      ");
		category.setNamec(scan.next());
		System.out.println("||------------------- Edited successfully -------------------------||");
	}

	public static void deleteCategory(Category category) {

		System.out.println("||------------------- Deleting operation -------------------------||");
		System.out.println("     ===> Choose category's Identifier your want to delete <====      ");
		category.setIdc(scan.nextInt());
		System.out.println("||------------------- Deleted successfully -------------------------||");

	}

}
