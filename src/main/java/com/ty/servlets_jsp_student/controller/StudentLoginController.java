package com.ty.servlets_jsp_student.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.servlets_jsp_student.dao.StudentDao;
import com.ty.servlets_jsp_student.dto.Student;

@WebServlet("/login")
public class StudentLoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		StudentDao studentDao = new StudentDao();
		Student student = studentDao.loginStudentByEmail(email);
		
		if (student.getPassword().equals(password)) {
			List<Student> list = studentDao.getAllStudents();
			req.setAttribute("list", list);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("display.jsp");
			requestDispatcher.forward(req, resp);

		} else {
			req.setAttribute("message", "invalid password");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			requestDispatcher.include(req, resp);

		}

	}
}
