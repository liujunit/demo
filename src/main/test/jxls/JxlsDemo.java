package jxls;

import org.junit.Test;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JxlsDemo {

    @Test
    public void test01() throws Exception {
        // 模板路径和输出流
        String templatePath = "E:\\excel-demo\\template.xls";
        OutputStream os = new FileOutputStream("E:\\excel-demo\\test01.xls");
        // 定义一个Map，往里面放入要在模板中显示数据
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("employees", generateSampleEmployeeData());
        //调用之前写的工具类，传入模板路径，输出流，和装有数据Map
        JxlsUtils.exportExcel(templatePath, os, model);
        os.close();
        System.out.println("完成");
    }

    public List<Employee> generateSampleEmployeeData() {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            employee.setScore(i);
            employees.add(employee);
        }
        return employees;
    }


}
