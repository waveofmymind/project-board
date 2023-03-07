package wave.projectboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wave.projectboard.domain.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
}
