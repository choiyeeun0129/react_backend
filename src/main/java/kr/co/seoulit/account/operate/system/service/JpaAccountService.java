package kr.co.seoulit.account.operate.system.service;

import kr.co.seoulit.account.operate.system.entity.AccountEntity;

import java.util.ArrayList;

public interface JpaAccountService {
    public ArrayList<AccountEntity> findParentAccountList(String accountInnerCode, ArrayList<String> parentAccountInnerCode);

    public ArrayList<AccountEntity> findDetailAccountList(String code);
}
