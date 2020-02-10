import java.sql.*;
public class Procedure{
	public static void main(String a[]) throws Exception{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@172.16.100.13:1521:orcl","p18103","pass321");
			System.out.println(con);
			if(con!=null)
				System.out.println("successfully connected.......");
			else 
				System.out.println("connection is not given.......");			
			Statement st=con.createStatement();
			/*st.execute("create table employee(ID varchar2(20),NAME varchar(20),SALARY number(20))");
			st.execute("insert into employee values('20aug','sudhir',5000)");
			st.execute("insert into employee values('21sep','av',9000)");*/
			ResultSet rs=st.executeQuery("select * from employee");
			while(rs.next()){
				System.out.println(rs.getString(1)+""+rs.getString(3));
				//System.out.println("salary greater than 1000 and lessthan 2000");
			}
			st.execute("insert into employee values('20aug','sudhir',5000)");
			st.execute("insert into employee values('21sep','av',9000)");
			st.execute("insert into employee values('23jan','sudhersan',1020)");
			st.execute("insert into employee values('21','av',1080)");
			ResultSet rs1=st.executeQuery("select * from employee where SALARY>1000 and SALARY<2000");
				while(rs1.next()){
					System.out.println(rs1.getString(1)+""+rs1.getString(2)+""+rs1.getString(3));
					rs.close();
					st.close();
					con.close();
			}
		}catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
	}
}

