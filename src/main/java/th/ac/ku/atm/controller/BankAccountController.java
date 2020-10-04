package th.ac.ku.atm.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import th.ac.ku.atm.model.BankAccount;
//import th.ac.ku.atm.model.Customer;
//import th.ac.ku.atm.service.BankAccountService;
//
//@Controller
//@RequestMapping("/bankaccount")
//public class BankAccountController {
//    private BankAccountService bankAccountService;
//
//    public BankAccountController(BankAccountService bankAccountService) {
//        this.bankAccountService = bankAccountService;
//    }
//
//    @GetMapping
//    public String getBankAccountPage(Model model){
//
//        model.addAttribute("allBankAccounts", bankAccountService.getBankAccountList());
//
//        return "bankaccount";
//    }
//
//    @PostMapping
//    public String openAccount(@ModelAttribute BankAccount bankAccount, Model model) {
//        accountService.openAccount(bankAccount);
//        model.addAttribute("bankaccounts",accountService.getBankAccounts());
//        return "redirect:bankaccount";
//    }
//
//
//
//}


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.service.BankAccountService;

@Controller
@RequestMapping("/bankaccount")
public class BankAccountController {

    private BankAccountService accountService;

    public BankAccountController(BankAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public String getBankAccountPage(Model model) {
        model.addAttribute("bankaccounts", accountService.getBankAccounts());
        return "bankaccount";
    }

    @PostMapping
    public String openAccount(@ModelAttribute BankAccount bankAccount, Model model) {
        accountService.openAccount(bankAccount);
        model.addAttribute("bankaccounts",accountService.getBankAccounts());
        return "redirect:bankaccount";
    }


    @GetMapping("/edit/{id}")
    public String getEditBankAccountPage(@PathVariable int id, Model model) {
        BankAccount account = accountService.getBankAccount(id);
        model.addAttribute("bankAccount", account);
        return "bankaccount-edit";
    }

    @PostMapping("/edit/{id}")
    public String editAccount(@PathVariable int id,
                              @ModelAttribute BankAccount bankAccount,
                              Model model) {

        accountService.editBankAccount(bankAccount);
        model.addAttribute("bankaccounts",accountService.getBankAccounts());
        return "redirect:/bankaccount";
    }

    @PostMapping("/delete/{id}")
    public String  deleteAccount(@PathVariable int id,
                               Model model){

        BankAccount account = accountService.getBankAccount(id);
        accountService.deleteAccount(account);
        model.addAttribute("bankaccounts",accountService.getBankAccounts());  //load หน้า
        return "redirect:/bankaccount";
    }



    @GetMapping("/deposit/{id}")
    public String getDepositBankAccountPage(@PathVariable int id, Model model) {
        BankAccount account = accountService.getBankAccount(id);
        model.addAttribute("bankAccount", account);
        return "bankaccount-deposit";
    }

    @PostMapping("/deposit/{id}")
    public String depositAccount(@PathVariable int id,
                              @ModelAttribute BankAccount bankAccount,
                              Model model) {

        accountService.depositBankAccount(bankAccount);
        model.addAttribute("bankaccounts",accountService.getBankAccounts());
        return "redirect:/bankaccount";
    }



    @GetMapping("/withdraw/{id}")
    public String getWithdrawBankAccountPage(@PathVariable int id, Model model) {
        BankAccount account = accountService.getBankAccount(id);
        model.addAttribute("bankAccount", account);
        return "bankaccount-withdraw";
    }

    @PostMapping("/withdraw/{id}")
    public String withdrawAccount(@PathVariable int id,
                                 @ModelAttribute BankAccount bankAccount,
                                 Model model) {

        accountService.withdrawBankAccount(bankAccount);
        model.addAttribute("bankaccounts",accountService.getBankAccounts());
        return "redirect:/bankaccount";
    }





}

