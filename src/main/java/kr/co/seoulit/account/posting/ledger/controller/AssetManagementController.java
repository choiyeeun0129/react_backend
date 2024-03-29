package kr.co.seoulit.account.posting.ledger.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.seoulit.account.operate.system.to.AccountBean;
import kr.co.seoulit.account.posting.ledger.to.CurrentAssetBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import kr.co.seoulit.account.posting.ledger.service.LedgerService;
import kr.co.seoulit.account.posting.ledger.service.LedgerServiceImpl;
import kr.co.seoulit.account.posting.ledger.to.AssetBean;
import kr.co.seoulit.account.posting.ledger.to.AssetItemBean;
import kr.co.seoulit.account.posting.ledger.to.DeptBean;
import kr.co.seoulit.account.sys.common.exception.DataAccessException;
import net.sf.json.JSONObject;
@CrossOrigin("*")
@RestController
@RequestMapping("/posting")
public class AssetManagementController{

	@Autowired
    private LedgerService ledgerService;



	// ================================ 고정자산 추가============================
	@GetMapping ("/findCurrentAssetList")
	public HashMap<String , Object> findCurrentAssetList(@RequestParam("accountCode") String accountCode,
														 @RequestParam("accountName") String accountName
														 ){

		HashMap<String ,Object> map =new HashMap<>();
		map.put("findCurrentAssetList",ledgerService.findCurrentAssetList(accountCode, accountName) );

		return map;
	}
	//ArrayList<CurrentAssetBean>

	@GetMapping("/CurrentAssetCode")
	public ArrayList<AccountBean> currentAssetCode(){
		return ledgerService.currentAssetCode();
	}

	@GetMapping("/assetlist") //고정자산
	public ArrayList<AssetBean> assetList() {
    	
        	ArrayList<AssetBean> AssetList = ledgerService.findAssetList();

        	return AssetList;
    }

	@GetMapping("/assetDta")
	public ArrayList<AssetItemBean> findAssetDta (@RequestParam("parentsCode") String parentsCode){
		ArrayList<AssetItemBean> assetDta = ledgerService.findAssetDta(parentsCode);
		return assetDta;
	}

	@GetMapping("/assetitemlist") //세부고정자산
    public ArrayList<AssetItemBean> assetItemList(@RequestParam("parentsCode") String parentsCode) {
    	
        	ArrayList<AssetItemBean> AssetItemList = ledgerService.findAssetItemList(parentsCode);

        	return AssetItemList;
    }
    
	@GetMapping("/deptlist")
    public ArrayList<DeptBean> deptList() {
    	
        	ArrayList<DeptBean> DeptList = ledgerService.findDeptList();

        	return DeptList;
    }
    
    @PostMapping("/assetstorage")
    public void assetStorage(@RequestParam(value="previousAssetItemCode", required=false) String previousAssetItemCode,
    								 @RequestParam(value="assetItemCode", required=false) String assetItemCode,
    								 @RequestParam(value="assetItemName", required=false) String assetItemName,
    								 @RequestParam(value="parentsCode", required=false) String parentsCode,
    								 @RequestParam(value="parentsName", required=false) String parentsName,
    								 @RequestParam(value="acquisitionDate", required=false) String acquisitionDate,
    								 @RequestParam(value="acquisitionAmount", required=false) String acquisitionAmount,
    								 @RequestParam(value="manageMentDept", required=false) String manageMentDept,
    								 @RequestParam(value="usefulLift", required=false) String usefulLift) {
    		
    	System.out.println(assetItemCode+"@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        	HashMap<String, Object> map = new HashMap<>();
        	map.put("assetItemCode", assetItemCode);
        	map.put("assetItemName", assetItemName);
        	map.put("parentsCode", parentsCode);
        	map.put("parentsName", parentsName);
        	map.put("acquisitionDate", acquisitionDate);
        	map.put("acquisitionAmount", Integer.parseInt((acquisitionAmount).replaceAll(",","")));
        	map.put("manageMentDept", manageMentDept);
        	map.put("usefulLift", usefulLift);
        	map.put("previousAssetItemCode", previousAssetItemCode);

        	
        	ledgerService.assetStorage(map);

    }
    
    @GetMapping("/assetremoval")
    public void assetRemove(@RequestParam String assetItemCode) {
    	
        	ledgerService.removeAssetItem(assetItemCode);

    }
}
