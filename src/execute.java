import java.io.IOException;
import java.util.Arrays;

public class execute {
	String[] subjects={"����", "��������a", "��������b", "������", "���� a", "���� b", "���", "����a", "����b", "����c", "����d", "���Ƹ�",
			"������ ����", "����", "��ȸ��ȭ", "������н���", "��Ȱ�� ����A", "��Ȱ�� ����B", "������", "�ǿ뱹��", "����", "����",
			"�������н���", "����", "âü", "�ѱ���", "�ѱ�����", "ȭ���� �۹�", "ȭ�н���"};
	public void exe(String subject) {
		int index = Arrays.binarySearch(subjects, subject);
		Runtime runtime = Runtime.getRuntime();
		Runtime runtime2 = Runtime.getRuntime();
		String name = System.getProperty("user.name");
		switch (index) {
		case 1 : //��������a
			
			break;
		case 2 : //��������b
			
			break;
		case 3 : //������
			try {
				runtime2.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe https://hoc7.ebssw.kr/sindomath3i/hmpg/hmpgAlctcrListView.do?menuSn=281311");
			}catch(IOException ex){}
			break;
		case 4 : //���� a
			try {
				runtime2.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe https://hoc7.ebssw.kr/3mathgeo/hmpg/hmpgAlctcrListView.do?menuSn=280174");
			}catch(IOException ex){}
			break;
		case 5 : //���� b
			try {
				runtime.exec("C:/Program Files/Internet Explorer/iexplore.exe https://teams.microsoft.com/l/team/19%3a4f85dee4fb3f4e87bfa03c0c7dc83ab9%40thread.tacv2/conversations?groupId=32aa9ac2-4050-4958-a00b-895f857f5e1f&tenantId=fe2ed411-37b2-4329-8402-9da0a5aa564e");
				try {Thread.sleep(5000);} catch(Exception et) {}
				runtime.exec("taskkill /f /im iexplore.exe /t");
			}catch(IOException ex){}
			break;
		case 6 : //���
			try {
				runtime2.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe https://hoc7.ebssw.kr/3mathgeo/hmpg/hmpgAlctcrListView.do?menuSn=280174");
			}catch(IOException ex){}
			break;
		case 7 : //����a
			try {
				runtime2.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe https://hoc7.ebssw.kr/sindokorean3andgrade/hmpg/hmpgAlctcrListView.do?menuSn=281183");
			}catch(IOException ex){}
			break;
		case 8 : //����b
			try {
				runtime2.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe https://hoc7.ebssw.kr/sindokorean3andgrade/hmpg/hmpgAlctcrListView.do?menuSn=281183");
			}catch(IOException ex){}
			break;
		case 9 : //����c
			try {
				runtime2.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe https://hoc7.ebssw.kr/sindokorean3andgrade/hmpg/hmpgAlctcrListView.do?menuSn=281183");
			}catch(IOException ex){}
			break;
		case 10 : //����d
			try {
				runtime2.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe https://hoc7.ebssw.kr/sindokorean3andgrade/hmpg/hmpgAlctcrListView.do?menuSn=281183");
			}catch(IOException ex){}
			break;
		case 11 : //���Ƹ�
			try {
				runtime2.exec("C:\\Users\\" + name +"\\AppData\\Local\\Microsoft\\Teams\\current\\Teams.exe");
			}catch(IOException ex){}
			break;
		case 12 : //������ ����
			try {
				runtime2.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe https://hoc7.ebssw.kr/songseungbin/hmpg/hmpgAlctcrListView.do?menuSn=271888");
			}catch(IOException ex){}
			break;
		case 13 : //����
			try {
				runtime2.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe https://hoc7.ebssw.kr/sindo2020/hmpg/hmpgAlctcrListView.do?menuSn=378891");
			}catch(IOException ex){}
			break;
		case 14 : //��ȸ��ȭ
			try {
				runtime2.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe https://hoc7.ebssw.kr/socul3/hmpg/hmpgAlctcrListView.do?menuSn=256400");
			}catch(IOException ex){}
			break;
		case 15 : //������н���
			try {
				runtime2.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe https://hoc7.ebssw.kr/lifescienceshindo/hmpg/hmpgAlctcrListView.do?menuSn=283339");
			}catch(IOException ex){}
			break;
		case 16 : //��Ȱ�� ����A
			try {
				runtime2.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe https://hoc7.ebssw.kr/sindo3ethics/hmpg/hmpgAlctcrListView.do?menuSn=281477");
			}catch(IOException ex){}
			break;
		case 17 : //��Ȱ�� ����B
			try {
				runtime2.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe https://hoc7.ebssw.kr/sindo3ethics/hmpg/hmpgAlctcrListView.do?menuSn=281477");
			}catch(IOException ex){}
			break;
		case 18 : //������
			try {
				runtime2.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe https://hoc7.ebssw.kr/sindo2020/hmpg/hmpgAlctcrListView.do?menuSn=378891");
			}catch(IOException ex){}
			break;
		case 19 : //�ǿ뱹��
			try {
				runtime2.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe https://hoc7.ebssw.kr/sindokorean3andgrade/hmpg/hmpgAlctcrListView.do?menuSn=281183");
			}catch(IOException ex){}
			break;
		case 20 : //3�г� ����
			try {
				runtime.exec("C:/Program Files/Internet Explorer/iexplore.exe https://teams.microsoft.com/l/channel/19%3a95ef914110da4505919c9365c3370145%40thread.tacv2/%25EC%259D%25BC%25EB%25B0%2598?groupId=d986adb5-f504-4c2c-bd5e-83a55c4b5a3c&tenantId=fe2ed411-37b2-4329-8402-9da0a5aa564e");
				runtime2.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe https://hoc7.ebssw.kr/shindo1/hmpg/hmpgAlctcrListView.do?menuSn=274651");
				try {Thread.sleep(5000);} catch(Exception et) {}
				runtime.exec("taskkill /f /im iexplore.exe /t");
			}catch(IOException ex){}
			break;
		case 21 : //����
			try {
				runtime2.exec("C:\\Users\\" + name +"\\AppData\\Local\\Microsoft\\Teams\\current\\Teams.exe");
			}catch(IOException ex){}
			break;
		case 22 : //�������н���
			try {
				runtime2.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe https://hoc7.ebssw.kr/earthscience12020/hmpg/hmpgAlctcrListView.do?menuSn=281030");
			}catch(IOException ex){}
			break;
		case 23 : //����
			try {
				runtime2.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe https://hoc7.ebssw.kr/jin11/hmpg/hmpgAlctcrListView.do?menuSn=341500");
			}catch(IOException ex){}
			break;
		case 24 : //âü
			try {
				runtime2.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe https://hoc7.ebssw.kr/shindo20/hmpg/hmpgAlctcrListView.do?menuSn=388534");
			}catch(IOException ex){}
			break;
		case 25 : //�ѱ���
			try {
				runtime.exec("C:/Program Files/Internet Explorer/iexplore.exe https://teams.microsoft.com/l/team/19%3a65467d63827b4c1d9044f5fe8bf86133%40thread.tacv2/conversations?groupId=e7a3163f-f41f-4936-863b-5602201ebbf2&tenantId=fe2ed411-37b2-4329-8402-9da0a5aa564e");
				runtime2.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe https://hoc7.ebssw.kr/koreahistory3/hmpg/hmpgAlctcrListView.do?menuSn=281092");
				try {Thread.sleep(5000);} catch(Exception et) {}
				runtime.exec("taskkill /f /im iexplore.exe /t");
			}catch(IOException ex){}
			break;
		case 26 : //�ѱ�����
			
			break;
		case 27 : //ȭ���� �۹�
			try {
				runtime2.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe https://hoc7.ebssw.kr/sindokorean3andgrade/hmpg/hmpgAlctcrListView.do?menuSn=281183");
			}catch(IOException ex){}
			break;
		case 28 : //ȭ�н���
			try {
				runtime.exec("C:/Program Files/Internet Explorer/iexplore.exe http://teams.microsoft.com/l/team/19%3afea9f423822e4317bb964476577a8881%40thread.tacv2/conversations?groupId=22266739-b933-49fa-bee3-86933e81f47b&tenantId=fe2ed411-37b2-4329-8402-9da0a5aa564e");
				runtime2.exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe https://hoc7.ebssw.kr/wjddnrah337/hmpg/hmpgAlctcrListView.do?menuSn=282151");
				try {Thread.sleep(5000);} catch(Exception et) {}
				runtime.exec("taskkill /f /im iexplore.exe /t");
			}catch(IOException ex){}
			break;
			
		}
	}
}
