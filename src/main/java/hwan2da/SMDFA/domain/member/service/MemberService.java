package hwan2da.SMDFA.domain.member.service;

import hwan2da.SMDFA.domain.member.model.dto.CreateMemberRequest;

public interface MemberService {
    Long registerMember(CreateMemberRequest request);
}
