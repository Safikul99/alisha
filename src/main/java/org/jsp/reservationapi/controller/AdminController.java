
package org.jsp.reservationapi.controller;

import org.jsp.reservationapi.model.Admin;
import org.jsp.reservationapi.service.AdminService;
import org.springframework.asm.SpringAsmInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Delegate;

@RestController
@RequestMapping("/api/admins")
public class AdminController 
{
	@Autowired
	private AdminService adminService;
	@PostMapping
	public Admin saveAdmin(@RequestBody Admin admin)
	{
		return adminService.saveAdmin(admin);
	}
	@GetMapping("{id}")
	public Admin findById(@PathVariable int id)
	{
		return adminService.findById(id);
	}
	@PostMapping("/verify-by-phone")
	public Admin verify(@RequestParam long  phone,@RequestParam String password)
	{
		return adminService.verify(phone, password);
	}
	@PostMapping("/verfy-by-email")
	public Admin verify(@RequestParam String email,@RequestParam String password)
	{
	  return adminService.verify(email, password);
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id)
	{
		return adminService.delete(id);
	}
	

}
