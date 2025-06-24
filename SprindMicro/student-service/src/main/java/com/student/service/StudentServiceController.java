package com.student.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentServiceController {
	private static Map<String,List<student>> schoolDB;
	static
	{
		schoolDB = new HashMap<String,List<student>>();
		List<student> studList = new ArrayList<>();
		student stud = new student("John","Class X");
		studList.add(stud);
		stud = new student("Mary","Class IX");
		studList.add(stud);
		schoolDB.put("abcschool", studList);
		studList = new ArrayList<>();
		stud = new student("Smith","Class VIII");
		studList.add(stud);
		stud = new student("Raj","Class VI");
		studList.add(stud);
		schoolDB.put("xyzschool", studList);
	}
	@GetMapping("/getStudentDetailsForSchool/{schoolname}")
	public List<student> getstudents(@PathVariable String schoolname)
	{
		List<student> studList = schoolDB.get(schoolname);
		return studList;
	}

}
