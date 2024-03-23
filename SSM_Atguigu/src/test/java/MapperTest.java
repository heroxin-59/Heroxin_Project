import com.hero.dao.DepartmentMapper;
import com.hero.dao.EmployeeMapper;
import com.hero.entity.Department;
import com.hero.entity.Employee;
import com.hero.entity.EmployeeExample;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @author Heroxin
 * @create 2022-06-30-9:31
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private SqlSession session;

    @Test
    public void testDept(){
        System.out.println(departmentMapper);
        System.out.println(employeeMapper);
        /**
         * dept测试
         */
//        departmentMapper.insertSelective(new Department(null,"开发部"));
//        departmentMapper.insertSelective(new Department(null,"测试部"));
        /**
         * emp测试
         */
//        employeeMapper.insertSelective(new Employee(null,"李鑫","M","hero_xin59@163.com",1));
        /**
         * 批量插入emp
         */
        /*EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        for (int i = 0;i < 1000;i++){
            String uid = UUID.randomUUID().toString().substring(0, 5);
            mapper.insertSelective(new Employee(null,uid,"M",uid+"@163.c0m",1));
        }*/
    }

}
