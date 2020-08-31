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
import java.util.ArrayList;
import java.util.List;
/**
 * Request model for updating a webhook
 */
@Schema(description = "Request model for updating a webhook")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-08-31T11:26:27.086143+02:00[Europe/Zurich]")
public class UpdateWebhookRequest {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("eventTypeNames")
  private List<String> eventTypeNames = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("secret")
  private String secret = null;

  @JsonProperty("isEnabled")
  private Boolean isEnabled = null;

  @JsonProperty("triggerExampleEvent")
  private Boolean triggerExampleEvent = null;

  public UpdateWebhookRequest name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name
   * @return name
  **/
  @Schema(description = "Name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UpdateWebhookRequest eventTypeNames(List<String> eventTypeNames) {
    this.eventTypeNames = eventTypeNames;
    return this;
  }

  public UpdateWebhookRequest addEventTypeNamesItem(String eventTypeNamesItem) {
    if (this.eventTypeNames == null) {
      this.eventTypeNames = new ArrayList<>();
    }
    this.eventTypeNames.add(eventTypeNamesItem);
    return this;
  }

   /**
   * List of names of event types
   * @return eventTypeNames
  **/
  @Schema(description = "List of names of event types")
  public List<String> getEventTypeNames() {
    return eventTypeNames;
  }

  public void setEventTypeNames(List<String> eventTypeNames) {
    this.eventTypeNames = eventTypeNames;
  }

  public UpdateWebhookRequest url(String url) {
    this.url = url;
    return this;
  }

   /**
   * URL (must begin with the &#x60;HTTPS&#x60; scheme)
   * @return url
  **/
  @Schema(description = "URL (must begin with the `HTTPS` scheme)")
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public UpdateWebhookRequest secret(String secret) {
    this.secret = secret;
    return this;
  }

   /**
   * Secret; used for event message signatures
   * @return secret
  **/
  @Schema(description = "Secret; used for event message signatures")
  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }

  public UpdateWebhookRequest isEnabled(Boolean isEnabled) {
    this.isEnabled = isEnabled;
    return this;
  }

   /**
   * Is enabled
   * @return isEnabled
  **/
  @Schema(description = "Is enabled")
  public Boolean isIsEnabled() {
    return isEnabled;
  }

  public void setIsEnabled(Boolean isEnabled) {
    this.isEnabled = isEnabled;
  }

  public UpdateWebhookRequest triggerExampleEvent(Boolean triggerExampleEvent) {
    this.triggerExampleEvent = triggerExampleEvent;
    return this;
  }

   /**
   * If set to true, an example event is being created
   * @return triggerExampleEvent
  **/
  @Schema(description = "If set to true, an example event is being created")
  public Boolean isTriggerExampleEvent() {
    return triggerExampleEvent;
  }

  public void setTriggerExampleEvent(Boolean triggerExampleEvent) {
    this.triggerExampleEvent = triggerExampleEvent;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateWebhookRequest updateWebhookRequest = (UpdateWebhookRequest) o;
    return Objects.equals(this.name, updateWebhookRequest.name) &&
        Objects.equals(this.eventTypeNames, updateWebhookRequest.eventTypeNames) &&
        Objects.equals(this.url, updateWebhookRequest.url) &&
        Objects.equals(this.secret, updateWebhookRequest.secret) &&
        Objects.equals(this.isEnabled, updateWebhookRequest.isEnabled) &&
        Objects.equals(this.triggerExampleEvent, updateWebhookRequest.triggerExampleEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, eventTypeNames, url, secret, isEnabled, triggerExampleEvent);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateWebhookRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    eventTypeNames: ").append(toIndentedString(eventTypeNames)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    secret: ").append(toIndentedString(secret)).append("\n");
    sb.append("    isEnabled: ").append(toIndentedString(isEnabled)).append("\n");
    sb.append("    triggerExampleEvent: ").append(toIndentedString(triggerExampleEvent)).append("\n");
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
