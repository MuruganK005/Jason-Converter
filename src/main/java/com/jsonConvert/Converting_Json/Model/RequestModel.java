
package com.jsonConvert.Converting_Json.Model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class RequestModel implements Serializable {

    private long id;
    private String name;
    private List<SkillSet> skillSet;
}

@Setter
@Getter
class SkillSet {
    private String skillName;
    private String category;
}
