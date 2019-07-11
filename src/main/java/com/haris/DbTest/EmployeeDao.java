package com.haris.DbTest;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.ArrayList;  
import java.util.List;  
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.expression.common.TemplateAwareExpressionParser;
import org.springframework.jdbc.core.JdbcTemplate;
public class EmployeeDao 
{
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int saveEmployee(Employee e) {
		
		String query = "insert into employee values( '"+e.getId()+"','"+e.getName()+"','"+e.getSalary()+"')";
		return jdbcTemplate.update(query);
		
	}
	
		public List<Employee> getAllEmployees() {
		
		return jdbcTemplate.query("select * from employee",new ResultSetExtractor<List<Employee>>(){
			
			public List<Employee> extractData(ResultSet rs) throws SQLException,
			DataAccessException{
				List<Employee> list=new ArrayList<Employee>();  
		        while(rs.next()){  
		        Employee e= new Employee();  
		        e.setId(rs.getInt(1));  
		        e.setName(rs.getString(2));  
		        e.setSalary(rs.getFloat(3));  
		        list.add(e);  
			}
		        return list;
			}
			
		}); }
		
		public List<Employee> getAllEmployeesMapper(){
			
			return jdbcTemplate.query("select * from employee", new RowMapper<Employee>() {
				public Employee mapRow(ResultSet rs, int rowNum) throws SQLException{
					Employee e = new Employee();
					e.setId(rs.getInt(1));
					e.setName(rs.getString(2));
					e.setSalary(rs.getFloat(3));
					
					return e;
				}
			});
		}
		
/*		public List<Employee> findAll(){
			
			String sql = "SELECT * FROM Employee";
				
			List<Employee> employees  = getJdbcTemplate().query(sql,
					new BeanPropertyRowMapper(Employee.class));
				
			return employees;
		}*/
		
	
}

