package wave.projectboard.config;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import wave.projectboard.domain.UserAccount;
import wave.projectboard.dto.UserAccountDto;
import wave.projectboard.repository.UserAccountRepository;
import wave.projectboard.service.UserAccountService;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@Import(SecurityConfig.class)
public class TestSecurityConfig {

    @MockBean private UserAccountRepository userAccountRepository;
    @MockBean private UserAccountService userAccountService;

    @BeforeTestMethod
    public void securitySetUp() {
        given(userAccountService.searchUser(anyString()))
                .willReturn(Optional.of(createUserAccountDto()));
        given(userAccountService.saveUser(anyString(),anyString(),anyString(),anyString(),anyString()))
                .willReturn(createUserAccountDto());
    }

    private UserAccountDto createUserAccountDto() {
        return UserAccountDto.of(
                "unoTest",
                "pw",
                "uno-test@email.com",
                "uno-test",
                "test memo"
        );
    }
}
