/*
 * DRACOON
 * Version 4.4.0 - built at: 2017-12-04 04:14:43, API server: https://demo.dracoon.com/api/v4
 *
 * OpenAPI spec version: 4.4.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package ch.cyberduck.core.sds.io.swagger.client.model;

import java.util.Objects;
import ch.cyberduck.core.sds.io.swagger.client.model.AuthMethod;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * SystemInfo
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-03T10:55:56.129+02:00")
public class SystemInfo {
  @JsonProperty("authMethods")
  private List<AuthMethod> authMethods = new ArrayList<AuthMethod>();

  @JsonProperty("defaultLanguage")
  private String defaultLanguage = null;

  public SystemInfo authMethods(List<AuthMethod> authMethods) {
    this.authMethods = authMethods;
    return this;
  }

  public SystemInfo addAuthMethodsItem(AuthMethod authMethodsItem) {
    this.authMethods.add(authMethodsItem);
    return this;
  }

   /**
   * Available authentication methods
   * @return authMethods
  **/
  @ApiModelProperty(required = true, value = "Available authentication methods")
  public List<AuthMethod> getAuthMethods() {
    return authMethods;
  }

  public void setAuthMethods(List<AuthMethod> authMethods) {
    this.authMethods = authMethods;
  }

  public SystemInfo defaultLanguage(String defaultLanguage) {
    this.defaultLanguage = defaultLanguage;
    return this;
  }

   /**
   * System default language (RFC5646 notation)
   * @return defaultLanguage
  **/
  @ApiModelProperty(required = true, value = "System default language (RFC5646 notation)")
  public String getDefaultLanguage() {
    return defaultLanguage;
  }

  public void setDefaultLanguage(String defaultLanguage) {
    this.defaultLanguage = defaultLanguage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemInfo systemInfo = (SystemInfo) o;
    return Objects.equals(this.authMethods, systemInfo.authMethods) &&
        Objects.equals(this.defaultLanguage, systemInfo.defaultLanguage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authMethods, defaultLanguage);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemInfo {\n");
    
    sb.append("    authMethods: ").append(toIndentedString(authMethods)).append("\n");
    sb.append("    defaultLanguage: ").append(toIndentedString(defaultLanguage)).append("\n");
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
