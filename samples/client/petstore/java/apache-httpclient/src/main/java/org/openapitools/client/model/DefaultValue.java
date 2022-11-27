/*
 * OpenAPI Petstore
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.NoSuchElementException;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * DefaultValue
 */
@JsonPropertyOrder({
  DefaultValue.JSON_PROPERTY_ARRAY_STRING_ENUM_DEFAULT,
  DefaultValue.JSON_PROPERTY_ARRAY_STRING_DEFAULT,
  DefaultValue.JSON_PROPERTY_ARRAY_STRING,
  DefaultValue.JSON_PROPERTY_ARRAY_STRING_NULLABLE,
  DefaultValue.JSON_PROPERTY_STRING_NULLABLE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class DefaultValue {
  /**
   * Gets or Sets arrayStringEnumDefault
   */
  public enum ArrayStringEnumDefaultEnum {
    SUCCESS("success"),
    
    FAILURE("failure");

    private String value;

    ArrayStringEnumDefaultEnum(String value) {
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
    public static ArrayStringEnumDefaultEnum fromValue(String value) {
      for (ArrayStringEnumDefaultEnum b : ArrayStringEnumDefaultEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_ARRAY_STRING_ENUM_DEFAULT = "array_string_enum_default";
  private List<ArrayStringEnumDefaultEnum> arrayStringEnumDefault = Arrays.asList(new ArrayStringEnumDefaultEnum[] {ArrayStringEnumDefaultEnum.SUCCESS, ArrayStringEnumDefaultEnum.FAILURE});

  public static final String JSON_PROPERTY_ARRAY_STRING_DEFAULT = "array_string_default";
  private List<String> arrayStringDefault = Arrays.asList(new String[] {"failure", "skipped"});

  public static final String JSON_PROPERTY_ARRAY_STRING = "array_string";
  private List<String> arrayString = new ArrayList<>();

  public static final String JSON_PROPERTY_ARRAY_STRING_NULLABLE = "array_string_nullable";
  private JsonNullable<List<String>> arrayStringNullable = JsonNullable.<List<String>>undefined();

  public static final String JSON_PROPERTY_STRING_NULLABLE = "string_nullable";
  private JsonNullable<String> stringNullable = JsonNullable.<String>undefined();

  public DefaultValue() {
  }

  public DefaultValue arrayStringEnumDefault(List<ArrayStringEnumDefaultEnum> arrayStringEnumDefault) {
    
    this.arrayStringEnumDefault = arrayStringEnumDefault;
    return this;
  }

  public DefaultValue addArrayStringEnumDefaultItem(ArrayStringEnumDefaultEnum arrayStringEnumDefaultItem) {
    if (this.arrayStringEnumDefault == null) {
      this.arrayStringEnumDefault = new ArrayList<>();
    }
    this.arrayStringEnumDefault.add(arrayStringEnumDefaultItem);
    return this;
  }

   /**
   * Get arrayStringEnumDefault
   * @return arrayStringEnumDefault
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ARRAY_STRING_ENUM_DEFAULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<ArrayStringEnumDefaultEnum> getArrayStringEnumDefault() {
    return arrayStringEnumDefault;
  }


  @JsonProperty(JSON_PROPERTY_ARRAY_STRING_ENUM_DEFAULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setArrayStringEnumDefault(List<ArrayStringEnumDefaultEnum> arrayStringEnumDefault) {
    this.arrayStringEnumDefault = arrayStringEnumDefault;
  }


  public DefaultValue arrayStringDefault(List<String> arrayStringDefault) {
    
    this.arrayStringDefault = arrayStringDefault;
    return this;
  }

  public DefaultValue addArrayStringDefaultItem(String arrayStringDefaultItem) {
    if (this.arrayStringDefault == null) {
      this.arrayStringDefault = new ArrayList<>();
    }
    this.arrayStringDefault.add(arrayStringDefaultItem);
    return this;
  }

   /**
   * Get arrayStringDefault
   * @return arrayStringDefault
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ARRAY_STRING_DEFAULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getArrayStringDefault() {
    return arrayStringDefault;
  }


  @JsonProperty(JSON_PROPERTY_ARRAY_STRING_DEFAULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setArrayStringDefault(List<String> arrayStringDefault) {
    this.arrayStringDefault = arrayStringDefault;
  }


  public DefaultValue arrayString(List<String> arrayString) {
    
    this.arrayString = arrayString;
    return this;
  }

  public DefaultValue addArrayStringItem(String arrayStringItem) {
    if (this.arrayString == null) {
      this.arrayString = new ArrayList<>();
    }
    this.arrayString.add(arrayStringItem);
    return this;
  }

   /**
   * Get arrayString
   * @return arrayString
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ARRAY_STRING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getArrayString() {
    return arrayString;
  }


  @JsonProperty(JSON_PROPERTY_ARRAY_STRING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setArrayString(List<String> arrayString) {
    this.arrayString = arrayString;
  }


  public DefaultValue arrayStringNullable(List<String> arrayStringNullable) {
    this.arrayStringNullable = JsonNullable.<List<String>>of(arrayStringNullable);
    
    return this;
  }

  public DefaultValue addArrayStringNullableItem(String arrayStringNullableItem) {
    if (this.arrayStringNullable == null || !this.arrayStringNullable.isPresent()) {
      this.arrayStringNullable = JsonNullable.<List<String>>of(null);
    }
    try {
      this.arrayStringNullable.get().add(arrayStringNullableItem);
    } catch (java.util.NoSuchElementException e) {
      // this can never happen, as we make sure above that the value is present
    }
    return this;
  }

   /**
   * Get arrayStringNullable
   * @return arrayStringNullable
  **/
  @javax.annotation.Nullable
  @JsonIgnore

  public List<String> getArrayStringNullable() {
        return arrayStringNullable.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ARRAY_STRING_NULLABLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<List<String>> getArrayStringNullable_JsonNullable() {
    return arrayStringNullable;
  }
  
  @JsonProperty(JSON_PROPERTY_ARRAY_STRING_NULLABLE)
  public void setArrayStringNullable_JsonNullable(JsonNullable<List<String>> arrayStringNullable) {
    this.arrayStringNullable = arrayStringNullable;
  }

  public void setArrayStringNullable(List<String> arrayStringNullable) {
    this.arrayStringNullable = JsonNullable.<List<String>>of(arrayStringNullable);
  }


  public DefaultValue stringNullable(String stringNullable) {
    this.stringNullable = JsonNullable.<String>of(stringNullable);
    
    return this;
  }

   /**
   * Get stringNullable
   * @return stringNullable
  **/
  @javax.annotation.Nullable
  @JsonIgnore

  public String getStringNullable() {
        return stringNullable.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STRING_NULLABLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<String> getStringNullable_JsonNullable() {
    return stringNullable;
  }
  
  @JsonProperty(JSON_PROPERTY_STRING_NULLABLE)
  public void setStringNullable_JsonNullable(JsonNullable<String> stringNullable) {
    this.stringNullable = stringNullable;
  }

  public void setStringNullable(String stringNullable) {
    this.stringNullable = JsonNullable.<String>of(stringNullable);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DefaultValue defaultValue = (DefaultValue) o;
    return Objects.equals(this.arrayStringEnumDefault, defaultValue.arrayStringEnumDefault) &&
        Objects.equals(this.arrayStringDefault, defaultValue.arrayStringDefault) &&
        Objects.equals(this.arrayString, defaultValue.arrayString) &&
        equalsNullable(this.arrayStringNullable, defaultValue.arrayStringNullable) &&
        equalsNullable(this.stringNullable, defaultValue.stringNullable);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(arrayStringEnumDefault, arrayStringDefault, arrayString, hashCodeNullable(arrayStringNullable), hashCodeNullable(stringNullable));
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DefaultValue {\n");
    sb.append("    arrayStringEnumDefault: ").append(toIndentedString(arrayStringEnumDefault)).append("\n");
    sb.append("    arrayStringDefault: ").append(toIndentedString(arrayStringDefault)).append("\n");
    sb.append("    arrayString: ").append(toIndentedString(arrayString)).append("\n");
    sb.append("    arrayStringNullable: ").append(toIndentedString(arrayStringNullable)).append("\n");
    sb.append("    stringNullable: ").append(toIndentedString(stringNullable)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

