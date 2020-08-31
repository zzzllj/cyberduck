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
 * User information
 */
@Schema(description = "User information")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-08-31T11:26:27.086143+02:00[Europe/Zurich]")
public class UserInfo {
  @JsonProperty("id")
  private Long id = null;

  /**
   * &amp;#128640; Since v4.11.0  User type:  * &#x60;internal&#x60; - ordinary DRACOON user  * &#x60;external&#x60; - external user without DRACOON account  * &#x60;system&#x60; - system user (non human &amp;#128125;)  * &#x60;deleted&#x60; - deleted DRACOON user
   */
  public enum UserTypeEnum {
    SYSTEM("system"),
    INTERNAL("internal"),
    EXTERNAL("external"),
    DELETED("deleted");

    private String value;

    UserTypeEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static UserTypeEnum fromValue(String text) {
      for (UserTypeEnum b : UserTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("userType")
  private UserTypeEnum userType = null;

  @JsonProperty("avatarUuid")
  private String avatarUuid = null;

  @JsonProperty("userName")
  private String userName = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("displayName")
  private String displayName = null;

  public UserInfo id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Unique identifier for the user
   * @return id
  **/
  @Schema(required = true, description = "Unique identifier for the user")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UserInfo userType(UserTypeEnum userType) {
    this.userType = userType;
    return this;
  }

   /**
   * &amp;#128640; Since v4.11.0  User type:  * &#x60;internal&#x60; - ordinary DRACOON user  * &#x60;external&#x60; - external user without DRACOON account  * &#x60;system&#x60; - system user (non human &amp;#128125;)  * &#x60;deleted&#x60; - deleted DRACOON user
   * @return userType
  **/
  @Schema(required = true, description = "&#128640; Since v4.11.0  User type:  * `internal` - ordinary DRACOON user  * `external` - external user without DRACOON account  * `system` - system user (non human &#128125;)  * `deleted` - deleted DRACOON user")
  public UserTypeEnum getUserType() {
    return userType;
  }

  public void setUserType(UserTypeEnum userType) {
    this.userType = userType;
  }

  public UserInfo avatarUuid(String avatarUuid) {
    this.avatarUuid = avatarUuid;
    return this;
  }

   /**
   * &amp;#128640; Since v4.11.0  Avatar UUID
   * @return avatarUuid
  **/
  @Schema(required = true, description = "&#128640; Since v4.11.0  Avatar UUID")
  public String getAvatarUuid() {
    return avatarUuid;
  }

  public void setAvatarUuid(String avatarUuid) {
    this.avatarUuid = avatarUuid;
  }

  public UserInfo userName(String userName) {
    this.userName = userName;
    return this;
  }

   /**
   * &amp;#128640; Since v4.13.0  Username (only returned for &#x60;internal&#x60; users)
   * @return userName
  **/
  @Schema(required = true, description = "&#128640; Since v4.13.0  Username (only returned for `internal` users)")
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public UserInfo firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

   /**
   * &amp;#128640; Since v4.11.0  User first name (mandatory if &#x60;userType&#x60; is &#x60;internal&#x60;)
   * @return firstName
  **/
  @Schema(required = true, description = "&#128640; Since v4.11.0  User first name (mandatory if `userType` is `internal`)")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public UserInfo lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

   /**
   * &amp;#128640; Since v4.11.0  User last name (mandatory if &#x60;userType&#x60; is &#x60;internal&#x60;)
   * @return lastName
  **/
  @Schema(required = true, description = "&#128640; Since v4.11.0  User last name (mandatory if `userType` is `internal`)")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public UserInfo email(String email) {
    this.email = email;
    return this;
  }

   /**
   * &amp;#128640; Since v4.11.0  Email 
   * @return email
  **/
  @Schema(description = "&#128640; Since v4.11.0  Email ")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserInfo title(String title) {
    this.title = title;
    return this;
  }

   /**
   * &amp;#128679; Deprecated since v4.18.0  Job title
   * @return title
  **/
  @Schema(description = "&#128679; Deprecated since v4.18.0  Job title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public UserInfo displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * &amp;#128679; Deprecated since v4.11.0  Display name  use other fields from &#x60;UserInfo&#x60; instead to combine a display name
   * @return displayName
  **/
  @Schema(description = "&#128679; Deprecated since v4.11.0  Display name  use other fields from `UserInfo` instead to combine a display name")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserInfo userInfo = (UserInfo) o;
    return Objects.equals(this.id, userInfo.id) &&
        Objects.equals(this.userType, userInfo.userType) &&
        Objects.equals(this.avatarUuid, userInfo.avatarUuid) &&
        Objects.equals(this.userName, userInfo.userName) &&
        Objects.equals(this.firstName, userInfo.firstName) &&
        Objects.equals(this.lastName, userInfo.lastName) &&
        Objects.equals(this.email, userInfo.email) &&
        Objects.equals(this.title, userInfo.title) &&
        Objects.equals(this.displayName, userInfo.displayName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userType, avatarUuid, userName, firstName, lastName, email, title, displayName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserInfo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userType: ").append(toIndentedString(userType)).append("\n");
    sb.append("    avatarUuid: ").append(toIndentedString(avatarUuid)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
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
