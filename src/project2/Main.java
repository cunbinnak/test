package project2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class Main {
	static Connection connection = null;
    static Statement statement = null;
    
    
	public static void Tim_theo_ten_hangSX(String name) {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhathuoc", "root", "dotv");
            
            //query
            CallableStatement callable = connection.prepareCall("{call tim_theo_ten_hangsx (?)}");
            callable.setString(1, name);           
            ResultSet resultSet = callable.executeQuery();
            System.out.println("thông tin hãng sản xuất có tên  "+name+" là");
            System.out.println("| mã | tên | quốc gia | sdt |");
            System.out.println("================================"); 
            while (resultSet.next()) {
            	int ma = resultSet.getInt(1);
            	String ten =resultSet.getString(2);
            	String quocgia =resultSet.getString(3);
            	String sdt =resultSet.getString(4);
            	System.out.println(
                        "| " + ma + " | " + ten + " | " + quocgia + " |"+sdt+" | ");
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
        
    }
	
	public static void Tim_theo_ten_thuoc(String name) {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhathuoc", "root", "dotv");
            
            //query
            CallableStatement callable = connection.prepareCall("{call tim_theo_ten_thuoc (?)}");
            callable.setString(1, name);           
            ResultSet resultSet = callable.executeQuery();
            System.out.println("thông tin thuốc có tên  "+name+" là");
            System.out.println("| mã | tên | mã nhà cung cấp | mã hãng sản xuất | công dụng | mã loại | giá | số lượng tồn |");
            System.out.println("================================"); 
            while (resultSet.next()) {
            	int ma = resultSet.getInt(1);
            	String ten =resultSet.getString(2);
            	int mancc =resultSet.getInt(3);
            	int mahsx =resultSet.getInt(4);
            	String congdung = resultSet.getString(5);
            	int maloai = resultSet.getInt(6);
            	float gia = resultSet.getFloat(7);
            	int soluongton = resultSet.getInt(8);
            	System.out.println(
                        "| " + ma + " | " + ten + " | " + mancc + " |"+mahsx+" | "+congdung+" | "+maloai+" | "+gia+" | "+soluongton+" | ");
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
        
    }
	
	public static void Tim_theo_ten_nhan_vien(String name) {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhathuoc", "root", "dotv");
            
            //query
            CallableStatement callable = connection.prepareCall("{call tim_theo_ten_nhanvien (?)}");
            callable.setString(1, name);           
            ResultSet resultSet = callable.executeQuery();
            System.out.println("thông tin nhân viên có tên  "+name+" là");
            System.out.println("| mã | tên | ngày sinh | địa chỉ | số điện thoại | lương |");
            System.out.println("================================"); 
            while (resultSet.next()) {
            	int ma = resultSet.getInt(1);
            	String ten =resultSet.getString(2);
            	String ngaysinh =resultSet.getString(3);
            	String diachi =resultSet.getString(4);
            	String sdt = resultSet.getString(5);
            	float luong = resultSet.getFloat(6);
            	System.out.println(
                        "| " + ma + " | " + ten + " | " + ngaysinh + " |"+diachi+" | "+sdt+" | "+luong+" | ");
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
        
    }
	// tổng tiền đã bán của nhân viên trong ngày bất kỳ
	public static void Tong_tien_nv(String name,String date) {
		
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhathuoc", "root", "dotv");
            
            //query
            String sql ="select sum(soLuong*gia) from hoadonbanchitiet where maHoaDon in";
            sql+= " (select maHoaDon from hoadonban where ngayBan  like '"+date+"%'";
            sql+="and maNhanVien = (select maNhanVien from nhanvien where tenNhanVien ='"+name+"'))";
             statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("tổng tiền nhân viên "+name+"bán trong ngày "+date+" là ");
            System.out.println("| tổng tiền |");
            System.out.println("================================"); 
            while (resultSet.next()) {
            	float tong = resultSet.getFloat(1);
            	System.out.println(
                        "| " + tong + " | ");
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
	}
	
	// tổng tiền nhà cung cấp bất kỳ
	public static void Tong_tien_nhacungcap(String name) {
		
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhathuoc", "root", "dotv");
            
            //query
            String sql ="select sum( soLuong* gia) from hoadonnhapchitiet where maHoaDon in";
            sql+= "(select maHoaDon from hoadonnhap where maNhaCungCap  = ";
            sql+="( select maNhaCungCap from nhacungcap where tenNhaCungCap = '"+name+"'))";
            
             statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("tổng tiền đã bán của nhà cung cấp "+name+" là ");
            System.out.println("| tổng tiền |");
            System.out.println("================================"); 
            while (resultSet.next()) {
            	float tong = resultSet.getFloat(1);
            	System.out.println(
                        "| " + tong + " | ");
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
	}
	// thông tin khách hàng đến mua 1 ngày bất kỳ
	public static void Thong_tin(String date) {
		
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhathuoc", "root", "dotv");
            
            //query
            String sql ="select * from khachhang where maKhachHang in";
            sql+= "(select maKhachHang from hoadonban where ngayBan like '"+date+"%')";

            
             statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("thông tin khách hàng đến mua vào ngày "+date+" là ");
            System.out.println("| mã khách hàng || tên khách hàng || địa chỉ || số điện thoại |");
            System.out.println("================================"); 
            while (resultSet.next()) {
            	int ma = resultSet.getInt(1);
            	String ten = resultSet.getString(2);
            	String diachi = resultSet.getString(3);
            	String sdt = resultSet.getString(4);
            	System.out.println(
                        "| " + ma + " | "+ ten + " | "+ diachi + " | "+ sdt + " | ");
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
	}
	
	// hiển thi tổng tiền từng sản phẩm đã bán theo tháng, năm này
	
	public static void tong_tien_ban_theo_thang(String thang,String nam) {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhathuoc", "root", "dotv");
            
            //query
            CallableStatement callable = connection.prepareCall("{call totalOfEachProduct (?, ?)}");
            callable.setString(1, thang);
            callable.setString(2, nam);
            ResultSet resultSet = callable.executeQuery();
            System.out.println("tổng tiền đã bán theo tháng  "+thang+" theo năm "+nam+" là");
            System.out.println("| mã | tên | tổng tiền |");
            System.out.println("================================"); 
            while (resultSet.next()) {
            	int ma = resultSet.getInt(1);
            	String ten =resultSet.getString(2);
            	float tong =resultSet.getFloat(3);
            	
            	System.out.println(
                        "| " + ma + " | " + ten + " | " + tong + " |");
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
        
    }
	
	// hiển thị tổng tiền từng sản phẩm nhập theo tháng, năm
	
	public static void tong_tien_nhap_theo_thang(String thang,String nam) {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhathuoc", "root", "dotv");
            
            //query
            CallableStatement callable = connection.prepareCall("{call totalOfImportEachProduct (?, ?)}");
            callable.setString(1, thang);
            callable.setString(2, nam);
            ResultSet resultSet = callable.executeQuery();
            System.out.println("tổng tiền đã nhập theo tháng  "+thang+" theo năm "+nam+" là");
            System.out.println("| mã | tên | tổng tiền |");
            System.out.println("================================"); 
            while (resultSet.next()) {
            	int ma = resultSet.getInt(1);
            	String ten =resultSet.getString(2);
            	float tong =resultSet.getFloat(3);
            	
            	System.out.println(
                        "| " + ma + " | " + ten + " | " + tong + " |");
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
        
    }
	//  tổng tiền đã bán theo từng loại thuốc
	public static void Tong_tien_theo_tung_loai() {
		
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhathuoc", "root", "dotv");
            
            //query
            String sql ="select maLoai, tenLoai, totalOfCategory(maLoai) from loaithuoc";

            
             statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("tổng tiền đã bán của từng loại thuốc ");
            System.out.println("| mã  || tên  || tổng tiền |");
            System.out.println("================================"); 
            while (resultSet.next()) {
            	int ma = resultSet.getInt(1);
            	String ten = resultSet.getString(2);
            	float tong = resultSet.getFloat(3);
            	
            	System.out.println(
                        "| " + ma + " | "+ ten + " | "+ tong + " | ");
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
	}
	
	// tổng lợi nhuận trong năm của từng loại thuốc
	
	public static void tong_loi_nhuan(String nam) {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhathuoc", "root", "dotv");
            
            //query
            CallableStatement callable = connection.prepareCall("{call benefitInYear (?)}");
            callable.setString(1, nam);

            ResultSet resultSet = callable.executeQuery();
            System.out.println("lợi nhuận từng sản phẩm trong năm "+nam+" là");
            System.out.println("| mã || tên || giá nhập || giá bán || số lượng bán ra || tổng tiền mua vào || tổng tiền bán ra || lợi nhuận |");
            System.out.println("================================"); 
            while (resultSet.next()) {
            	int ma = resultSet.getInt(1);
            	String ten =resultSet.getString(2);
            	float tiennhap =resultSet.getFloat(3);
            	float tienban =resultSet.getFloat(4);
            	int slban =resultSet.getInt(5);
            	float tongmua =resultSet.getFloat(6);
            	float tongban =resultSet.getFloat(7);
            	float loinhuan =resultSet.getFloat(8);
            	
            	System.out.println(
                        "| " + ma + " | " + ten + " | " + tiennhap + " |"+ tienban + " |"+ slban + " |"+ tongmua + " |"+ tongban + " |"+loinhuan+" |");
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
        
    }
	// doanh số bán hàng theo  tháng vào lương thưởng thêm (5% doanh số tháng) cuẩ từng nhân viên theo tháng
	public static void doanh_so(String thang) {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhathuoc", "root", "dotv");
            
            //query
            CallableStatement callable = connection.prepareCall("{call monthlySalesIndex (?)}");
            callable.setString(1, thang);

            ResultSet resultSet = callable.executeQuery();
            System.out.println("doanh thu và lương thưởng thêm của từng nhân viên trong tháng "+thang+" là");
            System.out.println("| mã || tên || số điện thoại || doanh thu || thưởng thêm|");
            System.out.println("================================"); 
            while (resultSet.next()) {
            	int ma = resultSet.getInt(1);
            	String ten =resultSet.getString(2);
            	String sdt =resultSet.getString(3);
              	float doanhthu =resultSet.getFloat(4);
            	float thuong =resultSet.getFloat(5);
            	System.out.println(
                        "| " + ma + " | " + ten + " | " + sdt + " |"+ doanhthu + " |"+ thuong + " |");
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
        
    }
	
	// xếp hạng khách hàng theo lượng tiền đã mua
	public static void rank() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhathuoc", "root", "dotv");
            
            //query
            String sql ="select k.maKhachHang, k.tenKhachHang, k.dienThoai, tongTienChiTieu, customerLevel(tongTienChiTieu) as xepLoaiKhachHang\r\n"
            		+ "																						\r\n"
            		+ "			from khachhang as k inner join\r\n"
            		+ "								(select maKhachHang, sum(tungdonhang) as tongTienChiTieu\r\n"
            		+ "								from\r\n"
            		+ "								(select maHoaDon, sum(soLuong* gia) as tungdonhang\r\n"
            		+ "								from hoadonbanchitiet\r\n"
            		+ "								group by maHoaDon)  as a inner join\r\n"
            		+ "													 (select maHoaDon, maKhachHang\r\n"
            		+ "													 from hoadonban) as b\r\n"
            		+ "								on a.maHoaDon = b.maHoaDon\r\n"
            		+ "								group by maKhachHang) as c\r\n"
            		+ "			on k.maKhachHang = c.maKhachHang;";

            
            statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(sql);

            
            System.out.println("Xếp hạng khách hàng theo số tiền đã mua là");
            System.out.println("| mã || tên || số điện thoại || tổng chi tiêu|| xếp hạng|");
            System.out.println("================================"); 
            while (resultSet.next()) {
            	int ma = resultSet.getInt(1);
            	String ten =resultSet.getString(2);
            	String sdt =resultSet.getString(3);
              	float tongchitieu =resultSet.getFloat(4);
            	String rank =resultSet.getString(5);
            	System.out.println(
                        "| " + ma + " | " + ten + " | " + sdt + " |"+ tongchitieu + " |"+ rank + " |");
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
        
    }
	
	public static void rank2() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhathuoc", "root", "dotv");
            
            //query
            CallableStatement proc_stmt = null;
            
           // statement = connection.createStatement();
          // ResultSet resultSet = statement.executeQuery(sql);
            proc_stmt = connection.prepareCall("{ call showRank() }");

            proc_stmt.executeQuery();
            ResultSet resultSet = proc_stmt.executeQuery();
            System.out.println("Xếp hạng khách hàng theo số tiền đã mua là");
            System.out.println("| mã || tên || số điện thoại || tổng chi tiêu|| xếp hạng|");
            System.out.println("================================"); 
            while (resultSet.next()) {
            	int ma = resultSet.getInt(1);
            	String ten =resultSet.getString(2);
            	String sdt =resultSet.getString(3);
              	float tongchitieu =resultSet.getFloat(4);
            	String rank =resultSet.getString(5);
            	System.out.println(
                        "| " + ma + "   | " + ten + " | " + sdt + " |"+ tongchitieu + " |"+ rank + " |");
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
        
    }
	// Số lượng thuốc đã bán và tổng tiền bán thuốc theo chiều giảm dần trong tháng
	public static void sap_xep(int thang) {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhathuoc", "root", "dotv");
            CallableStatement callable = connection.prepareCall("{call showTotalMoneySellProduct (?)}");
            callable.setInt(1, thang);

            ResultSet resultSet = callable.executeQuery();

            
            System.out.println("Số lượng thuốc đã bán và tổng tiền thuốc sắp xếp theo chiều giảm dần");
            System.out.println("| mã || 	tên 		|| 		số lượng bán 	|| tổng tiền|");
            System.out.println("================================"); 
            while (resultSet.next()) {
            	int ma = resultSet.getInt(1);
            	String ten =resultSet.getString(2);
            	int soluong =resultSet.getInt(3);
              	float tongtien =resultSet.getFloat(4);
            	System.out.println(
                        "| " + ma + "  |" +"| "+ ten + " 		|" +"| 		"+ soluong + " |"+ tongtien + " |");
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
        
    }
	
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "HDPHARMA";
		String s2 = "'penicilin'";
		String s3 ="Trần Văn Độ";
		String s4 ="2021-05-06";
		String s5 = "Gà Lôi";
		String s6 = "2021-05-03";
		//Tim_theo_ten_hangSX(s1);
		//Tim_theo_ten_thuoc(s2);
		//Tim_theo_ten_nhan_vien(s3);
		//Tong_tien_nv(s3, s4);
		//Tong_tien_nhacungcap(s5);
		//Thong_tin(s6);
		//tong_tien_ban_theo_thang("5","2021");
		//tong_tien_nhap_theo_thang("1", "2021");
		//Tong_tien_theo_tung_loai();
		//tong_loi_nhuan("2021");
		doanh_so("5");
		//rank2();
		//sap_xep(5);
		

		
		
	}

}
