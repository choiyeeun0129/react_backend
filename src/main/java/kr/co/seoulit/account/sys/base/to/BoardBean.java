package kr.co.seoulit.account.sys.base.to;



public class BoardBean {

	private String id;
	private String title;
	private String contents;
	private String writtenBy;
	private String updateBy;
	private String writeDate;
	private String updateDateTime;
	private String lookup;
	private String boardLike;

	private String rid;
	private String bid;
	private String reContents;
	private String reWritter;
	private String reWrittedate;
	private String reUpdatedate;

	// 파일 업로드용
	private int fileId;
	private int boardId;
	private String fileName;
	private String fileOriName;
	private String fileUrl;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWrittenBy() {
		return writtenBy;
	}
	public void setWrittenBy(String writtenBy) {
		this.writtenBy = writtenBy;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getUpdateDateTime() {
		return updateDateTime;
	}
	public void setUpdateDateTime(String updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	public String getLookup() {
		return lookup;
	}
	public void setLookup(String lookup) {
		this.lookup = lookup;
	}
	public String getBoardLike() {
		return boardLike;
	}
	public void setBoardLike(String boardLike) {
		this.boardLike = boardLike;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getReContents() {
		return reContents;
	}
	public void setReContents(String reContents) {
		this.reContents = reContents;
	}
	public String getReWritter() {
		return reWritter;
	}
	public void setReWritter(String reWritter) {
		this.reWritter = reWritter;
	}
	public String getReWrittedate() {
		return reWrittedate;
	}
	public void setReWrittedate(String reWrittedate) {
		this.reWrittedate = reWrittedate;
	}
	public String getReUpdatedate() {
		return reUpdatedate;
	}
	public void setReUpdatedate(String reUpdatedate) {
		this.reUpdatedate = reUpdatedate;
	}


	public int getFileId() {
		return fileId;
	}

	public void setFileId() {
		this.fileId = fileId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId() {
		this.boardId = boardId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileOriName() {
		return fileOriName;
	}

	public void setFileOriName(String fileOriName) {
		this.fileOriName = fileOriName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
}
