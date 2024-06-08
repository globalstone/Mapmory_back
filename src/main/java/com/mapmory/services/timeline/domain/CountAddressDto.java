package com.mapmory.services.timeline.domain;


import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class CountAddressDto {
	private int checkpointCount;
	private LocalDateTime checkpointDate;
}
