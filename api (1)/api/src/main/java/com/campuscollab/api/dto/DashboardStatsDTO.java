package com.campuscollab.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardStatsDTO {
    private long skillCount;
    private long eventCount;
    private long jobCount;
    private long messageCount;
}
