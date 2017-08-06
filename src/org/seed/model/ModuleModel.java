package org.seed.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.seed.bean.Module;
import org.seed.util.Connectivity;

public class ModuleModel {
	Connection con=Connectivity.connect();
	int i;
	Boolean bool;
	ArrayList<Module> moduleList=new ArrayList<Module>();
    
	
	public int insertModule(Module module){
		String sql="INSERT INTO Modules"
				+ "(id,moduleCode,moduleName,noOfHours,status,moduleDate) VALUES"
				+ "(?,?,?,?,?,sysdate)";
	   try {
		PreparedStatement stmt=	con.prepareStatement(sql);
		stmt.setInt(1,201);
		stmt.setString(2,module.getModuleCode());
		stmt.setString(3, module.getModuleName());
		stmt.setInt(4, module.getNoOfHours());
		stmt.setString(5, module.getStatus());
		i=stmt.executeUpdate();
		System.out.println("data inserted successfully");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
	}
	public boolean isModuleCodeUnique(String moduleCode){
		String sql="select moduleCode from modules where moduleCode=?";
		
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, moduleCode);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()){
				String code=rs.getString("moduleCode");
				if(code.equals(moduleCode))
					bool=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
		
	}
	public int deleteModule(int id){
		String sql="delete from modules where id=?";
        try {
			PreparedStatement stmt= con.prepareStatement(sql);   
			stmt.setInt(1, id);
			i=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
    public int updateModule(Module module){
    	String sql="update modules set moduleName=?,set noOfHours=?,status=? where id=?";
    	PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1,module.getModuleName());
	    	stmt.setInt(2, module.getNoOfHours());
	    	stmt.setString(3, module.getStatus());
	    	i=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i; 
    }
    public List<Module> fetchModules(){
    	String sql="select * from modules";
    	try {
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String code=rs.getString("moduleCode");
				String mName=rs.getString("moduleName");
				int hours=rs.getInt("noOfHours");
				String status=rs.getString("status");
				Date d=rs.getDate("moduleDate");
				Module module=new Module();
				module.setSrNo(id);
				module.setModuleName(mName);
				module.setNoOfHours(hours);
				module.setModuleCode(code);
				module.setStatus(status);
				moduleList.add(module);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return moduleList;	
    }
    public boolean isModuleNameAndHoursUnique(String moduleName,int hours){
    	String sql="select moduleName,noOfHours from modules where moduleName=? and noOfHours=?";
    	
        try {
			PreparedStatement stmt=	con.prepareStatement(sql);
			stmt.setString(1, moduleName);
			stmt.setInt(2, hours);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				if(moduleName.equals(rs.getString("moduleName"))&&(hours==(rs.getInt("noOfHours"))))
					bool=true;				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
    	
    }
    
}
