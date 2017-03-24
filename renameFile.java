
public class renameFile {


	public static String interceptName(String cycle_id) {    //处理文件名字符串
		// TODO Auto-generated method stub
		String path = "GPP1101_0110110GJSJ0190052900201509170101103AR5.0.a.out.C.1509.20150917000195";    //获取路径str---牺牲内存提升性能---引用是为了保证文件的一致性
		System.out.println(path);
        /*
         * 修改文件名
		 * (1)获取cycle_ID
		 * (2)处理cycle_ID,切割出三种字段。
		 * (3)替换目标文件字符串
		 */
		String newPath = path.replaceAll("020150917", "0" + cycle_id);//替换第一个字段的数据----特殊处理
		newPath = newPath.replaceAll("C.1509", "C." + cycle_id.substring(2, 6));//替换第二个字段的数据----特殊处理
		newPath = newPath.replaceAll(".201509", "." + cycle_id.substring(0, 6));//替换第三个字段的数据----特殊处理
		System.out.println(newPath);
		System.out.println("文件名修改完成！");
		return newPath;
	}
}
