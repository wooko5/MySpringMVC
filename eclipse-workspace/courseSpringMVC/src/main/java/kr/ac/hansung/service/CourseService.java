package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.CourseDao;
import kr.ac.hansung.model.Course;



@Service
public class CourseService {

	@Autowired
	private CourseDao courseDao;
	
	public List<Course> getCurrent(){
		return courseDao.getOffers();
	}
	
	public List<Course> getCurrent2(){
		return courseDao.getOffer();
	}
	
	public List<Course> getCurrent3(int year, int semester){
		return courseDao.getOffer2(year,semester);
	}
	

	public void insert(Course course) {
		
		courseDao.insert(course);		
	}
}
