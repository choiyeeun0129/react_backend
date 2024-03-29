package kr.co.seoulit.account.sys.base.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.sys.base.to.CodeBean;

@Mapper
public interface CodeMapper {

    public ArrayList<CodeBean> selectCodeList();

    public void insertCode(CodeBean codeBean);

    public void updateCode(CodeBean codeBean);

    public void deleteCode(String Code);

}
