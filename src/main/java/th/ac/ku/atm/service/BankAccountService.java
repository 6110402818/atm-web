package th.ac.ku.atm.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.model.Customer;

import java.util.ArrayList;
import java.util.List;


@Service
public class BankAccountService {
    private ArrayList<BankAccount> BankList = new ArrayList<>();

    public void createBankAccount(BankAccount bankAccount) {
        BankList.add(bankAccount);
    }

    public List<BankAccount> getBankAccounts() {
        return new ArrayList<>(BankList);
    }

    public BankAccount findBankAccount(int id) {
        for (BankAccount bankAccount : BankList) {
            if (bankAccount.getId() == id)
                return bankAccount;
        }
        return null;
    }


}
