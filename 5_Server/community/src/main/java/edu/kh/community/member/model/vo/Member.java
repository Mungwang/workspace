package edu.kh.community.member.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Lombok 라이브러리
// - VO(Value Object) 또는 DTO(Data Transfer Object)에
//	 작성되는 공통 코드 (getter/setter/생성자)를 자동 추가해주는 라이브러리
@Getter // getter 자동 추가
@Setter // setter 자동 추가
//@ToString // toString 자동 추가
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 필드를 초기화하는 매개변수 생성자

public class Member {
	
	private int memberNo;
	private String memberEmail;
	private String memberPw;
	private String memberNickname;
	private String memberTel;
	private String memberAddress;
	private String profileImage;
	private String enrollDate;
	private String secessionFlag;
	
	
	@Override
	   public String toString() {
	      return   "프로필 : "+profileImage+
	            "<br>이메일 : "+memberEmail+
	            "<br>닉네임 : "+memberNickname+
	            "<br>휴대폰 : "+memberTel+
	            "<br>주소 : "+memberAddress+
	            "<br>가입일 : "+enrollDate+"\n";
	   }
	
}
