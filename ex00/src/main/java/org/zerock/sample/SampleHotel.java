package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Component
@RequiredArgsConstructor
@Setter
public class SampleHotel {
	
	@NonNull
	private Chef chef;
	
	private String str="샘플호텔";
		
}
