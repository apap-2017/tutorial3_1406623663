package com.example.tutorial3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.tutorial3.service.InMemoryStudentService;
import com.example.tutorial3.service.StudentService;
import com.example.tutorial3.model.StudentModel;


@Controller
public class StudentController 
{
	private final StudentService studentService;	
	
	public StudentController() {
		studentService = new InMemoryStudentService();
	}
	
	@RequestMapping("/student/add")
	public String add(@RequestParam(value = "npm", required = true)String npm,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "gpa", required = true) double gpa) {
		StudentModel student = new StudentModel(npm, name, gpa);
		studentService.addStudent(student);
		return "add";
	}
	
//	@RequestMapping("/student/view")
//	public String view (Model model, @RequestParam(value = "npm", required = true) 
//	String npm) 
//	 {
//		StudentModel student = studentService.selectStudent(npm);
//		model.addAttribute("student", student);
//		return "view";
//	}
	
	@RequestMapping("/student/viewall")
	public String viewAll(Model model) {
		List<StudentModel> students = studentService.selectAllStudents();
		model.addAttribute("students", students);
		return "viewall";
	}
	
	@RequestMapping(value = {"student/view", "/student/view/{npm}"})
	public String viewPath(@PathVariable(required = false) String npm, Model model) {
		if(npm != null) {
			String tnpm = "" + npm;
			StudentModel student = studentService.selectStudent(tnpm);
			model.addAttribute("student", student);
		}
		else {
			String npm1 = "TIDAKDITEMUKAN";
			String name = "TIDAKDITEMUKAN";
			double gpa = 0.0;
			StudentModel student = new StudentModel(npm1, name, gpa);
			studentService.addStudent(student);
			StudentModel students  = studentService.selectStudent(npm1);
			model.addAttribute("student", students);
		}
		return "view";
	}
	
	 @RequestMapping("student/delete/{npm}")
	 public String delete(@PathVariable String npm, Model model) {
		 boolean tmp = studentService.delete(npm);
		 model.addAttribute("deleted", tmp);
		 return "delete";
	 }
}
