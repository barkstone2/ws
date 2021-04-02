package com.test.spring01.member.entity;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String email;
	private Date regDate;
}
