package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CaseRq {

    String title;
    int severity;
    int priority;
    int behavior;
    int type;
    int layer;
    int automation;
    String action;
    String expected_result;
    String preconditions;
    String postconditions;
    String description;
}
