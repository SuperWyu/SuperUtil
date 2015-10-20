package util;

/**
 * KMP�����㷨
 * 
 * @author ����
 * 
 * ʾ��
 * 		String string = "123123321321";
		int index = KMP.serch(string, "33");
		System.out.println(index);
		System.err.println(string.charAt(index)+""+string.charAt(index+1));
 * 
 */
public class KMP {

	/**
	 * 
	 * @param pat
	 *            ���ַ���
	 * @return �������ַ����Ĳ���ƥ��ֵnext[]
	 */
	private static int[] next(String pat) {
		int len = pat.length();
		int j = 0;

		int next[] = new int[len + 1];// next��ʾ����Ϊi���ַ���ǰ׺�ͺ�׺����������֣���1��ʼ
		next[0] = next[1] = 0;

		for (int i = 1; i < len; i++)// i��ʾ�ַ������±꣬��0��ʼ
		{// j��ÿ��ѭ����ʼ����ʾnext[i]��ֵ��ͬʱҲ��ʾ��Ҫ�Ƚϵ���һ��λ��
			while (j > 0 && pat.charAt(i) != pat.charAt(j))
				j = next[j];
			if (pat.charAt(i) == pat.charAt(j))
				j++;
			next[i + 1] = j;
		}
		return next;

	}
	
	/**
	 * 
	 * @param txt ĸ��
	 * @param pat �ִ�
	 * @return �����ִ��״γ��ֵ�λ��
	 */
	public static int serch(String txt,String pat) {
		int[] next = next(pat);
		int i = 0,j = 0;
		int position = -1;
		
		while(true){
			if(j>0 && txt.charAt(i)!=pat.charAt(j)){
				i += j+1 - next[j+1];
				j = next[j];
				continue;
			}
			if(txt.charAt(i) ==pat.charAt(j)){
				j++;
			}
			i++;
			
			if(j == pat.length()){ //ƥ�䵽�������ͬ��
				position = i - j;
				break;
			}
		}
		
		return position;
	}

}
