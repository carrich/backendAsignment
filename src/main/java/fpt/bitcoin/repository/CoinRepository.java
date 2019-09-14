package fpt.bitcoin.repository;

import fpt.bitcoin.entity.Coin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoinRepository  extends JpaRepository<Coin, Long> {
    Page<Coin> findAllByStatus(int i, Pageable pageable);

    Page<Coin> findAllByName(String name, Pageable pageable);

    Page<Coin> findAllByMarketId(long marketId, Pageable pageable);
}
