package hwan.demo.domain.member.service;

import hwan.demo.domain.member.model.dto.CreateMemberRequest;

public interface MemberService {
    Long registerMember(CreateMemberRequest request);
}
