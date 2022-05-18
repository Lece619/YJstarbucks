package DAO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


public class Products {
	
	private File file = new File("./src/test.txt");
	private HashMap<String,Integer> productPrice = new HashMap<>();
	
	public Products() {
		try {
			//������ �������� ������ ����
			if(!file.exists()) {
				makeProducts();
				System.out.println("������");
			}else {
				System.out.println("���� �̹�������");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void makeProducts() throws IOException {
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write("test1 100/n");
		fileWriter.write("test2 323\n");
		fileWriter.write("test3 444\n");
		fileWriter.flush();
		fileWriter.close();
	} 
	
	public int getPrice(String productName) {
		
		
		return 0;
	}
	
	public static void main(String[] args) {
		new Products();
		Products s = new Products();
	}
}
