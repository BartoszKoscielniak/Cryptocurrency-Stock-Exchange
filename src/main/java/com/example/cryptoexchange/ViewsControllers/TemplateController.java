package com.example.cryptoexchange.ViewsControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateController {

    @GetMapping("login")
    public String getLoginView(){
        return "login";
    }

    @GetMapping("home")
    public String getHomeView(){
        return "home";
    }

    @GetMapping("buysell")
    public String getBuySellView(){
        return "buyorsell";
    }

    @GetMapping("history")
    public String getHistoryView(){
        return "history";
    }

    @GetMapping("wallet")
    public String getWalletView(){
        return "wallet";
    }
}
