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
import ch.cyberduck.core.sds.io.swagger.client.model.CharacterRules;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * Request model for updating shares password policies
 */
@Schema(description = "Request model for updating shares password policies")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-08-31T11:26:27.086143+02:00[Europe/Zurich]")
public class UpdateSharesPasswordPolicies {
  @JsonProperty("characterRules")
  private CharacterRules characterRules = null;

  @JsonProperty("minLength")
  private Integer minLength = null;

  @JsonProperty("rejectDictionaryWords")
  private Boolean rejectDictionaryWords = null;

  @JsonProperty("rejectUserInfo")
  private Boolean rejectUserInfo = null;

  @JsonProperty("rejectKeyboardPatterns")
  private Boolean rejectKeyboardPatterns = null;

  public UpdateSharesPasswordPolicies characterRules(CharacterRules characterRules) {
    this.characterRules = characterRules;
    return this;
  }

   /**
   * Get characterRules
   * @return characterRules
  **/
  @Schema(description = "")
  public CharacterRules getCharacterRules() {
    return characterRules;
  }

  public void setCharacterRules(CharacterRules characterRules) {
    this.characterRules = characterRules;
  }

  public UpdateSharesPasswordPolicies minLength(Integer minLength) {
    this.minLength = minLength;
    return this;
  }

   /**
   * Minimum number of characters a password must contain
   * minimum: 1
   * maximum: 1024
   * @return minLength
  **/
  @Schema(description = "Minimum number of characters a password must contain")
  public Integer getMinLength() {
    return minLength;
  }

  public void setMinLength(Integer minLength) {
    this.minLength = minLength;
  }

  public UpdateSharesPasswordPolicies rejectDictionaryWords(Boolean rejectDictionaryWords) {
    this.rejectDictionaryWords = rejectDictionaryWords;
    return this;
  }

   /**
   * Determines whether a password must NOT contain word(s) from a dictionary
   * @return rejectDictionaryWords
  **/
  @Schema(description = "Determines whether a password must NOT contain word(s) from a dictionary")
  public Boolean isRejectDictionaryWords() {
    return rejectDictionaryWords;
  }

  public void setRejectDictionaryWords(Boolean rejectDictionaryWords) {
    this.rejectDictionaryWords = rejectDictionaryWords;
  }

  public UpdateSharesPasswordPolicies rejectUserInfo(Boolean rejectUserInfo) {
    this.rejectUserInfo = rejectUserInfo;
    return this;
  }

   /**
   * Determines whether a password must NOT contain user info (first name, last name, email, user name)
   * @return rejectUserInfo
  **/
  @Schema(description = "Determines whether a password must NOT contain user info (first name, last name, email, user name)")
  public Boolean isRejectUserInfo() {
    return rejectUserInfo;
  }

  public void setRejectUserInfo(Boolean rejectUserInfo) {
    this.rejectUserInfo = rejectUserInfo;
  }

  public UpdateSharesPasswordPolicies rejectKeyboardPatterns(Boolean rejectKeyboardPatterns) {
    this.rejectKeyboardPatterns = rejectKeyboardPatterns;
    return this;
  }

   /**
   * Determines whether a password must NOT contain keyboard patterns (e.g. &#x60;qwertz&#x60;, &#x60;asdf&#x60;)  (min. 4 character pattern)
   * @return rejectKeyboardPatterns
  **/
  @Schema(description = "Determines whether a password must NOT contain keyboard patterns (e.g. `qwertz`, `asdf`)  (min. 4 character pattern)")
  public Boolean isRejectKeyboardPatterns() {
    return rejectKeyboardPatterns;
  }

  public void setRejectKeyboardPatterns(Boolean rejectKeyboardPatterns) {
    this.rejectKeyboardPatterns = rejectKeyboardPatterns;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateSharesPasswordPolicies updateSharesPasswordPolicies = (UpdateSharesPasswordPolicies) o;
    return Objects.equals(this.characterRules, updateSharesPasswordPolicies.characterRules) &&
        Objects.equals(this.minLength, updateSharesPasswordPolicies.minLength) &&
        Objects.equals(this.rejectDictionaryWords, updateSharesPasswordPolicies.rejectDictionaryWords) &&
        Objects.equals(this.rejectUserInfo, updateSharesPasswordPolicies.rejectUserInfo) &&
        Objects.equals(this.rejectKeyboardPatterns, updateSharesPasswordPolicies.rejectKeyboardPatterns);
  }

  @Override
  public int hashCode() {
    return Objects.hash(characterRules, minLength, rejectDictionaryWords, rejectUserInfo, rejectKeyboardPatterns);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateSharesPasswordPolicies {\n");
    
    sb.append("    characterRules: ").append(toIndentedString(characterRules)).append("\n");
    sb.append("    minLength: ").append(toIndentedString(minLength)).append("\n");
    sb.append("    rejectDictionaryWords: ").append(toIndentedString(rejectDictionaryWords)).append("\n");
    sb.append("    rejectUserInfo: ").append(toIndentedString(rejectUserInfo)).append("\n");
    sb.append("    rejectKeyboardPatterns: ").append(toIndentedString(rejectKeyboardPatterns)).append("\n");
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
