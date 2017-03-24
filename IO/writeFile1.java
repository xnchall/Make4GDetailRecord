

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/*
	 * 实现readFile基类，只存在一个读取文件的方法，没有字段等。
	 * 只实现对4G数据详单的读取
	 * 并将详单读取到内存当中，为详单处理做准备。
*/

public class readFile {
	
	public static String readfile() {
		readFile rd = new readFile();
		InputStream is = rd.getClass().getResourceAsStream("/GPP2100_gpp.1.C.1603.20160318000042");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		//InputStream is = null;
		String info = null;
		try{
			//is = new FileInputStream(src);
			//byte[] car = new byte[2048];     //需要优化
			//int length = 0;
			info = br.readLine();
			System.out.println(info);             //测试文件读取，是否成功！
			System.out.println("详单文件读取成功！");
		} catch(FileNotFoundException e){
			e.printStackTrace();
			System.out.println("4G数据详单模板文件不存在！");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("读取文件失败！");
		}finally{
			if(is != null){
				try {
					is.close();
					br.close();
					System.out.println("关闭文件输入流成功！");
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("关闭文件输入流失败！");
				}
			}
		}
		return info;
	}
	
	public static void main(String args[]) {
		readfile();
	}
}
