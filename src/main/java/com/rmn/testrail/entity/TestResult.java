package com.rmn.testrail.entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * @author mmerrell
 *
 * If you have custom fields on TestResults in TestRails, it will be necessary to extend this class and add those fields in order to capture them.
 * Otherwise they will be ignored.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestResult extends BaseEntity implements Serializable {
    @JsonProperty("status_id")
    private Integer statusId;
    public Integer getStatusId() { return statusId; }
    public void setStatusId(Integer statusId) { this.statusId = statusId; }

    @JsonProperty("assignedto_id")
    private Integer assignedtoId;
    public Integer getAssignedtoId() { return assignedtoId; }
    public void setAssignedtoId(Integer assignedtoId) { this.assignedtoId = assignedtoId; }

    @JsonProperty("comment")
    private String comment = "";
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    @JsonProperty("version")
    private String version;
    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }

    @JsonProperty("elapsed")
    private String elapsed;
    public String getElapsed() { return elapsed; }
    public void setElapsed(String elapsed) { this.elapsed = elapsed; }

    @JsonProperty("defects")
    private String defects;
    public String getDefects() { return defects; }
    public void setDefects(String defects) { this.defects = defects; }

    /**
     * Set the Verdict for this TestResult (does not actually send the update to the TestRails Service)
     * @param verdict
     */
    public void setVerdict(String verdict) {
        this.statusId = TestStatus.getStatus(verdict);
    }

    /**
     * Set the verdict by using the actual StatusId (useful for customizations). Alternatively, you can extend the TestStatus
     *  class and add custom status key-value pairs to it. This method can't be overloaded to match setVerdict(int), because
     *  it confuses Jackson's Serializer
     * @param verdict
     */
    public void setVerdictId(int verdict) {
        this.statusId = verdict;
    }
}
