package kr.co.seoulit.account.operate.humanresource.repository;

import kr.co.seoulit.account.operate.humanresource.entity.DepartmentEntity;
import kr.co.seoulit.account.operate.humanresource.entity.DepartmentPK;
import kr.co.seoulit.account.operate.humanresource.entity.DepartmentSelectList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface JpaDepartmentRepository extends JpaRepository<DepartmentEntity, DepartmentPK> {
    @Query( value = "select distinct d.workplaceCode as workplaceCode, d.workplaceName as workplaceName from DepartmentEntity d order by d.workplaceCode")
    List<DepartmentSelectList> findDistinctWorkplaceCode();
    //테스트할예정 List<DepartmentSelectList> findDistinctByWorkplaceCode(String workplaceCode);
    List<DepartmentEntity> findAllBy();
    ArrayList<DepartmentEntity> findByWorkplaceCode(String workplaceCode);

    // value오류가 생김.
    //    List<DepartmentEntity> findByWorkplaceCode(DepartmentEntity departmentEntity);
}
