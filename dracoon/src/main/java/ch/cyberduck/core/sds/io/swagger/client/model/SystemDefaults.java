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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * System defaults
 */
@Schema(description = "System defaults")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-08-31T11:26:27.086143+02:00[Europe/Zurich]")
public class SystemDefaults {
  @JsonProperty("languageDefault")
  private String languageDefault = null;

  @JsonProperty("downloadShareDefaultExpirationPeriod")
  private Integer downloadShareDefaultExpirationPeriod = null;

  @JsonProperty("uploadShareDefaultExpirationPeriod")
  private Integer uploadShareDefaultExpirationPeriod = null;

  @JsonProperty("fileDefaultExpirationPeriod")
  private Integer fileDefaultExpirationPeriod = null;

  @JsonProperty("nonmemberViewerDefault")
  private Boolean nonmemberViewerDefault = null;

  @JsonProperty("hideLoginInputFields")
  private Boolean hideLoginInputFields = null;

  public SystemDefaults languageDefault(String languageDefault) {
    this.languageDefault = languageDefault;
    return this;
  }

   /**
   * Define which language should be default.
   * @return languageDefault
  **/
  @Schema(description = "Define which language should be default.")
  public String getLanguageDefault() {
    return languageDefault;
  }

  public void setLanguageDefault(String languageDefault) {
    this.languageDefault = languageDefault;
  }

  public SystemDefaults downloadShareDefaultExpirationPeriod(Integer downloadShareDefaultExpirationPeriod) {
    this.downloadShareDefaultExpirationPeriod = downloadShareDefaultExpirationPeriod;
    return this;
  }

   /**
   * Default expiration period for Download Shares in days.
   * @return downloadShareDefaultExpirationPeriod
  **/
  @Schema(description = "Default expiration period for Download Shares in days.")
  public Integer getDownloadShareDefaultExpirationPeriod() {
    return downloadShareDefaultExpirationPeriod;
  }

  public void setDownloadShareDefaultExpirationPeriod(Integer downloadShareDefaultExpirationPeriod) {
    this.downloadShareDefaultExpirationPeriod = downloadShareDefaultExpirationPeriod;
  }

  public SystemDefaults uploadShareDefaultExpirationPeriod(Integer uploadShareDefaultExpirationPeriod) {
    this.uploadShareDefaultExpirationPeriod = uploadShareDefaultExpirationPeriod;
    return this;
  }

   /**
   * Default expiration period for Upload Shares in days.
   * @return uploadShareDefaultExpirationPeriod
  **/
  @Schema(description = "Default expiration period for Upload Shares in days.")
  public Integer getUploadShareDefaultExpirationPeriod() {
    return uploadShareDefaultExpirationPeriod;
  }

  public void setUploadShareDefaultExpirationPeriod(Integer uploadShareDefaultExpirationPeriod) {
    this.uploadShareDefaultExpirationPeriod = uploadShareDefaultExpirationPeriod;
  }

  public SystemDefaults fileDefaultExpirationPeriod(Integer fileDefaultExpirationPeriod) {
    this.fileDefaultExpirationPeriod = fileDefaultExpirationPeriod;
    return this;
  }

   /**
   * Default expiration period for all uploaded files in days.
   * @return fileDefaultExpirationPeriod
  **/
  @Schema(description = "Default expiration period for all uploaded files in days.")
  public Integer getFileDefaultExpirationPeriod() {
    return fileDefaultExpirationPeriod;
  }

  public void setFileDefaultExpirationPeriod(Integer fileDefaultExpirationPeriod) {
    this.fileDefaultExpirationPeriod = fileDefaultExpirationPeriod;
  }

  public SystemDefaults nonmemberViewerDefault(Boolean nonmemberViewerDefault) {
    this.nonmemberViewerDefault = nonmemberViewerDefault;
    return this;
  }

   /**
   * &amp;#128640; Since v4.12.0  Defines if new users get the role Non Member Viewer by default
   * @return nonmemberViewerDefault
  **/
  @Schema(description = "&#128640; Since v4.12.0  Defines if new users get the role Non Member Viewer by default")
  public Boolean isNonmemberViewerDefault() {
    return nonmemberViewerDefault;
  }

  public void setNonmemberViewerDefault(Boolean nonmemberViewerDefault) {
    this.nonmemberViewerDefault = nonmemberViewerDefault;
  }

  public SystemDefaults hideLoginInputFields(Boolean hideLoginInputFields) {
    this.hideLoginInputFields = hideLoginInputFields;
    return this;
  }

   /**
   * &amp;#128640; Since v4.13.0  Defines if login fields should be hidden
   * @return hideLoginInputFields
  **/
  @Schema(description = "&#128640; Since v4.13.0  Defines if login fields should be hidden")
  public Boolean isHideLoginInputFields() {
    return hideLoginInputFields;
  }

  public void setHideLoginInputFields(Boolean hideLoginInputFields) {
    this.hideLoginInputFields = hideLoginInputFields;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemDefaults systemDefaults = (SystemDefaults) o;
    return Objects.equals(this.languageDefault, systemDefaults.languageDefault) &&
        Objects.equals(this.downloadShareDefaultExpirationPeriod, systemDefaults.downloadShareDefaultExpirationPeriod) &&
        Objects.equals(this.uploadShareDefaultExpirationPeriod, systemDefaults.uploadShareDefaultExpirationPeriod) &&
        Objects.equals(this.fileDefaultExpirationPeriod, systemDefaults.fileDefaultExpirationPeriod) &&
        Objects.equals(this.nonmemberViewerDefault, systemDefaults.nonmemberViewerDefault) &&
        Objects.equals(this.hideLoginInputFields, systemDefaults.hideLoginInputFields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(languageDefault, downloadShareDefaultExpirationPeriod, uploadShareDefaultExpirationPeriod, fileDefaultExpirationPeriod, nonmemberViewerDefault, hideLoginInputFields);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemDefaults {\n");
    
    sb.append("    languageDefault: ").append(toIndentedString(languageDefault)).append("\n");
    sb.append("    downloadShareDefaultExpirationPeriod: ").append(toIndentedString(downloadShareDefaultExpirationPeriod)).append("\n");
    sb.append("    uploadShareDefaultExpirationPeriod: ").append(toIndentedString(uploadShareDefaultExpirationPeriod)).append("\n");
    sb.append("    fileDefaultExpirationPeriod: ").append(toIndentedString(fileDefaultExpirationPeriod)).append("\n");
    sb.append("    nonmemberViewerDefault: ").append(toIndentedString(nonmemberViewerDefault)).append("\n");
    sb.append("    hideLoginInputFields: ").append(toIndentedString(hideLoginInputFields)).append("\n");
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
