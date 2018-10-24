package System;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
public class Excellent {
	String str1,str2,str3;
	private JDBCConnection connect=new JDBCConnection();
 	private java.sql.Connection con=null;
 	Excellent(String a,String b,String c){
 		str1=a;
 		str2=b;
 		str3=c;
 	}
 	Excellent(){
		sco();
	}
	public void sco(){
		int i=0;
		double j=0.00;
		double k=0.00;
		double l=0.00;
		double[] a=new double[50];
        double[] b=new double[50];
        double[] c=new double[50];
        String str4,str5,str6;
        try{
           con=connect.getConnection();
   		   Statement stmt=con.createStatement(); 
   		   ResultSet rs=stmt.executeQuery("select* from st ");
			   
			   while(rs.next()){
				    a[i]=Double.valueOf(rs.getString("java").toString()).doubleValue();
				    b[i]=Double.valueOf(rs.getString("math").toString()).doubleValue();
				    c[i]=Double.valueOf(rs.getString("english").toString()).doubleValue();
	    			i=i+1;
			   }
			   for(int j1=0;j1<a.length;j1++){
				   if(a[j1]>=90){
					   j+=1;
				   }
			   }
			   j=j/i;
			   str4="java优秀率："+Double.toString(j);
			   for(int k1=0;k1<b.length;k1++){
				   if(b[k1]>=90){
					   k+=1;
				   }
			   }
			   k=k/i;
			   str5="高数优秀率："+Double.toString(k);
			   for(int l1=0;l1<c.length;l1++){
				   if(c[l1]>=90){
                       l+=1;
				   }
			   }
			   l=l/i;
			   str6="英语优秀率："+Double.toString(l);
			   //创建Inquest类的对象将数组保存，再将该参数作为Show类构造函数的参数
			   Excellent sco=new Excellent(str4,str5,str6);
			   Show3 show=new Show3(sco.str1,sco.str2,sco.str3);
			   show.setVisible(true);
			   
			   
			
        }catch(SQLException e1) {
			System.out.println("SQL Exception occur.Message is；");
			System.out.println(e1.getMessage());
		}finally {
			connect.closeConnection();
		}
        
	}
    public static void  main(String[] args) {
    	Excellent A=new Excellent();
    }
}

