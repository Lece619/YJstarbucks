package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Products {
	
	private File file = new File("./src/test.txt");
	private HashMap<String,Integer> productPrice = new HashMap<>();
	
	public Products() {
		try {
			//파일이 존재하지 않으면 생성
			if(!file.exists()) {
				makeProducts();
				System.out.println("생성됨");
			}else {
				System.out.println("파일 이미존재함");
			}
			setProducts();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void makeProducts() throws IOException {
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write("test1 100\n");
		fileWriter.write("test2 323\n");
		fileWriter.write("test3 444\n");
		fileWriter.flush();
		fileWriter.close();
	} 
	
	private void setProducts() throws IOException{
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		
		String line ="";
		while((line= br.readLine())!=null) {
			String[] temp = line.split(" ");
			productPrice.put(temp[0],Integer.parseInt(temp[1]));
		}
		System.out.println(productPrice);
		br.close();
		fileReader.close();
	}
	public int getPrice(String productName) {
		
		
		return 0;
	}
	
	public static void main(String[] args) {
		new Products();
		Products s = new Products();
	}
}
