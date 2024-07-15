package com.study.spring.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude="memberRoleList")
public class Member {

	@Id
	private String email;
	
	private String pw;
	private String nickname;
	private boolean social;
	
	@ElementCollection
	@Builder.Default
	private List<MemberRole> memberRoleList = new ArrayList<>();
	
	public void addRole(MemberRole memberRole) {
		memberRoleList.add(memberRole);
	}
	
	public void clearRoles() {
		memberRoleList.clear();
	}

	public void changePw(String pw) {
		this.pw = pw;
	}

	public void changeNickname(String nickname) {
		this.nickname = nickname;
	}

	public void changeSocial(boolean social) {
		this.social = social;
	}
	
	
	
	
	
}
