package kr.co.seoulit.account.posting.business.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.account.posting.business.to.SlipBean;

@Mapper
public interface SlipMapper {

    public void deleteSlip(String slipNo);

    public void updateSlip(SlipBean slipBean);

    public void insertSlip(SlipBean slipBean);

    public ArrayList<SlipBean> selectRangedSlipList(HashMap<String, Object> map);

    public int selectSlipCount(String today);
    
    public ArrayList<SlipBean> selectSlipDataList(String slipDate);
	
    public ArrayList<SlipBean> selectSlip(String slipNo);
        
    public HashMap<String, Object> selectAccountingSettlementStatus(HashMap<String, Object> param);

    public ArrayList<SlipBean> selectApprovalSlipList(HashMap<String , Object> map);
    
    public void updateSlipApproval(SlipBean slipBean);
}
