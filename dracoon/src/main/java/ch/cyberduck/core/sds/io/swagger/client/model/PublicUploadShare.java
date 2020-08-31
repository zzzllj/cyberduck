/*
 * DRACOON API
 * REST Web Services for DRACOON<br>built at: 2020-08-24 08:39:45<br><br>This page provides an overview of all available and documented DRACOON APIs, which are grouped by tags.<br>Each tag provides a collection of APIs that are intended for a specific area of the DRACOON.<br><br><a title='Developer Information' href='https://developer.dracoon.com'>Developer Information</a>&emsp;&emsp;<a title='Get SDKs on GitHub' href='https://github.com/dracoon'>Get SDKs on GitHub</a><br><br><a title='Terms of service' href='https://www.dracoon.com/terms/general-terms-and-conditions/'>Terms of service</a>
 *
 * OpenAPI spec version: 4.23.0-beta.4
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.sds.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import ch.cyberduck.core.sds.io.swagger.client.model.PublicUploadedFileData;
import ch.cyberduck.core.sds.io.swagger.client.model.UserUserPublicKeyList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
/**
 * Upload Share information
 */
@Schema(description = "Upload Share information")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-08-31T11:26:27.086143+02:00[Europe/Zurich]")
public class PublicUploadShare {
  @JsonProperty("isProtected")
  private Boolean isProtected = null;

  @JsonProperty("createdAt")
  private DateTime createdAt = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("isEncrypted")
  private Boolean isEncrypted = null;

  @JsonProperty("expireAt")
  private DateTime expireAt = null;

  @JsonProperty("notes")
  private String notes = null;

  @JsonProperty("uploadedFiles")
  private List<PublicUploadedFileData> uploadedFiles = null;

  @JsonProperty("userUserPublicKeyList")
  private UserUserPublicKeyList userUserPublicKeyList = null;

  @JsonProperty("showUploadedFiles")
  private Boolean showUploadedFiles = null;

  @JsonProperty("remainingSize")
  private Long remainingSize = null;

  @JsonProperty("remainingSlots")
  private Integer remainingSlots = null;

  @JsonProperty("creatorName")
  private String creatorName = null;

  @JsonProperty("creatorUsername")
  private String creatorUsername = null;

  @JsonProperty("maxSlots")
  private Integer maxSlots = null;

  @JsonProperty("maxSize")
  private Double maxSize = null;

  public PublicUploadShare isProtected(Boolean isProtected) {
    this.isProtected = isProtected;
    return this;
  }

   /**
   * Is share protected by password
   * @return isProtected
  **/
  @Schema(required = true, description = "Is share protected by password")
  public Boolean isIsProtected() {
    return isProtected;
  }

  public void setIsProtected(Boolean isProtected) {
    this.isProtected = isProtected;
  }

