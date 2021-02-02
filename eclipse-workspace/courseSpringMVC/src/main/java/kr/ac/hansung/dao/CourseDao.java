package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Course;


@Repository
public class CourseDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from courses";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}

	// query and return a single object
	public List<Course> getOffer() {
		String sqlStatement = "select * from courses where year=2021";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();
				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setTitle(rs.getString("title"));
				course.setClassification(rs.getString("classification"));
				course.setProfessor(rs.getString("professor"));
				course.setGrade(rs.getInt("grade"));
				
				return course;
			}

		});

	}
	
	// query and return a single object
	public List<Course> getOffer2(int year, int semester) {
		String sqlStatement = "select * from courses where year=? and semester=?";
		return jdbcTemplate.query(sqlStatement,new Object[] {year, semester}, new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();
				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setTitle(rs.getString("title"));
				course.setClassification(rs.getString("classification"));
				course.setProfessor(rs.getString("professor"));
				course.setGrade(rs.getInt("grade"));
				
				return course;
			}

		});

	}

	// query and return a Multiple object
	public List<Course> getOffers() {
		String sqlStatement = "select year, semester, sum(grade) from courses where year != '2021' group by year,semester";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

				Course course = new Course();
				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setGrade(rs.getInt("sum(grade)"));
				return course;
			}

		});

	}

	// test Crud method
	public boolean insert(Course course) {

		int year = 2021;
		int semester = 1;
		String title = course.getTitle();
		String classification = course.getClassification();
		String professor = course.getProfessor();
		int grade = course.getGrade();

		String sqlStatement = "insert into courses (year, semester, title, classification, professor, grade) values(?,?,?,?,?,?)";
		return (jdbcTemplate.update(sqlStatement, new Object[] { year, semester, title, classification, professor, grade}) == 1);
	}

	// test crUd method
	public boolean update(Course course) {
		
		int year = course.getYear();
		int semester = course.getSemester();
		String title = course.getTitle();
		String classification = course.getClassification();
		String professor = course.getProfessor();
		int grade = course.getGrade();

		String sqlStatement = "update courses set year=?, semester=?, title=?, classification=?, professor=?, grade=? where year=?";
		return (jdbcTemplate.update(sqlStatement, new Object[] { year, semester, title, classification, professor, grade, year }) == 1);
	}
	
	// test cruD method
		public boolean delete(int id) {
			String sqlStatement = "delete from courses where course_id=?";
			return (jdbcTemplate.update(sqlStatement, new Object[] {id}) == 1);
		}
}
