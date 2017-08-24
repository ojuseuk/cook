package kosta.jdbc.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import kosta.jdbc.dao.CookDao;
import kosta.jdbc.dao.GuestDao;
import kosta.jdbc.util.PropertiesUtil;


public class TrainService implements Service {
	NodeList nodeList;

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub

	}
	
	public void execute(Scanner sc, int num, String guestId) {
		
		try {
			StringBuilder urlBuilder = new StringBuilder(PropertiesUtil.get("city")); /*URL*/
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + PropertiesUtil.get("servicekey"));/*Service Key*/
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document document = builder.parse(conn.getInputStream());
				Element root = document.getDocumentElement();
				
				nodeList = root.getElementsByTagName("item");
				
				conn.disconnect();
			}
		} catch (UnsupportedEncodingException e) {
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	        
		// guest
		Map<String, String> guestMap = GuestDao.guestCitySearch(guestId);
		String guestState = "";
		String guestCity = "";
		
		Iterator<Entry<String, String>> it = guestMap.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> entry = it.next();
			guestState = entry.getKey();
			guestCity = entry.getValue();
		}
		
//		System.out.println(guestState);
//		System.out.println(guestCity);
		
		// TODO Auto-generated method stub
		String guestStateCode = "";
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE){
				Element element = (Element)node;
				
				Node cityName = element.getElementsByTagName("cityname").item(0);
				
//				System.out.println(guestCity);
//				System.out.println(cityName.getFirstChild().getTextContent());
				
				if (guestState.equals(cityName.getFirstChild().getTextContent())) {
					Node cityC = element.getElementsByTagName("citycode").item(0);
					guestStateCode = cityC.getFirstChild().getTextContent();
//					System.out.println("guestStateCode : " + guestStateCode);
					break;
				}
			}
		}
		
		// cook
		Map<String, String> cookMap = CookDao.cookCitySearch(num);
		String cookState = "";
		String cookCity = "";
		
		Iterator<Entry<String, String>> it2 = cookMap.entrySet().iterator();
		while (it2.hasNext()) {
			Entry<String, String> entry = it2.next();
			cookState = entry.getKey();
			cookCity = entry.getValue();
		}
		
		String cookStateCode = "";
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE){
				Element element = (Element)node;
				
				Node cityName = element.getElementsByTagName("cityname").item(0);
				if (cookState.equals(cityName.getFirstChild().getTextContent())) {
					Node cityC = element.getElementsByTagName("citycode").item(0);
					cookStateCode = cityC.getFirstChild().getTextContent();
					break;
				}
//				System.out.println("cookStateCode" + cookStateCode);
			}
		}
		
