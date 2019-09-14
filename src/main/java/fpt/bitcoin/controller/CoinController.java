package fpt.bitcoin.controller;

import fpt.bitcoin.entity.Coin;
import fpt.bitcoin.service.CoinService;
import fpt.bitcoin.util.RESTPagination;
import fpt.bitcoin.util.RESTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/api/v1/coins")
@CrossOrigin
public class CoinController {
    @Autowired
    private CoinService coinService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Coin> store(@RequestBody Coin account) {
        return new ResponseEntity<>(coinService.create(account), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> list(
            @RequestParam(defaultValue = "1", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int limit) {

        Page<Coin> accountPage = coinService.getList(page, limit);


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

    @RequestMapping(method = RequestMethod.GET, value = "/name")
    public ResponseEntity<Object> searchByName(@RequestParam String name,
            @RequestParam(defaultValue = "1", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int limit) {

        Page<Coin> accountPage = coinService.getListByName(name,page, limit);


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
    @RequestMapping(method = RequestMethod.GET, value = "/{maketId}")
    public ResponseEntity<Object> searchByMaketId(@PathVariable String maketId,
                                               @RequestParam(defaultValue = "1", required = false) int page,
                                               @RequestParam(defaultValue = "10", required = false) int limit) {

        Page<Coin> accountPage = coinService.getListByName(maketId,page, limit);


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
