package mapper;


import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import model.User;

/*@CacheNamespace(size=512)*/
public interface UserMapper {
	/*@Select(value={"selecr * from user where username = #{username}"})
	@Results(value={
			@Result(id=true,property="id",column="ID"),
			@Result(property="username",column="USERNAME"),
			@Result(property="password",column="PASSWORD")
	})
	@Options(flushCache=false,useCache=false,timeout=1000)
*/
	User selectByName(User user);
}
