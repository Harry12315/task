package task.task.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import task.task.model.Users;

@Mapper
public interface UsersMapper {

	@Select("select * from users")
	List<Users> getUsers();

	@Select("select * from users where username=#{username} and password=#{password}")
	Users checkUser(@Param("username") String username,@Param("password") String password);

	@Select("select * from users where username=#{username}")
	Users checkName(@Param("username") String username);

	@Insert("insert into users(username,password) values(#{username},#{password})")
	void insert(@Param("username") String username,@Param("password") String password);

	@Delete("<script>"+
				"delete from users"+
				"<where>"+
					 "<if test='username != null and username.length() != 0'>"+
						"and username = #{username}"+
					 "</if>"+
					 "<if test='password != null and password.length() != 0'>"+
						"and password = #{password}"+
					 "</if>"+
				 "</where>"+
			 "</script>")
	void delete(@Param("username") String username,@Param("password") String password);

	@Update("update users set username=#{username},password=#{password}"+
			"where username =#{modify}")
	void update(@Param("username") String username,@Param("password") String password,
			    @Param("modify") String modify);
}
