package springboot.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class UserDataUtil {
	private static Random rand;
	static{ 
		rand=new Random();
	}
	private UserDataUtil(){};
	/**
	 * ����һ���û�id
	 * <br>���ɹ���
	 * ��ĸ�����ֵĹ̶�5λ��ǰ��λΪСд��ĸ������λΪ����
	 * @param oldUserIds ϵͳ��ԭ�е��û�id�б������ظ�,���Ƽ�ʹ�ã���Ϊarraylist֧�ֵ�����С
	 * @param num Ҫ��ȡ���ٸ��û����
	 * @return
	 */
	public static List<String> getUserName(List<String> oldUserIds,int num){
		List<String> ids=new ArrayList<String>();
		while(ids.size()<num){
			StringBuffer sb=new StringBuffer();
			for(int j=1;j<=8;j++){
				if(j<=5){//ǰ��λ��ȡ��ĸ
					sb.append(getLetter());
				}else{//����λ������
					sb.append(getNum());
				}
			}
			String userName=sb.toString();
			if(oldUserIds.contains(userName)||ids.contains(userName)){
				//�Ѵ��ڣ���������һ��
			}else{
				ids.add(userName);
			}
		}
		return ids;
	}
	
	/**
	 * ����һ������
	 * <br>���ɹ���
	 * ��д��ĸ+Сд��ĸ+����
	 * @param num Ҫ���ɶ��ٸ�����
	 * @param wordNum Ҫ���ɵ����볤���Ƕ���
	 * @return
	 */
	public static List<String> getPasswords(int num,Integer wordNum){
		int total=wordNum;//������λ��
		List<String> passwords=new ArrayList<String>();
		while(passwords.size()<num){
			StringBuffer sb=new StringBuffer();
			int upperNum=getRadomInt(1,total-2);//��д��ĸλ��������������λ��������Сд������
			int lowerNum=getRadomInt(1, total-upperNum-1);//Сд��ĸλ����Ϊ������ȥ��д��ĸռ�õ���������Ϊ��������������1
			int nnum=total-upperNum-lowerNum;//���ʣ�����ֵ�λ����Ϊ������ȥ��д��Сд��ĸλ��֮��ʣ���λ��
			//�����ȡ��ÿ�����͵�λ��index
			Map<Integer,String> indexMap=new HashMap<Integer,String>();
			while(indexMap.size()<upperNum){
				//ȷ����д��ĸ��������
				int rint=getRadomInt(0, total-1);
				if(indexMap.get(rint)==null){
					indexMap.put(rint, "upper");
				}
			}
			while(indexMap.size()<upperNum+lowerNum){
				//ȷ��Сд��ĸ��������
				int rint=getRadomInt(0, total-1);
				if(indexMap.get(rint)==null){
					indexMap.put(rint, "lower");
				}
			}
			while(indexMap.size()<total){
				//ȷ�����ֵ�������
				int rint=getRadomInt(0, total-1);
				if(indexMap.get(rint)==null){
					indexMap.put(rint, "nnum");
				}
			}
			//��װ����
			for(int i=0;i<total;i++){
				if("upper".equals(indexMap.get(i))){
					sb.append(getUpper());
				}else if("lower".equals(indexMap.get(i))){
					sb.append(getLetter());
				}else{
					sb.append(getNum());
				}
			}
			passwords.add(sb.toString());
		}
		return passwords;
	}
	/**
	 * �����ȡһ��Сд��ĸ
	 * @param args
	 */
	public static char getLetter(){
		char c=(char)getRadomInt(97, 122);
		return c;
	}
	
	/**
	 * �����ȡһ����д��ĸ
	 * @param args
	 */
	public static char getUpper(){
		char c=(char)getRadomInt(65, 90);
		return c;
	}
	
	/**
	 * �����ȡһ��0-9������
	 * @return
	 */
	public static int getNum(){
		return getRadomInt(0, 9);
	}
	
	
	/*
	 * �����ȡһ���Ա�
	 * @return
	 */
	public static String getGender() {
		return getRadomInt(0, 1)==0?"formale":"male";
	}
	
	/**
	 * ��ȡһ����Χ�ڵ��������
	 * @return
	 */
	public static int getRadomInt(int min,int max){
		return rand.nextInt(max-min+1)+min;
	}
 
	public static void main(String[] args) {
		int num = 10000000;//100���û���������
		for(int i = 0;i<num;++i) {
			List<String> usrlist=getUserName(new ArrayList(), 1);
			for(String s:usrlist){
				System.out.print("userName:"+s);
			}
			List<String> pwdlist=getPasswords(1,8);
			for(String s:pwdlist){
				System.out.print("    password:"+s);
			}
			System.out.println();
		}
	}
}