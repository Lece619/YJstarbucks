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
	//��ǰ, ����
	private HashMap<String,Integer> productPrice = new HashMap<>();
	//��ǰ, ���ϰ��
	private HashMap<String,String> productImage = new HashMap<>();
	
	public Products() {
		try {
			//������ �������� ������ ����
			if(!file.exists()) {
				makeProducts();
				System.out.println("������");
			}else {
				System.out.println("���� �̹�������");
			}
			setProducts();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void makeProducts() throws IOException {
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write("test1	100	sdf\n");
		fileWriter.write("test2	323	sdf\n");
		fileWriter.write("test3	444	ads\n");
		fileWriter.flush();
		fileWriter.close();
	} 
	
	private void setProducts() throws IOException{
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		
		String line ="";
		while((line= br.readLine())!=null) {
			//������ ����
			String[] temp = line.split("\t");
			productPrice.put(temp[0],Integer.parseInt(temp[1]));
			productImage.put(temp[0],temp[2]);
		}
		System.out.println("�޴�- ����");
		System.out.println(productPrice);
		System.out.println("�޴�- �̹��� ���");
		System.out.println(productImage);
		br.close();
		fileReader.close();
	}
	public int getPrice(String productName) {
		
		return productPrice.get(productName);
	}
	
	public static void main(String[] args) {
		new Products();
	}
}
