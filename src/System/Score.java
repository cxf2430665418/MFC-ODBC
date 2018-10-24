package System;
import java.sql.*;
public class Score {
	String str1,str2,str3;
	private JDBCConnection connect=new JDBCConnection();
 	private java.sql.Connection con=null;
 	//private ResultSet rs;
 	Score(String a,String b,String c){
 		str1=a;
 		str2=b;
 		str3=c;
 	}
	Score(){
		sco();
	}
	public void sco(){
		int i=0;
		double[] a=new double[50];
        double[] b=new double[50];
        double[] c=new double[50];
        String[] a3=new String[50];
        String[] b3=new String[50];
        String[] c3=new String[50];
        double a1,b1,c1;
        int a2,b2,c2;
        try{
           con=connect.getConnection();
   		   Statement stmt=con.createStatement(); 
   		   ResultSet rs=stmt.executeQuery("select* from st ");
		   
			   
			   while(rs.next()){
				    a[i]=Double.valueOf(rs.getString("java").toString()).doubleValue();
				    a3[i]="java最高分"+rs.getString("id")+"号"+rs.getString("class")+rs.getString("name")+rs.getString("java");
				    b[i]=Double.valueOf(rs.getString("math").toString()).doubleValue();
				    b3[i]="高等数学最高分"+rs.getString("id")+"号"+rs.getString("class")+rs.getString("name")+rs.getString("math");
				    c[i]=Double.valueOf(rs.getString("english").toString()).doubleValue();
				    c3[i]="大学英语最高分"+rs.getString("id")+"号"+rs.getString("class")+rs.getString("name")+rs.getString("english");
	    			i=i+1;
			   }
			   a1=a[0];
			   a2=0;
			   for(int j=0;j<a.length;j++){
				   if(a[j]>=a1){
					   a1 =a[j];
					   a2=j;
				   }
			   }			   
			   b1=b[0];
			   b2=0;
			   for(int j=0;j<b.length;j++){
				   if(b[j]>=b1){
					   b1 =b[j];
					   b2=j;
				   }
			   }
			   c1=c[0];
			   c2=0;
			   for(int j=0;j<c.length;j++){
				   if(c[j]>=c1){
					   c1 =c[j];
					   c2=j;
				   }
			   }
			   //创建Inquest类的对象将数组保存，再将该参数作为Show类构造函数的参数
			   Score sco=new Score(a3[a2],b3[b2],c3[c2]);
			   Show2 show=new Show2(sco.str1,sco.str2,sco.str3);
			   show.setVisible(true);
			   
			   
			
        }catch(SQLException e1) {
			System.out.println("SQL Exception occur.Message is；");
			System.out.println(e1.getMessage());
		}finally {
			connect.closeConnection();
		}
        
	}
    public static void  main(String[] args) {
    	Score A=new Score();
    }
}
