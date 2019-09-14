package fpt.bitcoin.service;

import fpt.bitcoin.entity.Coin;
import fpt.bitcoin.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
@Service
public class CoinSeriveImpl implements CoinService{

    @Autowired
    private CoinRepository coinRepository;
    @Override
    public Page<Coin> getList(int page, int limit) {

        return coinRepository.findAllByStatus(1,
                PageRequest.of(page - 1,limit, Sort.by("createdAt").descending()));
    }

    @Override
    public Coin create(Coin coin) {
        coin.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        coin.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        coin.setStatus(1);
        return coinRepository.save(coin);
    }

    @Override
    public Page<Coin> getListByName(String name, int page, int limit) {
        return coinRepository.findAllByName(name,
                PageRequest.of(page - 1,limit, Sort.by("createdAt").descending()));
    }

    @Override
    public Page<Coin> getListByMaketId(long maketId, int page, int limit) {
        return coinRepository.findAllByMarketId(maketId,
                PageRequest.of(page - 1,limit, Sort.by("createdAt").descending()));
    }


}
