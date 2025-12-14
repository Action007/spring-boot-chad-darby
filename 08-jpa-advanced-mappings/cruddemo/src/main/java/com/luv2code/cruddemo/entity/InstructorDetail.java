package com.luv2code.cruddemo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "youtube_channel")
  private String youtubeChannel;

  @Column(name = "hobby")
  private String hobby;

  @OneToOne(mappedBy = "instructorDetail", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
      CascadeType.REFRESH })
  private Instructor instructor;

  public InstructorDetail() {
  }

  public InstructorDetail(String youtubeChannel, String hobby) {
    this.youtubeChannel = youtubeChannel;
    this.hobby = hobby;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getYoutubeChannel() {
    return this.youtubeChannel;
  }

  public void setYoutubeChannel(String youtubeChannel) {
    this.youtubeChannel = youtubeChannel;
  }

  public String getHobby() {
    return this.hobby;
  }

  public void setHobby(String hobby) {
    this.hobby = hobby;
  }

  public Instructor getInstructor() {
    return this.instructor;
  }

  public void setInstructor(Instructor instructor) {
    this.instructor = instructor;
  }

  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", youtubeChannel='" + getYoutubeChannel() + "'" +
        ", hobby='" + getHobby() + "'" +
        "}";
  }
}
