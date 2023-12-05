package ch.zli.m223.model;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDate;

@Entity
public class Reservation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;

  @Column(nullable = false)
  private LocalDate reservationDate;

  @Column(nullable = false)
  private String reservationTimespan;

  @Column
  private String description;

  @Column(nullable = false)
  private String approval;

  @Column(nullable = false)
  private String approvalMessage;

  @ManyToOne(optional = false)
  @Fetch(FetchMode.JOIN)
  private ApplicationUser applicationUser;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDate getReservationDate() {
    return reservationDate;
  }

  public void setReservationDate(LocalDate reservationDate) {
    this.reservationDate = reservationDate;
  }

 public String ReservationTimespan() {
    return reservationTimespan;
  }

  public void ReservationTimespan(String reservationTimespan) {
    this.reservationTimespan = reservationTimespan;
  }

  public ApplicationUser getApplicationUser() {
    return applicationUser;
  }

  public void setApplicationUser(ApplicationUser applicationUser) {
    this.applicationUser = applicationUser;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getApproval() {
    return approval;
  }

  public void setApproval(String approval) {
    this.approval = approval;
  }

  public String getApprovalMessage() {
    return approvalMessage;
  }

  public void setApprovalMessage(String approvalMessage) {
    this.approvalMessage = approvalMessage;
  }
}