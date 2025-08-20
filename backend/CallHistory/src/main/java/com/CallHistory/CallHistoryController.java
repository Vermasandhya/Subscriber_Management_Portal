package com.CallHistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calls")
public class CallHistoryController {

    @Autowired
    private CallHistoryRepository repository;

    // POST /calls - Add new call
    @PostMapping
    public CallHistory createCall(@RequestBody CallHistory callRecord) {
        return repository.save(callRecord);
    }

    // GET /calls - Get all calls
    @GetMapping
    public List<CallHistory> getAllCalls() {
        return repository.findAll();
    }

    // GET /calls/caller/{callerNumber} - Get calls by caller
    @GetMapping("/caller/{callerNumber}")
    public List<CallHistory> getCallsByCaller(@PathVariable String callerNumber) {
        return repository.findByCallerNumber(callerNumber);
    }

    // DELETE /calls/{id} - Delete a call record
    @DeleteMapping("/{id}")
    public void deleteCall(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
