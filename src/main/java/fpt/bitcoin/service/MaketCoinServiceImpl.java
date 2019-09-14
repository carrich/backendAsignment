package fpt.bitcoin.service;

import fpt.bitcoin.entity.MaketCoin;
import fpt.bitcoin.repository.MaketCoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class MaketCoinServiceImpl implements MaketCoinSerive {
    @Autowired
    private MaketCoinRepository maketCoinRepository;
    @Override
    public Page<MaketCoin> getList(int page, int limit) {
        return maketCoinRepository.findAllByStatus(1,
                PageRequest.of(page - 1,limit, Sort.by("createdAt").descending()));
    }

    @Override
    public MaketCoin create(MaketCoin maketCoin) {
        maketCoin.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        maketCoin.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        maketCoin.setStatus(1);
        return maketCoinRepository.save(maketCoin);
    }
}
