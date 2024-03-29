package kr.co.seoulit.account.sys.base.to;

public class MenuBean {
    String MenuCode;
    String MenuName;
    String ParentMenuCode;
    String Url;
    String PositionCode;
    String Authority;


    public String getAuthority() {
		return Authority;
	}

	public void setAuthority(String Authority) {
		this.Authority = Authority;
	}

	public String getPositionCode() {
        return PositionCode;
    }

    public void setPositionCode(String positionCode) {
        PositionCode = positionCode;
    }

    public String getMenuCode() {
        return MenuCode;
    }

    public void setMenuCode(String menuCode) {
        MenuCode = menuCode;
    }

    public String getMenuName() {
        return MenuName;
    }

    public void setMenuName(String menuName) {
        MenuName = menuName;
    }

    public String getParentMenuCode() {
        return ParentMenuCode;
    }

    public void setParentMenuCode(String parentMenuCode) {
        ParentMenuCode = parentMenuCode;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

}
