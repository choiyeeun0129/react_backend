package kr.co.seoulit.account.operate.system.service;

import kr.co.seoulit.account.operate.system.entity.AccountEntity;
import kr.co.seoulit.account.operate.system.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JpaAccountSerivceImpl implements JpaAccountService{
    @Autowired
    AccountRepository accountRepository;

    @Override
    public ArrayList<AccountEntity> findParentAccountList(String accountInnerCode, ArrayList<String> parentAccountInnerCode) {
        ArrayList<AccountEntity> account = accountRepository.findByAccountInnerCodeLikeAndParentAccountInnerCodeNotInOrderByAccountInnerCode(accountInnerCode, parentAccountInnerCode);
        return account;
    }

    @Override
    public ArrayList<AccountEntity> findDetailAccountList(String code) {
        ArrayList<AccountEntity> account = accountRepository.findByAccountInnerCodeLikeAndParentAccountInnerCodeNotInOrderByAccountInnerCode(code);
        return account;
    }
}
