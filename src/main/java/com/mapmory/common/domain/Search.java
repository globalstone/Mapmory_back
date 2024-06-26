package com.mapmory.common.domain;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.mapmory.services.map.domain.SearchMarker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Search {
	private int searchCondition;
	private String searchKeyword;
	private String userId;
	private int categoryNo;
	private int currentPage;
	private int pageSize;
	private int endRowNum;
	private int startRowNum;	
	private int limit;
	private int offset;
	
	private Integer sharedType;
	private Integer tempType;
	private Integer timecapsuleType;
	private LocalDate selectDate;
	private LocalDateTime selectDay1;
	private LocalDateTime selectDay2;

	private int radius;
	private Double latitude;
	private Double longitude;
	private Integer followType;

	public int getOffset() {
		return (getCurrentPage() - 1) * getLimit();
	}
	
	public int getEndRowNum() {
		return getCurrentPage() * getPageSize();
	}
	
	public int getStartRowNum() {
		return (getCurrentPage()-1) * getPageSize()+1;
	}
}
