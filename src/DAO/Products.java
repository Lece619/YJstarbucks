package DAO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Products {
	private File file = new File("./src/test.txt");
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
		fileWriter.write("test\n");
		fileWriter.write("test\n");
		fileWriter.write("test\n");
		fileWriter.flush();
		fileWriter.close();
	}
	public static void main(String[] args) {
		new Products();
		Products s = new Products();
	}
}
