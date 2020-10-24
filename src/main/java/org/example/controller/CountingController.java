package org.example.controller;

import org.example.model.Transaction;
import org.example.service.AccountService;
import org.example.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CountingController {
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private AccountService accountService;
    private TransactionService transactionService;

    @Autowired
    public void setAccountAndTransactionService(AccountService accountService, TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    @GetMapping (value = "/")
    public ModelAndView accounts() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("accounts", accountService.getAllAccounts());
        modelAndView.addObject("transactions", transactionService.getAllTransactions());
        return modelAndView;
    }
    @PostMapping(value = "/delete")
    public ModelAndView deleteAccount(@RequestParam("deleteAcc") int id){
        accountService.deleteAccountById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
    @PostMapping(value = "/expense")
    public ModelAndView expense(
            @RequestParam(value = "expense") int count,
            @RequestParam(value = "id") int id){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");

        accountService.updateExpense(accountService.findById(id), count);
        return modelAndView;
    }

    @PostMapping(value = "/income")
    public ModelAndView income(
            @RequestParam(value = "income") int count,
            @RequestParam(value = "id") int id){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");

        accountService.updateIncome(accountService.findById(id), count);
        return modelAndView;
    }
    @PostMapping(value = "/transfer")
    public ModelAndView transfer(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");

        String transferFrom = request.getParameter("fromAcc");
        String transferTo = request.getParameter("toAcc");
        Integer quantity = Integer.valueOf(request.getParameter("how_much"));

        accountService.updateIncome(accountService.findByName(transferTo), quantity);
        accountService.updateExpense(accountService.findByName(transferFrom), quantity);


        transactionService.add(new Transaction(transferFrom, transferTo, quantity, new Date()));

        return modelAndView;
    }
}

