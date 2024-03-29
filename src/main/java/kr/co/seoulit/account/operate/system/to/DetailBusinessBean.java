package kr.co.seoulit.account.operate.system.to;

public class DetailBusinessBean {
	   private String detailBusinessName;
	    private String ChildClassificationCode;
	    private String remarks;
		public String getDetailBusinessName() {
			return detailBusinessName;
		}
		public void setDetailBusinessName(String detailBusinessName) {
			this.detailBusinessName = detailBusinessName;
		}
		public String getClassificationCode() {
			return ChildClassificationCode;
		}
		public void setClassificationCode(String classificationCode) {
			this.ChildClassificationCode = classificationCode;
		}
		public String getRemarks() {
			return remarks;
		}
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
	    
	    
}
