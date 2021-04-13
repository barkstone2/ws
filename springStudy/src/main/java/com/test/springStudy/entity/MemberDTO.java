package com.test.springStudy.entity;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberDTO {
	private int no;
	private String id;
	private String pw;
	private String pwc;
	private String name;
	private String gender;
	private int bornYear;
	private Timestamp regi_date;
	private String postcode;
	private String bAddr;
	private String sAddr;
	private String refAddr;
}
