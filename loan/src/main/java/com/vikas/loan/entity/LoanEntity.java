package com.vikas.loan.entity;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;


@Table("loan")
public class LoanEntity {
    @PrimaryKeyColumn(
            name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String id;

    @PrimaryKeyColumn(
            name = "line", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String line;
    @PrimaryKeyColumn(
            name = "type", ordinal = 2, type = PrimaryKeyType.PARTITIONED)
    private String type;

    @Column("attribute_json")
    private String attributeJson;

    @Column("version_id")
    private UUID versionId;

    @Column("update_dt")
    private Instant update_dt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAttributeJson() {
        return attributeJson;
    }

    public void setAttributeJson(String attributeJson) {
        this.attributeJson = attributeJson;
    }

    public UUID getVersionId() {
        return versionId;
    }

    public void setVersionId(UUID versionId) {
        this.versionId = versionId;
    }

    public Instant getUpdate_dt() {
        return update_dt;
    }

    public void setUpdate_dt(Instant update_dt) {
        this.update_dt = update_dt;
    }
}
