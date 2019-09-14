package fpt.bitcoin.service;

import fpt.bitcoin.entity.Coin;
import fpt.bitcoin.entity.MaketCoin;
import org.springframework.data.domain.Page;

public interface MaketCoinSerive {
    Page<MaketCoin> getList(int page, int limit);

    MaketCoin create(MaketCoin maketCoin);
}
