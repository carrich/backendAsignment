package fpt.bitcoin.service;

import fpt.bitcoin.entity.Coin;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CoinService {
    Page<Coin> getList(int page, int limit);

    Coin create(Coin account);



    Page<Coin> getListByName(String name,int page, int limit);

    Page<Coin> getListByMaketId(long MaketId,int page, int limit);


}
