package kr.co.seoulit.account.posting.business.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.posting.business.to.JournalBean;
import kr.co.seoulit.account.posting.business.to.SlipBean;

@Mapper
public interface SlipApprovalAndReturnMapper {
	
    public void updateapproveSlip(SlipBean slipBean);
    
    public ArrayList<SlipBean> selectDisApprovalSlipList();
    
    public ArrayList<JournalBean> selectApprovalJournalList(String slipNo);
}
