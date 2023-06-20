package com.dp.enums;

import lombok.Getter;

@Getter
public enum Rotulos {

	ESPECIAL("-2.196998", "-46.361899", "19.766959", "-52.997614", "-15.411580", "-34.276938", "-23.966413", "-44.428305", "ESPECIAL"),
	NORMAL("-26.155681", "-54.777426", null, null, "-34.016466", "-46.603598", null, null, "NORMAL");
	
	private String minlon001;
	private String minlat001;
	private String minlon002;
	private String minlat002;
	
	private String maxlon001;
	private String maxlat001;
	private String maxlon002;
	private String maxlat002;
	
	private String label;
	
	private Rotulos(String minlon001, String minlat001, String minlon002, String minlat002
			, String maxlon001, String maxlat001, String maxlon002, String maxlat002, String label) {
		this.minlon001 = minlon001;
		this.minlat001 = minlat001;
		this.minlon002 = minlon002;
		this.minlat002 = minlat002;
		
		this.maxlon001 = maxlon001;
		this.maxlat001 = maxlat001;
		this.maxlon002 = maxlon002;
		this.maxlat002 = maxlat002;
		
		this.label = label;
	}
	
}
