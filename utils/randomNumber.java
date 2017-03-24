package cn.*****.utils;

import java.util.Random;

/*
 * 随机数生成
 * 1.在4G数据详单中需要生成fee字段
 */
public class randomNumber {
/*
 * 随机数的范围是0-5000
 */
	public static String randomFun() {
		String strFee = null;
		Random r = new Random();
		/*for (int i = 0; i < 1; i++) {s
			System.out.println(Math.abs(r.nextInt())%500);
		}*/
		strFee = String.valueOf(Math.abs(r.nextInt())%5000);
		return strFee;
	}
}
