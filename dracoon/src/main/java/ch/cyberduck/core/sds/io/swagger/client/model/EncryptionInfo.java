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
 * Encryption states
 */
@Schema(description = "Encryption states")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-08-31T11:26:27.086143+02:00[Europe/Zurich]")
public class EncryptionInfo {
  /**
   * User key state
   */
  public enum UserKeyStateEnum {
    NONE("none"),
    AVAILABLE("available"),
    PENDING("pending");

    private String value;

    UserKeyStateEnum(String value) {
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
    public static UserKeyStateEnum fromValue(String text) {
      for (UserKeyStateEnum b : UserKeyStateEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("userKeyState")
  private UserKeyStateEnum userKeyState = null;

  /**
   * Room key state
   */
  public enum RoomKeyStateEnum {
    NONE("none"),
    AVAILABLE("available"),
    PENDING("pending");

    private String value;

    RoomKeyStateEnum(String value) {
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
    public static RoomKeyStateEnum fromValue(String text) {
      for (RoomKeyStateEnum b : RoomKeyStateEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("roomKeyState")
  private RoomKeyStateEnum roomKeyState = null;

  /**
   * DRACOON key state
   */
  public enum DataSpaceKeyStateEnum {
    NONE("none"),
    AVAILABLE("available"),
    PENDING("pending");

    private String value;

    DataSpaceKeyStateEnum(String value) {
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
    public static DataSpaceKeyStateEnum fromValue(String text) {
      for (DataSpaceKeyStateEnum b : DataSpaceKeyStateEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("dataSpaceKeyState")
  private DataSpaceKeyStateEnum dataSpaceKeyState = null;

  public EncryptionInfo userKeyState(UserKeyStateEnum userKeyState) {
    this.userKeyState = userKeyState;
    return this;
  }

   /**
   * User key state
   * @return userKeyState
  **/
  @Schema(required = true, description = "User key state")
  public UserKeyStateEnum getUserKeyState() {
    return userKeyState;
  }

  public void setUserKeyState(UserKeyStateEnum userKeyState) {
    this.userKeyState = userKeyState;
  }

  public EncryptionInfo roomKeyState(RoomKeyStateEnum roomKeyState) {
    this.roomKeyState = roomKeyState;
    return this;
  }

   /**
   * Room key state
   * @return roomKeyState
  **/
  @Schema(required = true, description = "Room key state")
  public RoomKeyStateEnum getRoomKeyState() {
    return roomKeyState;
  }

  public void setRoomKeyState(RoomKeyStateEnum roomKeyState) {
    this.roomKeyState = roomKeyState;
  }

  public EncryptionInfo dataSpaceKeyState(DataSpaceKeyStateEnum dataSpaceKeyState) {
    this.dataSpaceKeyState = dataSpaceKeyState;
    return this;
  }

   /**
   * DRACOON key state
   * @return dataSpaceKeyState
  **/
  @Schema(required = true, description = "DRACOON key state")
  public DataSpaceKeyStateEnum getDataSpaceKeyState() {
    return dataSpaceKeyState;
  }

  public void setDataSpaceKeyState(DataSpaceKeyStateEnum dataSpaceKeyState) {
    this.dataSpaceKeyState = dataSpaceKeyState;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EncryptionInfo encryptionInfo = (EncryptionInfo) o;
    return Objects.equals(this.userKeyState, encryptionInfo.userKeyState) &&
        Objects.equals(this.roomKeyState, encryptionInfo.roomKeyState) &&
        Objects.equals(this.dataSpaceKeyState, encryptionInfo.dataSpaceKeyState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userKeyState, roomKeyState, dataSpaceKeyState);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EncryptionInfo {\n");
    
    sb.append("    userKeyState: ").append(toIndentedString(userKeyState)).append("\n");
    sb.append("    roomKeyState: ").append(toIndentedString(roomKeyState)).append("\n");
    sb.append("    dataSpaceKeyState: ").append(toIndentedString(dataSpaceKeyState)).append("\n");
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