//		System.out.println(cookState);
//		System.out.println(cookCity);
		
		// guestCity
		String guestCityCode = "";
		try {
			StringBuilder urlBuilder = new StringBuilder(PropertiesUtil.get("trainstation")); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + PropertiesUtil.get("servicekey")); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("cityCode","UTF-8") + "=" + URLEncoder.encode(guestStateCode, "UTF-8")); /*시/도ID*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        
	        BufferedReader rd;
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		        DocumentBuilder builder = factory.newDocumentBuilder();
		        Document document = builder.parse(conn.getInputStream());
		        Element root = document.getDocumentElement();
		        Element nodeLi=(Element) root.getChildNodes().item(1);
		        
		        NodeList nodeList = root.getElementsByTagName("item");
//		        System.out.println(nodeList.getLength());
		  
				for (int i = 0; i < nodeList.getLength(); i++) {
					Node node = nodeList.item(i);
					if(node.getNodeType() == Node.ELEMENT_NODE){
						Element element = (Element)node;
						
						Node cityName = element.getElementsByTagName("nodename").item(0);
						if (guestCity.equals(cityName.getFirstChild().getTextContent())) {
							Node cityC = element.getElementsByTagName("nodeid").item(0);
							guestCityCode = cityC.getFirstChild().getTextContent();
							break;
						}
					}
				}
//				System.out.println("guestCity" + guestCity);
//				System.out.println("guestCityCode" + guestCityCode);
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
	        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// cookCity
		String cookCityCode = "";
		try {
			StringBuilder urlBuilder = new StringBuilder(PropertiesUtil.get("trainstation")); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + PropertiesUtil.get("servicekey")); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("cityCode","UTF-8") + "=" + URLEncoder.encode(cookStateCode, "UTF-8")); /*시/도ID*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        
	        BufferedReader rd;
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		        DocumentBuilder builder = factory.newDocumentBuilder();
		        Document document = builder.parse(conn.getInputStream());
		        Element root = document.getDocumentElement();
		        Element nodeLi=(Element) root.getChildNodes().item(1);
		        
		        NodeList nodeList = root.getElementsByTagName("item");
//		        System.out.println(nodeList.getLength());
		  
				for (int i = 0; i < nodeList.getLength(); i++) {
					Node node = nodeList.item(i);
					if(node.getNodeType() == Node.ELEMENT_NODE){
						Element element = (Element)node;
						
						Node cityName = element.getElementsByTagName("nodename").item(0);
						if (cookCity.equals(cityName.getFirstChild().getTextContent())) {
							Node cityC = element.getElementsByTagName("nodeid").item(0);
							cookCityCode = cityC.getFirstChild().getTextContent();
							break;
						}
					}
				}
//				System.out.println("cookCity" + cookCity);
//				System.out.println("cookCityCode" + cookCityCode);
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
	        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//
		try {
//        	StringBuilder urlBuilder = new StringBuilder(PropertiesUtil.get("info")); /*URL*/
        	StringBuilder urlBuilder = new StringBuilder(PropertiesUtil.get("info")); /*URL*/
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + PropertiesUtil.get("servicekey"));/*Service Key*/
//			urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));  /*한 페이지 결과 수*/
//			urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));  /*페이지 번호*/
			urlBuilder.append("&" + URLEncoder.encode("depPlaceId","UTF-8") + "=" + URLEncoder.encode(guestCityCode, "UTF-8")); /*출발기차역ID*/
			urlBuilder.append("&" + URLEncoder.encode("arrPlaceId","UTF-8") + "=" + URLEncoder.encode(cookCityCode, "UTF-8"));  /*도착기차역ID*/
			urlBuilder.append("&" + URLEncoder.encode("depPlandTime","UTF-8") + "=" + URLEncoder.encode("20161001", "UTF-8")); /*출발일*/
//			urlBuilder.append("&" + URLEncoder.encode("trainGradeCode","UTF-8") + "=" + URLEncoder.encode("00", "UTF-8")); /*차량종류(KTX,무궁화)*/
			URL url = new URL(urlBuilder.toString());
//			System.out.println(url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
//			System.out.println("Response code: " + conn.getResponseCode());
			BufferedReader rd;
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		        DocumentBuilder builder = factory.newDocumentBuilder();
		        Document document = builder.parse(conn.getInputStream());
		        Element root = document.getDocumentElement();
		        Element nodeLi=(Element) root.getChildNodes().item(1);
		        
		        NodeList nodeList = root.getElementsByTagName("item");
//		        System.out.println(nodeList.getLength());
		  
		        if (nodeList.getLength() == 0) {
		        	System.out.println(guestCity + "역에서 " + cookCity + "역까지 이용할 수 있는 기차가 없습니다");
		        } else {
		        	System.out.println(guestCity + "역에서 " + cookCity + "역까지 다음의 기차를 이용할 수 있습니다");
		        	for (int i = 0; i < nodeList.getLength(); i++) {
		        		Node node = nodeList.item(i);
		        		if(node.getNodeType() == Node.ELEMENT_NODE){
		        			Element element = (Element)node;
		        			
		        			Node train = element.getElementsByTagName("traingradename").item(0);
//						System.out.println(element.getElementsByTagName("cityname").item(0).getTextContent());
		        			System.out.println(train.getFirstChild().getTextContent());
		        		}
		        	}
		        }
		        System.out.println();
//				System.out.println(guestCity + "역에서 " + cookCity + "역까지 다음의 기차를 이용할 수 있습니다");
//				for (int i = 0; i < nodeList.getLength(); i++) {
//					Node node = nodeList.item(i);
//					if(node.getNodeType() == Node.ELEMENT_NODE){
//						Element element = (Element)node;
//						
//						Node train = element.getElementsByTagName("traingradename").item(0);
////						System.out.println(element.getElementsByTagName("cityname").item(0).getTextContent());
//						System.out.println(train.getFirstChild().getTextContent());
//					}
//				}
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
//			StringBuilder sb = new StringBuilder();
//			String line;
//			while ((line = rd.readLine()) != null) {
//				sb.append(line);
//			}
//			rd.close();
			conn.disconnect();
//			System.out.println(sb.toString());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
