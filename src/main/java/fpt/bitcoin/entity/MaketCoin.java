package fpt.bitcoin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MaketCoin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long MaketId;
    private String name;
    private String description;
    private long createdAt;
    private long updatedAt;
    private int status;

    public MaketCoin() {
    }

    public Long getMaketId() {
        return MaketId;
    }

    public void setMaketId(Long maketId) {
        MaketId = maketId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
