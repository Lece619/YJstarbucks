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
	//상품, 가격
	private HashMap<String,Integer> productPrice = new HashMap<>();
	//상품, 파일경로
	private HashMap<String,String> productImage = new HashMap<>();
	
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
	
	//product 받아오기
	public HashMap<String, Integer> getProductPrice() {
		return productPrice;
	}
	//product - 이미지
	public HashMap<String, String> getProductImage(){
		return productImage;
	}

	private void makeProducts() throws IOException {
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write("test1	100	src/Imgs/1-01.png\n");
		fileWriter.write("test2	323	src/Imgs/1-02.png\n");
		fileWriter.write("test3	444	src/Imgs/1-03.png\n");
		fileWriter.flush();
		fileWriter.close();
	} 
	
	private void setProducts() throws IOException{
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		
		String line ="";
		while((line= br.readLine())!=null) {
			//탭으로 구분
			String[] temp = line.split("\t");
			productPrice.put(temp[0],Integer.parseInt(temp[1]));
			productImage.put(temp[0],temp[2]);
		}
		br.close();
		fileReader.close();
	}
	
	//이미지 가격 받아오기
	public int getPrice(String productName) {
		
		return productPrice.get(productName);
	}

	
	//이미지 경로 받아오기
	public String getImg(String productName) {
		return productImage.get(productName);
	}
	

	
	public static void main(String[] args) {
		new Products();
	}
	
}
