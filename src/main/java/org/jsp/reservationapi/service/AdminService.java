package org.jsp.reservationapi.service;

import java.util.Optional;

import org.jsp.reservationapi.dao.AdminDao;
import org.jsp.reservationapi.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AdminService {
	@Autowired
   private AdminDao adminDao;
	public Admin saveAdmin(Admin admin)
	{
	return	adminDao.saveAdmin(admin);
	}
	public Admin update(Admin admin)
	{
		Optional<Admin> recAdmin= adminDao.findById(admin.getId());
		if(recAdmin.isPresent())
		{
			Admin  dbAdmin= recAdmin.get();
			dbAdmin.setEmail(admin.getEmail());
			dbAdmin.setName(admin.getName());
			dbAdmin.setGst_number(admin.getGst_number());
			dbAdmin.setPassword(admin.getPassword());
			dbAdmin.setPhone(admin.getPhone());
			dbAdmin.setTravles_name(admin.getTravles_name());
			return dbAdmin;
		}
		else
			return null;
	}
	public Admin findById(int id)
	{
		Optional<Admin> dbAdmin = adminDao.findById(id);
		if(dbAdmin.isPresent())
		{
			return dbAdmin.get();
		}
		else
			return null;
	}
	public Admin verify(long phone ,String password)
	{
		Optional<Admin> dbAdmin= adminDao.verify(phone, password);
		if(dbAdmin.isPresent())
		{
			return dbAdmin.get();
		}
		else
		return	null;
		
	}
	public Admin verify(String email,String password)
	{
		Optional<Admin> dbAdmin = adminDao.verify(email, password);
		if(dbAdmin.isPresent())
		{
			return dbAdmin.get();
		}
		else
		{
			return null;
		}
	}
	
	public String delete(int id)
	{
		Optional<Admin> dbAdmin = adminDao.findById(id);
		if(dbAdmin.isPresent())
		{
			adminDao.delete(id);
			return "Admin Found";
		}
		else
		{
			return "Admin not find";
		}
	}
	
   
	
	
	
	
	
	
	
	
	
	
	
	
	
}
