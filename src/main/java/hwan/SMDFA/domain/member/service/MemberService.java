package hwan.SMDFA.domain.member.service;

import hwan.SMDFA.domain.member.model.dto.CreateMemberRequest;

public interface MemberService {
    Long registerMember(CreateMemberRequest request);
}
