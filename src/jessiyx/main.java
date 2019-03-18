package jessiyx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class main {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// ��ȡ�ļ�
		String filename = "src/harrypotter.txt";
		FileReader fk = new FileReader(filename);
		BufferedReader br = new BufferedReader(fk);
		// ���б�洢���˺󵥴�
		List<String> ls = new ArrayList<String>();
		String readLine = null;
		while ((readLine = br.readLine()) != null) {
			// ���˳�ֻ������ĸ��
			String[] correctword = readLine.split("[^a-zA-Z]");
			for (String word : correctword) {
				// ȥ������Ϊ0����
				if (word.length() != 0) {
					ls.add(word);
				}
			}
		}
		br.close();
		// �洢���ʼ�����Ϣ��keyֵΪ���ʣ�valueΪ���������Ե��ʵĴ�Ƶͳ��
		Map<String, Integer> wordsCount = new TreeMap<String, Integer>();
		for (String li : ls) {
			if (wordsCount.get(li) != null) {
				wordsCount.put(li, wordsCount.get(li) + 1);
			} else {
				wordsCount.put(li, 1);
			}
		}
		// Map��������(sort by key)
		Map<String, Integer> resMap = sortMapByKey(wordsCount);
		for (Map.Entry<String, Integer> entry : resMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		// ��ʽ
		// for (Map.Entry<String, String> entry : resultMap.entrySet()) {
		// System.out.println(entry.getKey() + " " + entry.getValue()); }
		//
		//
		File file = new File("result.txt");
		try {
			if (file.exists()) {
				file.createNewFile();
			}
			// ��������������·����
			// FileWriter ff = new FileWriter(file.getAbsoluteFile());
			// ����������src��
			FileWriter ff = new FileWriter(file.getCanonicalFile());
			for (Entry<String, Integer> entry : resMap.entrySet()) {
				ff.write(entry.getKey() + "/" + entry.getValue() + "    " + "\n");
			}
			ff.close();
			System.out.println("ͳ�����");
			// System.out.println(file.getAbsoluteFile());
			// System.out.println(file.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("�ܵ�����Ϊ��" + file.length());
		System.out.println("�Ѿ�������е��ʼ���Ƶ��result.txt");
		System.out.println("ѡ�����������˽��");
		System.out.println("1:��������Ҫ��ѯ�ĵ��ʴ�Ƶ:");
		System.out.println("2:�����Ƶ��ߵ�ǰN������:");
		int num = in.nextInt();
		while (num != 0) {
			switch (num) {
			case 1: {
				Find rs = new Find();
				rs.find(wordsCount);
			}

				break;
			case 2: {
				Valuesort rs = new Valuesort();
				rs.valuesort(wordsCount);
			}
				break;

			}
			System.out.println("�ٴ�ѡ����Ҫ�˽�ģ�");
			num = in.nextInt();
			if (num > 2) {
				System.out.println("��������ȷ�������");
			}
		}

	}

	// �� Map��key��������
	public static Map<String, Integer> sortMapByKey(Map<String, Integer> map) {
		if (map == null || map.isEmpty()) {
			return null;
		}
		Map<String, Integer> sortMap = new TreeMap<String, Integer>(new MapKeyComparator());
		sortMap.putAll(map);
		return sortMap;

	}
	private void sort(Map<String, Integer> map, int i) {
		// TODO Auto-generated method stub
	}

}
//ʵ��һ���Ƚ�����

class MapKeyComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		return s1.compareTo(s2); // ��С��������
		//������õĵ��ʼ���Ӧ�Ĵ�Ƶ�ŵ��ļ���

    
}	
}