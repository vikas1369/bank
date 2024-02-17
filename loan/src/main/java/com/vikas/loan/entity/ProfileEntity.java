package com.vikas.loan.entity;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;


@Table("profile")
public class ProfileEntity {
    @PrimaryKeyColumn(
            name = "profile_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String id;

    @PrimaryKeyColumn(
            name = "lob", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String lob;
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

    public String getLob() {
        return lob;
    }

    public void setLob(String lob) {
        this.lob = lob;
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
