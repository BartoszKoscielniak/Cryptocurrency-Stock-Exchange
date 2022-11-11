package com.example.cryptoexchange.ViewsControllers.buysell;

import com.example.cryptoexchange.externalRequests.CGCryptocurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(path = "/buysell")
@AllArgsConstructor
public class BuySellController {

    private final CGCryptocurrencyService cgCryptocurrencyService;
    private final BuySellService buySellService;

    @GetMapping(path = "/maxbuy")
    @ResponseBody
    public Map<String, Double> getBuyQuantity(@RequestParam String cryptoId, @RequestParam String paymentType){
        HashMap<String, Double> response = new HashMap<>();
        response.put("quantity", buySellService.buyQuantity(cryptoId, paymentType));

        return response;
    }

    @GetMapping(path = "/maxsell")
    @ResponseBody
    public String getSellQuantity(@RequestParam String id){
        buySellService.sellQuantity(id);
        //TODO: maxsell
        return "";
    }

    @PostMapping(path = "buy")
    @ResponseBody
    public Map<String, String> buyCrypto(@RequestParam String cryptoId, @RequestParam String paymentType, @RequestParam Double quantity){
        HashMap<String, String> response = new HashMap<>();

        String result = buySellService.buyCrypto(cryptoId, paymentType, quantity);

        if ( !result.equals( "success" ) )
        {
            response.put("status", "failed");
            response.put("error", result);
        }else {
            response.put("status", "success");
        }

        return response;
    }
}
