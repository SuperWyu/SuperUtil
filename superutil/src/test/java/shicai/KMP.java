package util;

/**
 * KMP查找算法
 * 
 * @author 世财
 * 
 * 示例
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
	 *            子字符串
	 * @return 返回子字符串的部分匹配值next[]
	 */
	private static int[] next(String pat) {
		int len = pat.length();
		int j = 0;

		int next[] = new int[len + 1];// next表示长度为i的字符串前缀和后缀的最长公共部分，从1开始
		next[0] = next[1] = 0;

		for (int i = 1; i < len; i++)// i表示字符串的下标，从0开始
		{// j在每次循环开始都表示next[i]的值，同时也表示需要比较的下一个位置
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
	 * @param txt 母串
	 * @param pat 字串
	 * @return 返回字串首次出现的位置
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
			
			if(j == pat.length()){ //匹配到最后都是相同的
				position = i - j;
				break;
			}
		}
		
		return position;
	}

}
