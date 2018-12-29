import com.syw.action.DataManager;
import com.syw.dao.EmployeeDao;
import com.syw.pojo.Employee;
import com.syw.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class TestAop {
    @Autowired
    private DataManager dataManager;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private AccountService accountService;
    @Test
    public void test1(){
        dataManager.save();
    }
    @Test
    public void test2(){
        Employee emp=new Employee();
        emp.setName("杨笑笑");
        emp.setAge(22);
        employeeDao.save(emp);
    }
    @Test
    public void test3(){
       List<Employee> list= employeeDao.query();
       for(Employee e: list){
           System.out.println(e);
       }
    }
    @Test
    public void test4(){
        System.out.println(employeeDao.queryById(1));
    }
    @Test
    public void test5(){
      accountService.trans(10086L,10001L,new BigDecimal("1000.55"));
    }

    @Test
    public void test6(){
        List<String> list=new ArrayList<>();
        list.add("666");
        list.add("8");
        list.add("9");
        list.add("op");

        System.out.println(list);
    }
    @Test
    public void test7(){
        List<String> list=new ArrayList<>();
        list.add("666");
        list.add("8");
        list.add("9");
        list.add("op");
        list.remove("op");
        System.out.println(list);
    }
}
