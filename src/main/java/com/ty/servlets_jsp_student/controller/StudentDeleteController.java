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

@WebServlet("/delete")
public class StudentDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		StudentDao studentDao = new StudentDao();
		boolean result = studentDao.deleteStudent(id);

		if (result) {
			List<Student> list = studentDao.getAllStudents();
			req.setAttribute("list", list);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("display.jsp");
			requestDispatcher.forward(req, resp);
		}

	}

}
