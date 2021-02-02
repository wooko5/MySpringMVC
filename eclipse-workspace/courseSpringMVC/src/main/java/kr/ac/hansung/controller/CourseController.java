package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.service.CourseService;


@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	/*학기별 이수과목 조회*/
	@RequestMapping("/courses")
	public String showOffers(Model model) {
		
		List<Course> courses = courseService.getCurrent();
		model.addAttribute("courses", courses);
		
		return "courses";
	}
	
	/*상세보기2014-1*/
	@RequestMapping("/coursebysemester2014")
	public String viewOffers1(Model model) {
		
		List<Course> courses = courseService.getCurrent3(2014,1);
		model.addAttribute("course", courses);
		
		return "coursebysemester2014";
	}
	
	/*상세보기2017-1*/
	@RequestMapping("/coursebysemester2017")
	public String viewOffers2(Model model) {
		
		List<Course> courses = courseService.getCurrent3(2017,1);
		model.addAttribute("course", courses);
		
		return "coursebysemester2017";
	}
	
	/*상세보기2019-1*/
	@RequestMapping("/coursebysemester2019")
	public String viewOffers3(Model model) {
		
		List<Course> courses = courseService.getCurrent3(2019,1);
		model.addAttribute("course", courses);
		
		return "coursebysemester2019";
	}
	
	/*상세보기2020-1*/
	@RequestMapping("/coursebysemester2020")
	public String viewOffers4(Model model) {
		
		List<Course> courses = courseService.getCurrent3(2020,1);
		model.addAttribute("course", courses);
		
		return "coursebysemester2020";
	}
	
	/*상세보기2014-2*/
	@RequestMapping("/coursebysemester4028")
	public String viewOffers5(Model model) {
		
		List<Course> courses = courseService.getCurrent3(2014,2);
		model.addAttribute("course", courses);
		
		return "coursebysemester4028";
	}
	
	/*상세보기2017-2*/
	@RequestMapping("/coursebysemester4034")
	public String viewOffers6(Model model) {
		
		List<Course> courses = courseService.getCurrent3(2017,2);
		model.addAttribute("course", courses);
		
		return "coursebysemester4034";
	}
	
	/*상세보기2019-2*/
	@RequestMapping("/coursebysemester4038")
	public String viewOffers7(Model model) {
		
		List<Course> courses = courseService.getCurrent3(2019,2);
		model.addAttribute("course", courses);
		
		return "coursebysemester4038";
	}
	
	/*상세보기2020-2*/
	@RequestMapping("/coursebysemester4040")
	public String viewOffers8(Model model) {
		
		List<Course> courses = courseService.getCurrent3(2020,2);
		model.addAttribute("course", courses);
		
		return "coursebysemester4040";
	}
	
	
	/*수강신청메뉴*/
	@RequestMapping("/createcourse")
	public String createOffers(Model model) {
		
		model.addAttribute("course", new Course());
		
		return "createcourse";
	}
	
	/*수강신청*/
	@RequestMapping("/docreate")
	public String doCreate(Model model, @Valid Course course, BindingResult result) {
		
		if(result.hasErrors()) {
			
			System.out.println(" === Form data dose not validated === ");
			
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "createcourse";
		}
		courseService.insert(course);
		return "coursecreated";
	}
	
	/*학기별 이수과목 조회*/
	@RequestMapping("/viewcourse")
	public String showOffer(Model model) {
		
		List<Course> courses = courseService.getCurrent2();
		model.addAttribute("viewcourse", courses);
		
		return "viewcourse";
	}
}
