package com.petwork.model.vo;

import java.util.Date;

public class ParcelAniView {
	private String title;
	private String head;
	private int postNo;
	private Date postDate;
	private String id;
	private int animalNo;
	private Date petBirth;
	private String address;
	private String gender;
	private String neutering;
	private int price;
	private String content;
	private String postYn;
	private String vaccination;
	private String animalName;
	private String raceName;
	private String imgAddress;
	private char memberGender;
	
	public ParcelAniView() {
	}

	public ParcelAniView(String title, String head, int postNo, Date postDate, String id, int animalNo, Date petBirth,
			String address, String gender, String neutering, int price, String content, String postYn,
			String vaccination, String animalName, String raceName, String imgAddress, char memberGender) {
		this.title = title;
		this.head = head;
		this.postNo = postNo;
		this.postDate = postDate;
		this.id = id;
		this.animalNo = animalNo;
		this.petBirth = petBirth;
		this.address = address;
		this.gender = gender;
		this.neutering = neutering;
		this.price = price;
		this.content = content;
		this.postYn = postYn;
		this.vaccination = vaccination;
		this.animalName = animalName;
		this.raceName = raceName;
		this.imgAddress = imgAddress;
		this.memberGender = memberGender;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAnimalNo() {
		return animalNo;
	}

	public void setAnimalNo(int animalNo) {
		this.animalNo = animalNo;
	}

	public Date getPetBirth() {
		return petBirth;
	}

	public void setPetBirth(Date petBirth) {
		this.petBirth = petBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNeutering() {
		return neutering;
	}

	public void setNeutering(String neutering) {
		this.neutering = neutering;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPostYn() {
		return postYn;
	}

	public void setPostYn(String postYn) {
		this.postYn = postYn;
	}

	public String getVaccination() {
		return vaccination;
	}

	public void setVaccination(String vaccination) {
		this.vaccination = vaccination;
	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public String getRaceName() {
		return raceName;
	}

	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}

	public String getImgAddress() {
		return imgAddress;
	}

	public void setImgAddress(String imgAddress) {
		this.imgAddress = imgAddress;
	}

	public char getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(char memberGender) {
		this.memberGender = memberGender;
	}

	@Override
	public String toString() {
		return "ParcelAniView [title=" + title + ", head=" + head + ", postNo=" + postNo + ", postDate=" + postDate
				+ ", id=" + id + ", animalNo=" + animalNo + ", petBirth=" + petBirth + ", address=" + address
				+ ", gender=" + gender + ", neutering=" + neutering + ", price=" + price + ", content=" + content
				+ ", postYn=" + postYn + ", vaccination=" + vaccination + ", animalName=" + animalName + ", raceName="
				+ raceName + ", imgAddress=" + imgAddress + ", memberGender=" + memberGender + "]";
	}
		

}
