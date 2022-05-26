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
	
	private File file = new File("./src/products.txt");
	//��ǰ, ����
	private TreeMap<String,Integer> productPrice = new TreeMap<>();
	//��ǰ, ���ϰ��
	private TreeMap<String,String> productImage = new TreeMap<>();
	//��ǰ, ī�װ�
	private TreeMap<String,String> productCategori = new TreeMap<>();
	

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
	public TreeMap<String, Integer> getProductPrice() {
		return productPrice;
	}
	//product - �̹���
	public TreeMap<String, String> getProductImage(){
		return productImage;
	}
	//ī�װ� 
	public TreeMap<String, String> getProductCategori() {
		return productCategori;
	}

	private void makeProducts() throws IOException {
		FileWriter fileWriter = new FileWriter(file);
//		//				��ǰ�̸�\t����\t�̹������\tī�װ�
//		fileWriter.write("test1\t100\tsrc/Imgs/1-01.png\tcoffee\n");
//		fileWriter.write("test2\t323\tsrc/Imgs/1-02.png\n\tcoffee");
//		fileWriter.write("test3	444	src/Imgs/1-03.png\n");
		fileWriter.write(
				"�Ƹ޸�ī��	4500	src/Imgs/1-01.png	coffee\r\n" + 
				"�ٴҶ� ���� ��	5100	src/Imgs/1-02.png	coffee\r\n" + 
				"ī�� ��ī	5500	src/Imgs/1-03.png	coffee\r\n" + 
				"ī�� ��	5000	src/Imgs/1-04.png	coffee\r\n" + 
				"��ü ��	5900	src/Imgs/1-05.png	coffee\r\n" + 
				"ī��� �����ƶ�	5900	src/Imgs/1-06.png	coffee\r\n" + 
				"�Ƹ޸�ī��	4500	src/Imgs/1-07.png	coffee\r\n" + 
				"���������� ���ĳ�	4200	src/Imgs/1-08.png	coffee\r\n" + 
				"���� ��	5700	src/Imgs/1-09.png	coffee\r\n" + 
				"īǪġ��	5000	src/Imgs/1-10.png	coffee\r\n" + 
				"�ٴҶ� �÷� ȭ��Ʈ	5900	src/Imgs/1-11.png	coffee\r\n" + 
				"���������� �����ƶ�	4000	src/Imgs/1-12.png	coffee\r\n" + 
				"���� ���Ʈ �����	6300	src/Imgs/2-01.png	drink\r\n" + 
				"���� Ǫ��Ʈ �����	5400	src/Imgs/2-02.png	drink\r\n" + 
				"��ġ ���� �����	6300	src/Imgs/2-03.png	drink\r\n" + 
				"�� Ƽ ���� ������	5400	src/Imgs/2-04.png	drink\r\n" + 
				"����� ������	5900	src/Imgs/2-05.png	drink\r\n" + 
				"�м� �ʰ� ������	5400	src/Imgs/2-06.png	drink\r\n" + 
				"�ڸ� ��� ��Ƽ	5700	src/Imgs/2-07.png	drink\r\n" + 
				"�������� Ƽ	4500	src/Imgs/2-08.png	drink\r\n" + 
				"���� ����� ����	5300	src/Imgs/2-09.png	drink\r\n" + 
				"���� Ƽ ��	5500	src/Imgs/2-10.png	drink\r\n" + 
				"��ü �� ��ũƼ	5900	src/Imgs/2-11.png	drink\r\n" + 
				"���� ����	4100	src/Imgs/2-12.png	drink\r\n" + 
				"���� ���� ������	6500	src/Imgs/3-01.png	food\r\n" + 
				"�� ȭ��Ʈ ������	6500	src/Imgs/3-02.png	food\r\n" + 
				"��ö� ������ġ	5400	src/Imgs/3-03.png	food\r\n" + 
				"�ױ۸��� ����	4200	src/Imgs/3-04.png	food\r\n" + 
				"Ŭ���� ����	3300	src/Imgs/3-05.png	food\r\n" + 
				"���� ��ũ��� ��	4300	src/Imgs/3-06.png	food\r\n" + 
				"��ȣ�� ũ�� ����	4200	src/Imgs/3-07.png	food\r\n" + 
				"�׸� ���Ʈ	4200	src/Imgs/3-08.png	food\r\n" + 
				"���� Ǫ��	3300	src/Imgs/3-09.png	food\r\n" + 
				"���� ����ũ	5900	src/Imgs/3-10.png	food\r\n" + 
				"Ƽ��̼� ��	5900	src/Imgs/3-11.png	food\r\n" + 
				"��ũ�� ī���׶�	4500	src/Imgs/3-12.png	food");
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
			productCategori.put(temp[0],temp[3]);
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
	
	//�̹��� ī�װ� �ޱ�
	public String getCategori(String productName) {
		return productCategori.get(productName);
	}
	
	public static void main(String[] args) {
		Products product = new Products();
		System.out.println(product.getProductPrice());
		System.out.println(product.getProductImage());
		System.out.println(product.getProductCategori());
	}
}
