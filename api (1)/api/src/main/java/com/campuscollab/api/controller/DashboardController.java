package com.campuscollab.api.controller;

import com.campuscollab.api.dto.DashboardStatsDTO;
import com.campuscollab.api.repository.SkillPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {

    @Autowired
    private SkillPostRepository skillPostRepository;

    @GetMapping("/stats")
    public DashboardStatsDTO getDashboardStats() {
        // আসল ডেটা: ডাটাবেস থেকে মোট স্কিল পোস্টের সংখ্যা গণনা করা হচ্ছে।
        long skillCount = skillPostRepository.count();

        // ডামি ডেটা: যেহেতু এই ফিচারগুলো এখনো তৈরি হয়নি, আমরা নমুনা সংখ্যা পাঠাচ্ছি।
        long eventCount = 5; // নমুনা
        long jobCount = 8;   // নমুনা
        long messageCount = 3; // নমুনা

        return new DashboardStatsDTO(skillCount, eventCount, jobCount, messageCount);
    }
}