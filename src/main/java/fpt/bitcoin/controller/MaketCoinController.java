package fpt.bitcoin.controller;

import fpt.bitcoin.entity.Coin;
import fpt.bitcoin.entity.MaketCoin;
import fpt.bitcoin.service.CoinService;
import fpt.bitcoin.service.MaketCoinSerive;
import fpt.bitcoin.util.RESTPagination;
import fpt.bitcoin.util.RESTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/api/v1/maketcCoins")
@CrossOrigin
public class MaketCoinController {
    @Autowired
    private MaketCoinSerive maketCoinSerive;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<MaketCoin> store(@RequestBody MaketCoin maketCoin) {
        return new ResponseEntity<>(maketCoinSerive.create(maketCoin), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> list(
            @RequestParam(defaultValue = "1", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int limit) {

        Page<MaketCoin> accountPage = maketCoinSerive.getList(page, limit);


        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("status", HttpStatus.OK.value());
        hashMap.put("message", "Success");
        hashMap.put("data", accountPage.getContent());

        HashMap<String, Object> paginationMap = new HashMap<>();
        paginationMap.put("totalPage", accountPage.getTotalPages());
        paginationMap.put("totalItem", accountPage.getTotalElements());
        paginationMap.put("currentPage", accountPage.getPageable().getPageNumber());
        paginationMap.put("limit", accountPage.getPageable().getPageSize());

        hashMap.put("pagination", paginationMap);


        return new ResponseEntity<>(new RESTResponse.Success()
                .addDatas(accountPage.getContent())
                .setPagination(new RESTPagination(page,limit,accountPage.getTotalPages(),accountPage.getNumberOfElements()))
                .setMessage("Acction Success")
                .setStatus(HttpStatus.OK.value())
                .buildDatas(), HttpStatus.OK);


    }

}
