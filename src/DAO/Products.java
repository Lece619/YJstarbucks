package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Products{
	
	private File file = new File("./src/test.txt");
	//��ǰ, ����
	private HashMap<String,Integer> productPrice = new HashMap<>();
	//��ǰ, ���ϰ��
	private TreeMap<String,String> productImage = new TreeMap<>();
	
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
	
	//product �޾ƿ���
	public HashMap<String, Integer> getProductPrice() {
		return productPrice;
	}
	//product - �̹���
	public TreeMap<String, String> getProductImage(){
		return productImage;
	}

	private void makeProducts() throws IOException {
		FileWriter fileWriter = new FileWriter(file);
//		//				��ǰ�̸�\t����\t�̹������\tī�װ�
//		fileWriter.write("test1\t100\tsrc/Imgs/1-01.png\tcoffee\n");
//		fileWriter.write("test2\t323\tsrc/Imgs/1-02.png\n\tcoffee");
//		fileWriter.write("test3	444	src/Imgs/1-03.png\n");
		fileWriter.write(
				"test1	100	src/Imgs/1-01.png	coffee\n" + 
				"test2	323	src/Imgs/1-02.png	coffee\n" + 
				"test3	444	src/Imgs/1-03.png	coffee\n" + 
				"test4	555	src/Imgs/1-04.png	coffee\n" + 
				"test5	555	src/Imgs/1-05.png	coffee\n" + 
				"test6	555	src/Imgs/1-06.png	coffee\n" + 
				"test7	555	src/Imgs/1-07.png	coffee\n" + 
				"test8	555	src/Imgs/1-08.png	coffee\n" + 
				"test9	555	src/Imgs/1-09.png	coffee\n" + 
				"test10	555	src/Imgs/1-10.png	coffee\n" + 
				"test11	555	src/Imgs/1-11.png	coffee\n" + 
				"test12	555	src/Imgs/1-12.png	coffee\n");
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
		br.close();
		fileReader.close();
	}
	
	//�̹��� ���� �޾ƿ���
	public int getPrice(String productName) {
		
		return productPrice.get(productName);
	}

	
	//�̹��� ��� �޾ƿ���
	public String getImg(String productName) {
		return productImage.get(productName);
	}
	

	
	public static void main(String[] args) {
		new Products();
	}
	
}
