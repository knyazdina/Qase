package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectRq {

    String title;
    String code;
    String description;
    String access;
    String group;

}
