package com.petwork.controller;

import java.io.IOException;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.petwork.model.service.DoctorService;
import com.petwork.model.vo.City;
import com.petwork.model.vo.Doctor;

/**
 * Servlet implementation class DoctorAdvice
 */
@WebServlet("/doctor/advice")
public class DoctorAdvice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorAdvice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cityCode=request.getParameter("city");
	     City city = new DoctorService().findCity(cityCode);
	     String cityName=city.getCityName().substring(0,3);
		List<Doctor> doctorAreaList = new DoctorService().doctorAreaList(cityName);	
		request.setAttribute("cityDoctor", doctorAreaList);
		
		
		if(doctorAreaList!=null)
		{
//			String view="/doctor/adviceMain";
//		request.getRequestDispatcher(view).forward(request, response);
			response.setContentType("application/json;charset=UTF-8");
			new Gson().toJson(doctorAreaList,response.getWriter());
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
