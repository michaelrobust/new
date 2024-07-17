package SmartChange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSystemsOOP {

	boolean loop=true ;
	Scanner scnr=new Scanner(System.in);
	String key="";
	
	// part2 (在每一次都會使用到的變量必須要放在外面才有辦法針對每個操作直接使用)
	String details="--------------零錢通明細-------------";
	
	double money =0;
	double balance=0;
	Date date=null;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd HH:mm");
	
	//part 3 
	
	
	String note="";

	public void mainmenu() {
		do {
			
			System.out.println("\t===============零錢通菜單=============");
			System.out.println("\t\t\t1 零錢通明細");
			System.out.println("\t\t\t2 消費入賬");
			System.out.println("\t\t\t3 消費");
			System.out.println("\t\t\t4 退出");
			
			System.out.println("請選擇1-4");
			key=scnr.next();
		
			switch(key) {
			case"1":
				this.detail();
				break;
			case"2":
				this.income();
			case"3":
				this.pay();
			case"4":
				this.exit();
			default:
				System.out.println("輸入錯誤");
			}
			
			
		}while(loop);
	}
	
	public void detail() {
		System.out.println(details);
	}
	
	public void income() {
		System.out.println("2 消費入賬:");
		money=scnr.nextDouble();
		
		if(money<=0) {//這就是其中一個關卡/ 過了這個關卡才繼續執行下一個代碼, 這樣才好閱讀
			System.out.println("輸入金額錯誤");
			return;//退出方法不再執行要用return而不是break
		}
		balance+=money;
		date =new Date();
		details +="\n\t\t收益入帳\t+"+money+"\t" +sdf.format(date)+ "\t餘額"+balance;
		
		
	}
	
	
	public void pay() {
		System.out.println("3 消費:");
		money=scnr.nextDouble();
		if(money<=0||money>balance) {//這就是其中一個關卡/ 過了這個關卡才繼續執行下一個代碼, 這樣才好閱讀
			System.out.println("輸入消費金額錯誤\t應該在: 0-"+balance);
			return;
		}
		System.out.println("消費說明");
		note=scnr.next();
		balance-=money;
		date =new Date();
		details +="\n\t\t"+"消費說明"+note+"\t-"+money+"\t" +sdf.format(date)+ "\t餘額"+balance;

	}
	
	public void exit() {
		//寫一個死循環
		String choice="";
		while(true) {//如果輸入其他char會一直問要退出嗎
			System.out.println("要退出嗎y/n");
			choice=scnr.next();
			if("y".equals(choice)||"n".equals(choice)) {
				break;	//選t和選n都是退出這個循環
			}
		}
		if(choice.equals("y")) {
			loop=false;//退出所有程序的false
		}
	}
}
