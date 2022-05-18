package DAO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Products {
	private File file = new File("./src/test.txt");
	public Products() {
		try {
			//파일이 존재하지 않으면 생성
			if(!file.exists()) {
				makeProducts();
				System.out.println("생성됨");
			}else {
				System.out.println("파일 이미존재함");
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
