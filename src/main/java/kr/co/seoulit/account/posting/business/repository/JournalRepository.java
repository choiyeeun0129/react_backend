package kr.co.seoulit.account.posting.business.repository;

import kr.co.seoulit.account.posting.business.entity.JournalEntity;
import org.springframework.data.repository.CrudRepository;

public interface JournalRepository extends CrudRepository<JournalEntity, String> {

}
