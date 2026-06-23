package com.example.weddingexam.account;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String side;        // "groom" | "bride"
    private String owner;       // 예금주 (신랑, 신랑 아버지 등)
    private String bank;        // 은행명
    private String accountNumber; // 계좌번호
    private String kakaoPayUrl; // 카카오페이 링크 (선택)
    private int sortOrder;      // 정렬 순서

    public AccountEntity() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSide() { return side; }
    public void setSide(String side) { this.side = side; }

    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }

    public String getBank() { return bank; }
    public void setBank(String bank) { this.bank = bank; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getKakaoPayUrl() { return kakaoPayUrl; }
    public void setKakaoPayUrl(String kakaoPayUrl) { this.kakaoPayUrl = kakaoPayUrl; }

    public int getSortOrder() { return sortOrder; }
    public void setSortOrder(int sortOrder) { this.sortOrder = sortOrder; }
}
