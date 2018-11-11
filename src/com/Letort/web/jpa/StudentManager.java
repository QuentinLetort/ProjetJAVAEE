package com.Letort.web.jpa;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class StudentManager {
	List<Student> students;	
	Student editStudent;
	Student newStudent=new Student();
	Map<String, Object> requestMap =FacesContext.getCurrentInstance().getExternalContext().getRequestMap();

	public StudentManager() {
		super();
		students=new ArrayList<Student>();
	}	
	public Student getEditStudent() {
		return editStudent;
	}
	public void setEditStudent(Student editStudent) {
		this.editStudent = editStudent;
	}
	public Student getNewStudent() {
		return newStudent;
	}
	public void setNewStudent(Student newStudent) {
		this.newStudent = newStudent;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}	
	public void loadStudents()	{
		students=StudentDBUtil.loadStudents();
	}
	
	public String addStudent() {
		StudentDBUtil.addStudent(newStudent);
		newStudent=new Student();
		return "list-students";
	}	
	public String editStudentMethod(int id) {
		editStudent = StudentDBUtil.fetchStudent(id);
		return "edit-student";
	}
	public String updateStudent() {
		StudentDBUtil.updateStudent(editStudent);
	    return "list-students";
	}
	
	public String deleteStudent(int	id) {
		StudentDBUtil.deleteStudent(id);
		return "list-students";
	}

}
