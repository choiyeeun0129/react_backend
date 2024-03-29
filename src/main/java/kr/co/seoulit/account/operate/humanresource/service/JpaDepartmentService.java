package kr.co.seoulit.account.operate.humanresource.service;

import kr.co.seoulit.account.operate.humanresource.entity.DepartmentEntity;
import kr.co.seoulit.account.operate.humanresource.entity.DepartmentSelectList;

import java.util.ArrayList;
import java.util.List;

public interface JpaDepartmentService {
    public List<DepartmentSelectList> findDeptList();
    public List<DepartmentEntity> find();
//  public List<DepartmentEntity> findDetailDeptList(String workplaceCode);
    public ArrayList<DepartmentEntity> findDetailDeptList(DepartmentEntity departmentEntity);
}
