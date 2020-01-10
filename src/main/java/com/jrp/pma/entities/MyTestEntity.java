package com.jrp.pma.entities;

import javax.persistence.*;

@Entity
public class MyTestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long mEntityId;

//    @OneToOne
//    @JoinColumn(name = "project_id")
//    private Project theProject;

    public MyTestEntity() {
    }

//    public MyEntity(Project theProject) {
//        this.theProject = theProject;
//    }

    public long getmEntityId() {
        return mEntityId;
    }

    public void setmEntityId(long mEntityId) {
        this.mEntityId = mEntityId;
    }

//    public Project getTheProject() {
//        return theProject;
//    }

//    public void setTheProject(Project theProject) {
//        this.theProject = theProject;
//    }
}
