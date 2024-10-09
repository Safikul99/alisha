package org.jsp.reservationapi.dao;

import java.util.Optional;

import org.jsp.reservationapi.model.Admin;
import org.jsp.reservationapi.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class AdminDao
{
	@Autowired
	private AdminRepository adminrepository;
	public Admin saveAdmin(Admin admin)
	{
		return adminrepository.save(admin);
	}
	public Optional<Admin>findById(int id)
	{
		return adminrepository.findById(id);
	}
	public Optional<Admin>verify(long phone,String psaaword)
	{
		return adminrepository.findByPhoneAndPassword(phone, psaaword);
	}
	public Optional<Admin>verify(String email,String password)
	{
		return adminrepository.findByEmailAndPassword(email, password);
	}

	public void delete(int id)
	{
		adminrepository.deleteById(id);
	}
}
