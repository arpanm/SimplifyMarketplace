package com.simplify.marketplace.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Worker.
 */
@Entity
@Table(name = "worker")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Worker implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Min(value = 1000000000)
    @Max(value = 9999999999L)
    @Column(name = "primary_phone", nullable = false)
    private Integer primaryPhone;

    @Column(name = "description")
    private String description;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @JsonIgnoreProperties(value = { "userEmails", "userPhones", "addresses" }, allowSetters = true)
    @OneToOne
    @JoinColumn(unique = true)
    private CustomUser customUser;

    @OneToMany(mappedBy = "worker")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "worker" }, allowSetters = true)
    private Set<File> files = new HashSet<>();

    @OneToMany(mappedBy = "worker")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "majorSubject", "minorSubject", "worker" }, allowSetters = true)
    private Set<Education> educations = new HashSet<>();

    @OneToMany(mappedBy = "worker")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "worker" }, allowSetters = true)
    private Set<Certificate> certificates = new HashSet<>();

    @OneToMany(mappedBy = "worker")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "locations", "company", "worker" }, allowSetters = true)
    private Set<Employment> employments = new HashSet<>();

    @OneToMany(mappedBy = "worker")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "worker" }, allowSetters = true)
    private Set<Portfolio> portfolios = new HashSet<>();

    @OneToMany(mappedBy = "worker")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "worker" }, allowSetters = true)
    private Set<Refereces> refereces = new HashSet<>();

    @OneToMany(mappedBy = "worker")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "locationPrefrences", "fieldValues", "subCategory", "worker" }, allowSetters = true)
    private Set<JobPreference> jobPreferences = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(
        name = "rel_worker__skill",
        joinColumns = @JoinColumn(name = "worker_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    @JsonIgnoreProperties(value = { "workers" }, allowSetters = true)
    private Set<SkillsMaster> skills = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Worker id(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public Worker firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public Worker middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Worker lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPrimaryPhone() {
        return this.primaryPhone;
    }

    public Worker primaryPhone(Integer primaryPhone) {
        this.primaryPhone = primaryPhone;
        return this;
    }

    public void setPrimaryPhone(Integer primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getDescription() {
        return this.description;
    }

    public Worker description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public Worker dateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public Worker createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedAt() {
        return this.createdAt;
    }

    public Worker createdAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public Worker updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDate getUpdatedAt() {
        return this.updatedAt;
    }

    public Worker updatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public CustomUser getCustomUser() {
        return this.customUser;
    }

    public Worker customUser(CustomUser customUser) {
        this.setCustomUser(customUser);
        return this;
    }

    public void setCustomUser(CustomUser customUser) {
        this.customUser = customUser;
    }

    public Set<File> getFiles() {
        return this.files;
    }

    public Worker files(Set<File> files) {
        this.setFiles(files);
        return this;
    }

    public Worker addFile(File file) {
        this.files.add(file);
        file.setWorker(this);
        return this;
    }

    public Worker removeFile(File file) {
        this.files.remove(file);
        file.setWorker(null);
        return this;
    }

    public void setFiles(Set<File> files) {
        if (this.files != null) {
            this.files.forEach(i -> i.setWorker(null));
        }
        if (files != null) {
            files.forEach(i -> i.setWorker(this));
        }
        this.files = files;
    }

    public Set<Education> getEducations() {
        return this.educations;
    }

    public Worker educations(Set<Education> educations) {
        this.setEducations(educations);
        return this;
    }

    public Worker addEducation(Education education) {
        this.educations.add(education);
        education.setWorker(this);
        return this;
    }

    public Worker removeEducation(Education education) {
        this.educations.remove(education);
        education.setWorker(null);
        return this;
    }

    public void setEducations(Set<Education> educations) {
        if (this.educations != null) {
            this.educations.forEach(i -> i.setWorker(null));
        }
        if (educations != null) {
            educations.forEach(i -> i.setWorker(this));
        }
        this.educations = educations;
    }

    public Set<Certificate> getCertificates() {
        return this.certificates;
    }

    public Worker certificates(Set<Certificate> certificates) {
        this.setCertificates(certificates);
        return this;
    }

    public Worker addCertificate(Certificate certificate) {
        this.certificates.add(certificate);
        certificate.setWorker(this);
        return this;
    }

    public Worker removeCertificate(Certificate certificate) {
        this.certificates.remove(certificate);
        certificate.setWorker(null);
        return this;
    }

    public void setCertificates(Set<Certificate> certificates) {
        if (this.certificates != null) {
            this.certificates.forEach(i -> i.setWorker(null));
        }
        if (certificates != null) {
            certificates.forEach(i -> i.setWorker(this));
        }
        this.certificates = certificates;
    }

    public Set<Employment> getEmployments() {
        return this.employments;
    }

    public Worker employments(Set<Employment> employments) {
        this.setEmployments(employments);
        return this;
    }

    public Worker addEmployment(Employment employment) {
        this.employments.add(employment);
        employment.setWorker(this);
        return this;
    }

    public Worker removeEmployment(Employment employment) {
        this.employments.remove(employment);
        employment.setWorker(null);
        return this;
    }

    public void setEmployments(Set<Employment> employments) {
        if (this.employments != null) {
            this.employments.forEach(i -> i.setWorker(null));
        }
        if (employments != null) {
            employments.forEach(i -> i.setWorker(this));
        }
        this.employments = employments;
    }

    public Set<Portfolio> getPortfolios() {
        return this.portfolios;
    }

    public Worker portfolios(Set<Portfolio> portfolios) {
        this.setPortfolios(portfolios);
        return this;
    }

    public Worker addPortfolio(Portfolio portfolio) {
        this.portfolios.add(portfolio);
        portfolio.setWorker(this);
        return this;
    }

    public Worker removePortfolio(Portfolio portfolio) {
        this.portfolios.remove(portfolio);
        portfolio.setWorker(null);
        return this;
    }

    public void setPortfolios(Set<Portfolio> portfolios) {
        if (this.portfolios != null) {
            this.portfolios.forEach(i -> i.setWorker(null));
        }
        if (portfolios != null) {
            portfolios.forEach(i -> i.setWorker(this));
        }
        this.portfolios = portfolios;
    }

    public Set<Refereces> getRefereces() {
        return this.refereces;
    }

    public Worker refereces(Set<Refereces> refereces) {
        this.setRefereces(refereces);
        return this;
    }

    public Worker addRefereces(Refereces refereces) {
        this.refereces.add(refereces);
        refereces.setWorker(this);
        return this;
    }

    public Worker removeRefereces(Refereces refereces) {
        this.refereces.remove(refereces);
        refereces.setWorker(null);
        return this;
    }

    public void setRefereces(Set<Refereces> refereces) {
        if (this.refereces != null) {
            this.refereces.forEach(i -> i.setWorker(null));
        }
        if (refereces != null) {
            refereces.forEach(i -> i.setWorker(this));
        }
        this.refereces = refereces;
    }

    public Set<JobPreference> getJobPreferences() {
        return this.jobPreferences;
    }

    public Worker jobPreferences(Set<JobPreference> jobPreferences) {
        this.setJobPreferences(jobPreferences);
        return this;
    }

    public Worker addJobPreference(JobPreference jobPreference) {
        this.jobPreferences.add(jobPreference);
        jobPreference.setWorker(this);
        return this;
    }

    public Worker removeJobPreference(JobPreference jobPreference) {
        this.jobPreferences.remove(jobPreference);
        jobPreference.setWorker(null);
        return this;
    }

    public void setJobPreferences(Set<JobPreference> jobPreferences) {
        if (this.jobPreferences != null) {
            this.jobPreferences.forEach(i -> i.setWorker(null));
        }
        if (jobPreferences != null) {
            jobPreferences.forEach(i -> i.setWorker(this));
        }
        this.jobPreferences = jobPreferences;
    }

    public Set<SkillsMaster> getSkills() {
        return this.skills;
    }

    public Worker skills(Set<SkillsMaster> skillsMasters) {
        this.setSkills(skillsMasters);
        return this;
    }

    public Worker addSkill(SkillsMaster skillsMaster) {
        this.skills.add(skillsMaster);
        skillsMaster.getWorkers().add(this);
        return this;
    }

    public Worker removeSkill(SkillsMaster skillsMaster) {
        this.skills.remove(skillsMaster);
        skillsMaster.getWorkers().remove(this);
        return this;
    }

    public void setSkills(Set<SkillsMaster> skillsMasters) {
        this.skills = skillsMasters;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Worker)) {
            return false;
        }
        return id != null && id.equals(((Worker) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Worker{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", middleName='" + getMiddleName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", primaryPhone=" + getPrimaryPhone() +
            ", description='" + getDescription() + "'" +
            ", dateOfBirth='" + getDateOfBirth() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedBy='" + getUpdatedBy() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            "}";
    }
}
