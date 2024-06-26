package com.mapmory.services.purchase.service;

import java.io.IOException;
import java.util.List;

import com.mapmory.services.purchase.domain.Purchase;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

public interface PurchaseService {
	
	//insert
	public void addPurchase(Purchase purchase) throws Exception;
	
	//selectOne
	public Purchase getDetailPurchase(int purchaseNo) throws Exception;
	
	//selectList
	public List<Purchase> getPurchaseList(String userId) throws Exception;

	//count
	public int getPurchaseTotalCount(String userId) throws Exception;
	
	//Iamport api 결제 검증
	public IamportResponse<Payment> validatePurchase(String impUid) throws IamportResponseException, IOException;
}
