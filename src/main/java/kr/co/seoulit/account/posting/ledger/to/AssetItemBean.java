package kr.co.seoulit.account.posting.ledger.to;

public class AssetItemBean {
	String assetItemCode;
	String assetItemName;
	String acquisitionDate; //취득일자
	int acquisitionAmount; //취득금액
	int usefulLift; //내용연수
	String manageMentDeptName; // 관리부서이름
	String parentsCode;
	String parentsName;
	
	public String getAssetItemCode() {
		return assetItemCode;
	}
	public void setAssetItemCode(String assetItemCode) {
		this.assetItemCode = assetItemCode;
	}
	public String getAssetItemName() {
		return assetItemName;
	}
	public void setAssetItemName(String assetItemName) {
		this.assetItemName = assetItemName;
	}
	public String getAcquisitionDate() {
		return acquisitionDate;
	}
	public void setAcquisitionDate(String acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}
	public int getAcquisitionAmount() {
		return acquisitionAmount;
	}
	public void setAcquisitionAmount(int acquisitionAmount) {
		this.acquisitionAmount = acquisitionAmount;
	}
	public String getManageMentDeptName() {
		return manageMentDeptName;
	}
	public void setManageMentDeptName(String manageMentDeptName) {
		this.manageMentDeptName = manageMentDeptName;
	}
	public String getParentsCode() {
		return parentsCode;
	}
	public void setParentsCode(String parentsCode) {
		this.parentsCode = parentsCode;
	}
	public String getParentsName() {
		return parentsName;
	}
	public void setParentsName(String parentsName) {
		this.parentsName = parentsName;
	}
	public int getUsefulLift() {
		return usefulLift;
	}
	public void setUsefulLift(int usefulLift) {
		this.usefulLift = usefulLift;
	}
}
