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
	//상품, 가격
	private TreeMap<String,Integer> productPrice = new TreeMap<>();
	//상품, 파일경로
	private TreeMap<String,String> productImage = new TreeMap<>();
	//상품, 카테고리
	private TreeMap<String,String> productCategori = new TreeMap<>();
	

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
	public TreeMap<String, Integer> getProductPrice() {
		return productPrice;
	}
	//product - 이미지
	public TreeMap<String, String> getProductImage(){
		return productImage;
	}
	//카테고리 
	public TreeMap<String, String> getProductCategori() {
		return productCategori;
	}

	private void makeProducts() throws IOException {
		FileWriter fileWriter = new FileWriter(file);
//		//				상품이름\t가격\t이미지경로\t카테고리
//		fileWriter.write("test1\t100\tsrc/Imgs/1-01.png\tcoffee\n");
//		fileWriter.write("test2\t323\tsrc/Imgs/1-02.png\n\tcoffee");
//		fileWriter.write("test3	444	src/Imgs/1-03.png\n");
		fileWriter.write(
				"아메리카노	4500	src/Imgs/1-01.png	coffee\r\n" + 
				"바닐라 더블 샷	5100	src/Imgs/1-02.png	coffee\r\n" + 
				"카페 모카	5500	src/Imgs/1-03.png	coffee\r\n" + 
				"카페 라떼	5000	src/Imgs/1-04.png	coffee\r\n" + 
				"돌체 라떼	5900	src/Imgs/1-05.png	coffee\r\n" + 
				"카라멜 마끼아또	5900	src/Imgs/1-06.png	coffee\r\n" + 
				"아메리카노	4500	src/Imgs/1-07.png	coffee\r\n" + 
				"에스프레소 콘파냐	4200	src/Imgs/1-08.png	coffee\r\n" + 
				"초코 라떼	5700	src/Imgs/1-09.png	coffee\r\n" + 
				"카푸치노	5000	src/Imgs/1-10.png	coffee\r\n" + 
				"바닐라 플랫 화이트	5900	src/Imgs/1-11.png	coffee\r\n" + 
				"에스프레소 마끼아또	4000	src/Imgs/1-12.png	coffee\r\n" + 
				"딸기 요거트 블렌디드	6300	src/Imgs/2-01.png	drink\r\n" + 
				"망고 푸르트 블렌디드	5400	src/Imgs/2-02.png	drink\r\n" + 
				"피치 레몬 블렌디드	6300	src/Imgs/2-03.png	drink\r\n" + 
				"블랙 티 레몬 피지오	5400	src/Imgs/2-04.png	drink\r\n" + 
				"쿨라임 피지오	5900	src/Imgs/2-05.png	drink\r\n" + 
				"패션 탱고 피지오	5400	src/Imgs/2-06.png	drink\r\n" + 
				"자몽 허니 블랙티	5700	src/Imgs/2-07.png	drink\r\n" + 
				"유스베리 티	4500	src/Imgs/2-08.png	drink\r\n" + 
				"제주 유기농 녹차	5300	src/Imgs/2-09.png	drink\r\n" + 
				"차이 티 라떼	5500	src/Imgs/2-10.png	drink\r\n" + 
				"돌체 블랙 밀크티	5900	src/Imgs/2-11.png	drink\r\n" + 
				"스팀 우유	4100	src/Imgs/2-12.png	drink\r\n" + 
				"더블 에그 샐러드	6500	src/Imgs/3-01.png	food\r\n" + 
				"콥 화이트 샐러드	6500	src/Imgs/3-02.png	food\r\n" + 
				"루꼴라 샌드위치	5400	src/Imgs/3-03.png	food\r\n" + 
				"잉글리쉬 머핀	4200	src/Imgs/3-04.png	food\r\n" + 
				"클래식 스콘	3300	src/Imgs/3-05.png	food\r\n" + 
				"연유 밀크모닝 빵	4300	src/Imgs/3-06.png	food\r\n" + 
				"단호박 크림 스프	4200	src/Imgs/3-07.png	food\r\n" + 
				"그릭 요거트	4200	src/Imgs/3-08.png	food\r\n" + 
				"우유 푸딩	3300	src/Imgs/3-09.png	food\r\n" + 
				"초코 케이크	5900	src/Imgs/3-10.png	food\r\n" + 
				"티라미수 롤	5900	src/Imgs/3-11.png	food\r\n" + 
				"생크림 카스테라	4500	src/Imgs/3-12.png	food");
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
			productCategori.put(temp[0],temp[3]);
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
	
	//이미지 카테고리 받기
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
