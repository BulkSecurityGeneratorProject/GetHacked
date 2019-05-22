package app.iut.gethacked.web.rest;

import app.iut.gethacked.domain.ThirdParty;
import app.iut.gethacked.service.ThirdpartyService;
import app.iut.gethacked.service.dto.RegisterThirdPartyMemberRequestDTO;
import app.iut.gethacked.service.dto.RegisterThirdPartyMemberResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/api/gethacked")
public class GetHackedController {

    private final ThirdpartyService delegate;

    public GetHackedController(ThirdpartyService delegate) {
        this.delegate = delegate;
    }

    @PostMapping("/register-thirdparty")
    @RolesAllowed("ROLE_ADMIN")
    public RegisterThirdPartyMemberResponseDTO registerThirdPartyMember(@RequestBody RegisterThirdPartyMemberRequestDTO req) {
        ThirdParty thirdParty = delegate.registerThirdPartyMember(req);
        return new RegisterThirdPartyMemberResponseDTO(thirdParty.getId());
    }
}
