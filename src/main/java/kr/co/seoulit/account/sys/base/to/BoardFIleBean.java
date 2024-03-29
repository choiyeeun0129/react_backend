package kr.co.seoulit.account.sys.base.to;

public class BoardFIleBean {
    private int fileId;
    private int boardId;
    private String fileName;
    private String fileOriName;
    private String fileUrl;

    public int getId() {
        return fileId;
    }

    public void setId(int fileId) {
        this.fileId = this.fileId;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
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
