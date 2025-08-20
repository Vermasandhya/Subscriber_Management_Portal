package com.CallHistory;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CallHistoryRepository extends JpaRepository<CallHistory, Long> {
    List<CallHistory> findByCallerNumber(String callerNumber);
}