  public PublicUploadShare createdAt(DateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Creation date
   * @return createdAt
  **/
  @Schema(required = true, description = "Creation date")
  public DateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(DateTime createdAt) {
    this.createdAt = createdAt;
  }

  public PublicUploadShare name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Share display name (alias name)
   * @return name
  **/
  @Schema(description = "Share display name (alias name)")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PublicUploadShare isEncrypted(Boolean isEncrypted) {
    this.isEncrypted = isEncrypted;
    return this;
  }

   /**
   * Encryption state
   * @return isEncrypted
  **/
  @Schema(description = "Encryption state")
  public Boolean isIsEncrypted() {
    return isEncrypted;
  }

  public void setIsEncrypted(Boolean isEncrypted) {
    this.isEncrypted = isEncrypted;
  }

  public PublicUploadShare expireAt(DateTime expireAt) {
    this.expireAt = expireAt;
    return this;
  }

   /**
   * Expiration date
   * @return expireAt
  **/
  @Schema(description = "Expiration date")
  public DateTime getExpireAt() {
    return expireAt;
  }

  public void setExpireAt(DateTime expireAt) {
    this.expireAt = expireAt;
  }

  public PublicUploadShare notes(String notes) {
    this.notes = notes;
    return this;
  }

   /**
   * User notes
   * @return notes
  **/
  @Schema(description = "User notes")
  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public PublicUploadShare uploadedFiles(List<PublicUploadedFileData> uploadedFiles) {
    this.uploadedFiles = uploadedFiles;
    return this;
  }

  public PublicUploadShare addUploadedFilesItem(PublicUploadedFileData uploadedFilesItem) {
    if (this.uploadedFiles == null) {
      this.uploadedFiles = new ArrayList<>();
    }
    this.uploadedFiles.add(uploadedFilesItem);
    return this;
  }

   /**
   * List of (public) uploaded files
   * @return uploadedFiles
  **/
  @Schema(description = "List of (public) uploaded files")
  public List<PublicUploadedFileData> getUploadedFiles() {
    return uploadedFiles;
  }

  public void setUploadedFiles(List<PublicUploadedFileData> uploadedFiles) {
    this.uploadedFiles = uploadedFiles;
  }

  public PublicUploadShare userUserPublicKeyList(UserUserPublicKeyList userUserPublicKeyList) {
    this.userUserPublicKeyList = userUserPublicKeyList;
    return this;
  }

   /**
   * Get userUserPublicKeyList
   * @return userUserPublicKeyList
  **/
  @Schema(description = "")
  public UserUserPublicKeyList getUserUserPublicKeyList() {
    return userUserPublicKeyList;
  }

  public void setUserUserPublicKeyList(UserUserPublicKeyList userUserPublicKeyList) {
    this.userUserPublicKeyList = userUserPublicKeyList;
  }

  public PublicUploadShare showUploadedFiles(Boolean showUploadedFiles) {
    this.showUploadedFiles = showUploadedFiles;
    return this;
  }

   /**
   * Allow display of already uploaded files
   * @return showUploadedFiles
  **/
  @Schema(description = "Allow display of already uploaded files")
  public Boolean isShowUploadedFiles() {
    return showUploadedFiles;
  }

  public void setShowUploadedFiles(Boolean showUploadedFiles) {
    this.showUploadedFiles = showUploadedFiles;
  }

  public PublicUploadShare remainingSize(Long remainingSize) {
    this.remainingSize = remainingSize;
    return this;
  }

   /**
   * Remaining size
   * @return remainingSize
  **/
  @Schema(description = "Remaining size")
  public Long getRemainingSize() {
    return remainingSize;
  }

  public void setRemainingSize(Long remainingSize) {
    this.remainingSize = remainingSize;
  }

  public PublicUploadShare remainingSlots(Integer remainingSlots) {
    this.remainingSlots = remainingSlots;
    return this;
  }

   /**
   * Remaining slots
   * @return remainingSlots
  **/
  @Schema(description = "Remaining slots")
  public Integer getRemainingSlots() {
    return remainingSlots;
  }

  public void setRemainingSlots(Integer remainingSlots) {
    this.remainingSlots = remainingSlots;
  }

  public PublicUploadShare creatorName(String creatorName) {
    this.creatorName = creatorName;
    return this;
  }

   /**
   * &amp;#128640; Since v4.11.0  Creator name
   * @return creatorName
  **/
  @Schema(required = true, description = "&#128640; Since v4.11.0  Creator name")
  public String getCreatorName() {
    return creatorName;
  }

  public void setCreatorName(String creatorName) {
    this.creatorName = creatorName;
  }

  public PublicUploadShare creatorUsername(String creatorUsername) {
    this.creatorUsername = creatorUsername;
    return this;
  }

   /**
   * &amp;#128640; Since v4.11.0  Creator username
   * @return creatorUsername
  **/
  @Schema(description = "&#128640; Since v4.11.0  Creator username")
  public String getCreatorUsername() {
    return creatorUsername;
  }

  public void setCreatorUsername(String creatorUsername) {
    this.creatorUsername = creatorUsername;
  }

  public PublicUploadShare maxSlots(Integer maxSlots) {
    this.maxSlots = maxSlots;
    return this;
  }

   /**
   * &amp;#128679; Deprecated since v4.2.0  Maximal amount of files to upload
   * @return maxSlots
  **/
  @Schema(required = true, description = "&#128679; Deprecated since v4.2.0  Maximal amount of files to upload")
  public Integer getMaxSlots() {
    return maxSlots;
  }

  public void setMaxSlots(Integer maxSlots) {
    this.maxSlots = maxSlots;
  }

  public PublicUploadShare maxSize(Double maxSize) {
    this.maxSize = maxSize;
    return this;
  }

   /**
   * &amp;#128679; Deprecated since v4.2.0  Maximal total size of uploaded files (in bytes)
   * @return maxSize
  **/
  @Schema(description = "&#128679; Deprecated since v4.2.0  Maximal total size of uploaded files (in bytes)")
  public Double getMaxSize() {
    return maxSize;
  }

  public void setMaxSize(Double maxSize) {
    this.maxSize = maxSize;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PublicUploadShare publicUploadShare = (PublicUploadShare) o;
    return Objects.equals(this.isProtected, publicUploadShare.isProtected) &&
        Objects.equals(this.createdAt, publicUploadShare.createdAt) &&
        Objects.equals(this.name, publicUploadShare.name) &&
        Objects.equals(this.isEncrypted, publicUploadShare.isEncrypted) &&
        Objects.equals(this.expireAt, publicUploadShare.expireAt) &&
        Objects.equals(this.notes, publicUploadShare.notes) &&
        Objects.equals(this.uploadedFiles, publicUploadShare.uploadedFiles) &&
        Objects.equals(this.userUserPublicKeyList, publicUploadShare.userUserPublicKeyList) &&
        Objects.equals(this.showUploadedFiles, publicUploadShare.showUploadedFiles) &&
        Objects.equals(this.remainingSize, publicUploadShare.remainingSize) &&
        Objects.equals(this.remainingSlots, publicUploadShare.remainingSlots) &&
        Objects.equals(this.creatorName, publicUploadShare.creatorName) &&
        Objects.equals(this.creatorUsername, publicUploadShare.creatorUsername) &&
        Objects.equals(this.maxSlots, publicUploadShare.maxSlots) &&
        Objects.equals(this.maxSize, publicUploadShare.maxSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isProtected, createdAt, name, isEncrypted, expireAt, notes, uploadedFiles, userUserPublicKeyList, showUploadedFiles, remainingSize, remainingSlots, creatorName, creatorUsername, maxSlots, maxSize);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PublicUploadShare {\n");
    
    sb.append("    isProtected: ").append(toIndentedString(isProtected)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    isEncrypted: ").append(toIndentedString(isEncrypted)).append("\n");
    sb.append("    expireAt: ").append(toIndentedString(expireAt)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    uploadedFiles: ").append(toIndentedString(uploadedFiles)).append("\n");
    sb.append("    userUserPublicKeyList: ").append(toIndentedString(userUserPublicKeyList)).append("\n");
    sb.append("    showUploadedFiles: ").append(toIndentedString(showUploadedFiles)).append("\n");
    sb.append("    remainingSize: ").append(toIndentedString(remainingSize)).append("\n");
    sb.append("    remainingSlots: ").append(toIndentedString(remainingSlots)).append("\n");
    sb.append("    creatorName: ").append(toIndentedString(creatorName)).append("\n");
    sb.append("    creatorUsername: ").append(toIndentedString(creatorUsername)).append("\n");
    sb.append("    maxSlots: ").append(toIndentedString(maxSlots)).append("\n");
    sb.append("    maxSize: ").append(toIndentedString(maxSize)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
