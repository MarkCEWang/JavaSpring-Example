package com.Backend.jpa.springjpahibernateexample.model.Relationships;

import javax.persistence.*;

@Entity
@Table(name="user_set_relationship", catalog="test")
public class UserSetRelationship {
    @Id
    @Column(name = "user_set_relationship_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_set_id")
    private Integer setId;
    @Column(name = "user_uuid")
    private String uuid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSetId() {
        return setId;
    }

    public void setSetId(Integer setId) {
        this.setId = setId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
