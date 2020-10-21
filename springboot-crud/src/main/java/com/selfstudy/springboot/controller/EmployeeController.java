package com.selfstudy.springboot.controller;

import com.selfstudy.springboot.dao.DepartmentDao;
import com.selfstudy.springboot.dao.EmployeeDao;
import com.selfstudy.springboot.entities.Department;
import com.selfstudy.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * ClassName :EmployeeController
 * Package :com.selfstudy.springboot.controller
 * Description :
 *
 * @author :张哈哈
 * @date :2020/10/18 22:50
 */
@Controller
public class EmployeeController {

    @Autowired
    DepartmentDao departmentDao;

    @Autowired
    EmployeeDao employeeDao;

    /**
     * 查询所有员工
     * @param model
     * @return
     */
    @GetMapping("/emps")
    public String getAllEmps(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    /**
     * 添加员工页面
     * @param model
     * @return
     */
    @GetMapping("/emp")
    public String addEmpPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    /**
     * 员工添加
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 跳转至编辑页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditEmp(@PathVariable("id") Integer id ,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    /**
     * 员工信息修改
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String editEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 删除员工信息
     * @param id
     * @return
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
