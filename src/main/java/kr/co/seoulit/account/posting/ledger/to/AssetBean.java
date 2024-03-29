package kr.co.seoulit.account.posting.ledger.to;

public class AssetBean {
	private long assetNumber;
	private String assetName, assetCode;
	
	public long getAssetNumber() {
		return assetNumber;
	}
	public void setAssetNumber(long assetNumber) {
		this.assetNumber = assetNumber;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public String getAssetCode() {
		return assetCode;
	}
	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}
}