
import cn.***.utils.*;

/*
 	* 继承readFile类
 	* 处理readFile.readfile()读取的字符串。info
 	* 这里处理主要是对字符串的截取。
*/
public class read4GdetailFile extends readFile{
	/*
	 * 标记详单中特殊元素(6个)，为数据替换做准备。
	 * 还有一个是特殊原因是“0”，依靠“0”前一个元素来替换它。
	 */
	private static  String serial_Number = "18645137085";
	private static  String Cycle_ID = "20160308";
	private static String province = "0531";
	private static  String attribution = "97";
	private static String user_ID = "9714110125559793";
	private static String acct_ID = "9714110126390657";
	private static String beforeFee = "150";//为了替换fee字段的数据，因为模板详单“0”元素不止一个
	
	/*
	 * 截取读取的文件str.split(",")------以“,”作为分隔符（特殊字符）
	 */
	public static String[] interceptStr() { //intercept:截取
		String[] interStr = readfile().split(",",-1);
		for(String value : interStr){   //测试字符串截取是否成功
			System.out.println(value);
		}
		System.out.println("原始文件读入后截取成功！已存入字符串数组！");
		return interStr;
	}
	/*
	 * fixStr拼接字符串
	 * 根据从书库获得的6个字段的数据，根据特殊数组元素的位置进行替换---->因此这里参数只有6个
	 * attribution归属地
	 */
	public static String[] fixStr(String serialNumber1
								,String Cycle_ID1
								,String province1
								,String attribution1
								,String user_ID1
								,String acct_ID1) {
		
		String[] receivedStr = interceptStr(); //需要验证返回值的事情，到底需不需要开辟新空间。
		/*
		 * 替换serialNumber
		 */
		
		for(int i = 0; i < receivedStr.length; i++){
			if(receivedStr[i].equals(serial_Number)){
				receivedStr[i] = serialNumber1;			
			}		
		}
		
		/*
		 * 替换Cycle_ID
		 */
		for(int i = 0; i < receivedStr.length; i++){
			if(receivedStr[i].equals(Cycle_ID)){
				receivedStr[i] = Cycle_ID1;
			}		
		}
		
		/*
		 * 替换province
		 */
		for(int i = 0; i < receivedStr.length; i++){
			if(receivedStr[i].equals(province)){
				receivedStr[i] = province1;
			}
		}
		
		/*
		 * 替换attribution
		 */
		for(int i = 0; i < receivedStr.length; i++){
			if(receivedStr[i].equals(attribution)){
				receivedStr[i] = attribution1;
			}
		}
		
		/*
		 * 替换user_ID
		 */
		for(int i = 0; i < receivedStr.length; i++){
			if(receivedStr[i].equals(user_ID)){
				receivedStr[i] = user_ID1;
			}
		}
		
		/*
		 * 替换acct_ID
		 */
		for(int i = 0; i < receivedStr.length; i++){
			if(receivedStr[i].equals(acct_ID)){
				receivedStr[i] = acct_ID1;
			}
		}
		
		/*
		 * 替换fee
		 */
		for(int i = 0; i < receivedStr.length; i++){
			if(receivedStr[i].equals(beforeFee)){
				receivedStr[i+1] = randomNumber.randomFun(); //特殊处理
			}
		}
		
		System.out.println("详单数据替换完成！");
		return receivedStr;
	}
}
