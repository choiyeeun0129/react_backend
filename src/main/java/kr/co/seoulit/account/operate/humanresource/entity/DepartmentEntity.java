package kr.co.seoulit.account.operate.humanresource.entity;

import kr.co.seoulit.account.budget.formulation.entity.BudgetProductPK;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENT")
@NoArgsConstructor
@Data
@IdClass(DepartmentPK.class)
public class DepartmentEntity {
    @Id
    private String workplaceCode;
    @Id
    private String deptCode;
    private String workplaceName;
    private String deptName;
    private String companyCode;
    private String deptStartDate;
    private String deptEndDate;
}
