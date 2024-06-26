package com.mapmory.services.purchase.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Purchase {
	private int purchaseNo;
	private String userId;
	private int productNo;
	private int paymentMethod; // 0: 카드결제, 1: 카카오페이, 2: 페이코, 3: 토스페이
	private String cardType;
	private String lastFourDigits;
	private LocalDateTime purchaseDate;
	private int price;
}
