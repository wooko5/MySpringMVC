package kr.ac.hansung.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {
	
	@NotNull(message = "The year cannot be null")
	private int year;
	
	@NotNull(message = "The semester cannot be null")
	private int semester;
	
	@NotEmpty(message = "The title cannot be empty")
	private String title;
	
	@NotEmpty(message = "The classification cannot be empty")
	private String classification;
	
	@NotEmpty(message = "The professor cannot be empty")
	private String professor;
	
	@NotNull(message = "The grade cannot be null")
	private int grade;
	
}
