package kr.co.seoulit.account.operate.humanresource.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.seoulit.account.operate.humanresource.entity.DepartmentEntity;
import kr.co.seoulit.account.operate.humanresource.entity.DepartmentSelectList;
import kr.co.seoulit.account.operate.humanresource.service.JpaDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import kr.co.seoulit.account.operate.humanresource.service.HumanResourceService;

import kr.co.seoulit.account.operate.humanresource.to.DepartmentBean;
import kr.co.seoulit.account.operate.humanresource.to.EmployeeBean;

import net.sf.json.JSONObject;

@CrossOrigin("*")
@RestController
@RequestMapping("/operate")
public class HRController {

    @Autowired
    private HumanResourceService humanResourceService;

    @Autowired
    private JpaDepartmentService jpaDepartmentService;

    ModelAndView mav;
    ModelMap map = new ModelMap();
    
    @GetMapping("/employeelist")
	public ArrayList<EmployeeBean> findEmployeeList(@RequestParam String deptCode) {

            ArrayList<EmployeeBean> empList = humanResourceService.findEmployeeList(deptCode);
            return empList;
    }
    
    @GetMapping("/employeeListall")
    public ArrayList<EmployeeBean> findEmployeeListAll() {

            ArrayList<EmployeeBean> empList = humanResourceService.findEmployeeList();
            
            return empList;
    }

    @GetMapping("/employee")
    public EmployeeBean findEmployee(@RequestParam String empCode) {

            EmployeeBean employeeBean = humanResourceService.findEmployee(empCode);

            return employeeBean;
    }

    @GetMapping("/batchempinfo")
    public void batchEmpInfo(@RequestParam String employeeInfo,@RequestParam String image) {
      
            JSONObject jsonObject = JSONObject.fromObject(employeeInfo);
         
            EmployeeBean employeeBean = (EmployeeBean) JSONObject.toBean(jsonObject, EmployeeBean.class);
            employeeBean.setImage(image);
            humanResourceService.batchEmployeeInfo(employeeBean);
           
   
    }

    @GetMapping("/emptyempbean")
    public ModelAndView EmptyEmpBean(HttpServletRequest request, HttpServletResponse response) {
       
        return null;
    }

    @GetMapping("/batchemp")
    public void batchEmp(@RequestParam String JoinEmployee) {
     
            JSONObject jsonObject = JSONObject.fromObject(JoinEmployee);
            
            EmployeeBean employeeBean = (EmployeeBean) JSONObject.toBean(jsonObject, EmployeeBean.class);

            humanResourceService.registerEmployee(employeeBean);
          
    }
    
    @GetMapping("/employeeremoval")
    public void removeEmployee(@RequestParam String empCode) {
    	
           
            EmployeeBean employeeBean = new EmployeeBean();
            employeeBean.setEmpCode(empCode);
            humanResourceService.removeEmployee(employeeBean);
          
     
    }
   /* @GetMapping("/deptlist")
    public ArrayList<DepartmentBean> findDeptList() {
       
            ArrayList<DepartmentBean> deptList = humanResourceService.findDeptList();
         
        return deptList;
    }*/

    // 복합키사용해야함 key 2개사용
    // ========== JPA 구현 ==========
    @GetMapping("/deptlist")
    public List<DepartmentSelectList> findDeptList(){
        List<DepartmentSelectList> deptList = jpaDepartmentService.findDeptList();
        return deptList;
    }

    // ========== JPA 구현 ==========
    // 이렇게 사용할려면 앞단에서 칼럼선언 및 _.uniqBy를 활용해야함.
//    @GetMapping("/deptlist")
//    public List<DepartmentEntity> findDeptList(){
//        List<DepartmentEntity> deptList = jpaDepartmentService.find();
//        System.out.println("실행되고있을까요? "+deptList);
//        return deptList;
//    }
    
    /*@GetMapping("/detaildeptlist")
    public ArrayList<DepartmentBean> findDetailDeptList(@RequestParam String workplaceCode) {

            ArrayList<DepartmentBean> detailDeptList = humanResourceService.findDetailDeptList(workplaceCode);

        return detailDeptList;
    }*/

    // =================== JPA구현 ===================
//    @GetMapping("/detaildeptlist")
//    public HashMap<String, Object> findDetailDeptList(@RequestParam("workplaceCode") String workplaceCode){
//        HashMap<String, Object> map =new HashMap<>();
//        List<DepartmentEntity> detailDeptList = jpaDepartmentService.findDetailDeptList(workplaceCode);
//        map.put("detailDeptList", detailDeptList);
//        return map;
//    }

    @GetMapping("/detaildeptlist")
    public HashMap<String, Object> findDetailDeptList(DepartmentEntity departmentEntity){
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<DepartmentEntity> detailDeptList = jpaDepartmentService.findDetailDeptList(departmentEntity);
        map.put("detailDeptList", detailDeptList);
        return map;
    }

    public ArrayList<DepartmentBean> findDeptList2() {
        
   	 ArrayList<DepartmentBean> deptList = humanResourceService.findDeptList2();
        
       return deptList;
   }
}
