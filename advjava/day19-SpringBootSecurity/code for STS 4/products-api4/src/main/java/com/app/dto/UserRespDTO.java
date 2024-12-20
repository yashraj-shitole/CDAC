package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRespDTO  {
	private String mesg;
	private String jwt;//access token
	//TO DO - add refresh token - long lived

}
