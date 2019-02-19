package com.petwork.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.petwork.model.service.ParcelService;
import com.petwork.model.vo.Member;
import com.petwork.model.vo.Parcel;
import com.petwork.model.vo.ParcelImg;


/**
 * Servlet implementation class ParcelWriteEndServlet
 */
@WebServlet("/parcelWriteView")
public class ParcelWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParcelWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		try {
            String root = getServletContext().getRealPath("/");
    		String saveDir = root + "views/upload/parcel";
            
            int maxSize = 1024*1024*10;
            
            MultipartRequest mr = new MultipartRequest(request, saveDir, maxSize, "UTF-8", new DefaultFileRenamePolicy());         
            
            Enumeration fils = mr.getFileNames();
                        
            String file = "";
            String fileName = "";
            
            String head = mr.getParameter("parcel-write-race");
    		String animalName = mr.getParameter("parcel-animal");
    		int aniNo = new ParcelService().getAnimalNo(animalName);
    		String gender = mr.getParameter("pet-gender");
    		String neutering = mr.getParameter("pet-neutering");
    		if(neutering==null) {
    			neutering = "N";
    		}
    		String city = mr.getParameter("parcel-city");
    		String cityName = new ParcelService().getCityName(city);
    		String district = mr.getParameter("parcel-district");
    		String address = cityName+" "+district;
    		int price = Integer.parseInt(mr.getParameter("parcel-price"));
    		
    		String[] vaccination = mr.getParameterValues("vaccination");
    		String vac = "";
    		if(vaccination!=null) {
    			vac = String.join(",", vaccination);
    		}
    		String petBirth = mr.getParameter("pet-birth");
    		Date petBirthDate=Date.valueOf(petBirth);
    		String id = "";
    		HttpSession session=request.getSession();
    		Member m=(Member)session.getAttribute("loginMember");
    		id=m.getId();
    		String title = mr.getParameter("parcel-title");
    		String content = mr.getParameter("parcel-content");
    		Parcel p = new Parcel();
    		p.setHead(head);
    		p.setAnimalNo(aniNo);
    		p.setGender(gender);
    		p.setNeutering(neutering);
    		p.setAddress(address);
    		p.setPrice(price);
    		p.setVaccination(vac);
    		p.setPetBirth(petBirthDate);
    		p.setTitle(title);
    		p.setContent(content);
    		p.setId(id);
    		int result = new ParcelService().insertPost(p);
    		Parcel returnP = new ParcelService().findPostNo(p);
    		int postNo = returnP.getPostNo();
    		String mainImg = "";
            int load=0;
            int i =0;
            String msg = "";
            String loc = "";
            String view = "/views/common/msg.jsp";
            if(result>0) {
               //이미지가 있을 경우
                  while(fils.hasMoreElements()) {
                     ParcelImg parcelImg = new ParcelImg();
                     file = (String)fils.nextElement();
                     fileName = mr.getFilesystemName(file);
                     parcelImg.setParcelImgAddress(fileName);
                     parcelImg.setParcelPostNo(postNo);
                     if(i==0) {
                    	 mainImg = "M";
                     } else {
                    	 mainImg = "S";
                     }
                     parcelImg.setParcelMainImg(mainImg);
                     load = new ParcelService().insertImg(parcelImg);
                     i++;
                  }
                  msg = "글 등록했습니다.";
                  loc = "/parcelMain";
                  request.setAttribute("msg", msg);
                  request.setAttribute("loc", loc);
                  request.getRequestDispatcher(view).forward(request, response);
            }
            else {
               //등록실패 할 경우
            	msg = "글 등록에 실패했습니다. 다시 시도해주세요";
                loc = "/parcelMain";
                request.setAttribute("msg", msg);
                request.setAttribute("loc", loc);
               request.getRequestDispatcher(view).forward(request, response);
            }
         }
         catch(Exception e) {
            e.printStackTrace();
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
