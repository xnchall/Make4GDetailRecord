package cn.chinaunicom.FrameWork;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import cn.chinaunicom.IO.read4GdetailFile;
import cn.chinaunicom.IO.readFile;
import cn.chinaunicom.IO.writeFile1;


public class BaseFramework extends JFrame {
	
	JTextField str_serial = new JTextField();
	JTextField str_eparchy = new JTextField();
	JTextField str_cycle = new JTextField();
	JTextField str_cust = new JTextField();
	JTextField str_user = new JTextField();
	JTextField str_province = new JTextField();

	public BaseFramework(){
		
		//捕获屏幕的宽度
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		//捕获屏幕的高度
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		
		//设置标题
		this.setTitle("4G数据流量详单生成工具");
		//设置窗体大小
		this.setSize(500,500);
		//设置窗体出现位置
		//this.setLocation((width - 500)/2, (height - 500)/2);
		//将窗体设置为大小不可变
		this.setResizable(false);
		//将窗体的关闭方式设置为默认关闭后程序结束
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//为窗体加入监听器
		//this.add(this);
		//设置窗体出现位置
		this.setBounds((width - 500)/2, (height - 500)/2, 500, 500);
		
		//设置组件的布局
	    JPanel contentPane=new JPanel();
	    contentPane.setBorder(new EmptyBorder(5,5,5,5));
	    this.setContentPane(contentPane);
	    contentPane.setBounds(200, 100, 100, 100);
		
		
	    //用户id
	    JPanel user_id = new JPanel();
	    contentPane.add(user_id);
	    JLabel label5 = new JLabel("user_id：");
	    str_user.setColumns(10);
	    user_id.add(label5);
	    user_id.add(str_user);
	    //电话号码
	    JPanel serial_number = new JPanel();
	    contentPane.add(serial_number);
	    JLabel label1 = new JLabel("serial_number：");
	    str_serial.setColumns(10);
	    serial_number.add(label1);
	    serial_number.add(str_serial);
	    //客户id
	    JPanel cust_id = new JPanel();
	    contentPane.add(cust_id);
	    JLabel label4 = new JLabel("cust_id：");
	    str_cust.setColumns(10);
	    cust_id.add(label4);
	    cust_id.add(str_cust);
	    //归属地
	    JPanel eparchy_code = new JPanel();
	    contentPane.add(eparchy_code);
	    JLabel label2 = new JLabel("eparchy_code：");
	    str_eparchy.setColumns(10);
	    eparchy_code.add(label2);
	    eparchy_code.add(str_eparchy);
	    //账期
	    JPanel cycle_id = new JPanel();
	    contentPane.add(cycle_id);
	    JLabel label3 = new JLabel("cycle_id：");
	    str_cycle.setColumns(10);
	    cycle_id.add(label3);
	    cycle_id.add(str_cycle);
	    //省份编码
	    JPanel province_code = new JPanel();
	    contentPane.add(province_code);
	    JLabel label6 = new JLabel("province_code：");
	    str_province.setColumns(10);
	    province_code.add(label6);
	    province_code.add(str_province);
	    
	    //添加执行按钮
	    JButton bt1 = new JButton("Execute");
	    JPanel p1 = new JPanel();
	    p1.add(bt1);
	    this.add(p1);
	    
	    //software说明
	    
	    
	    //事件注册
	    bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(
						(str_cycle.getText().length() < 8) 
						|| ("".equals(str_cycle.getText()) || str_cycle.getText() == null)
						){
						JOptionPane.showMessageDialog(bt1, "cycle_id字段必须为8位，格式为：YYYYMMDD");
					}
				if("".equals(str_serial.getText()) || str_serial.getText() == null 
						|| "".equals(str_eparchy.getText()) || str_eparchy.getText() == null
						|| "".equals(str_cust.getText()) || str_cust.getText() == null
						|| "".equals(str_user.getText()) || str_user.getText() == null
						|| "".equals(str_province.getText()) || str_province.getText() == null
						){
					//JOptionPane.showInputDialog("请输入这6必填个字段");
					JOptionPane.showMessageDialog(bt1, "请输入必要的信息！");
				}
				else {
					
					// serial_number
					String str_serialNumber = str_serial.getText();
					//System.out.println(str_serialNumber);

					// str_eparchy
					String str_eparchycode = str_eparchy.getText();
					//System.out.println(str_eparchycode);

					// str_eparchy
					String str_custid = str_cust.getText();
					//System.out.println(str_custid);
					
					// str_eparchy
					String str_cycleid = str_cycle.getText();
					//System.out.println(str_cycleid);
					
					// str_eparchy
					String str_userid = str_user.getText();
					//System.out.println(str_userid);
					
					// str_eparchy
					String str_provincecode = str_province.getText();
					//System.out.println(str_provincecode);
					
					readFile.readfile();
					read4GdetailFile.fixStr(
							str_serialNumber, 
							str_cycleid, 
							str_provincecode, 
							str_eparchycode, 
							str_userid, 
							str_custid);
					
					writeFile1.writefile(
							str_serialNumber, 
							str_cycleid, 
							str_provincecode, 
							str_eparchycode, 
							str_userid, 
							str_custid);
					JOptionPane.showMessageDialog(bt1, "4G数据详单已在您的E盘根目录下，请查看！");
				}
			}
		});
	    //将窗体显示出来
	  	this.setVisible(true);
	}

	public static void main(String[] args) {
		new BaseFramework(); 
    }
}	

	

