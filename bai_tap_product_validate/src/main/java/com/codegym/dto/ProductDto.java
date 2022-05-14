package com.codegym.dto;

import com.codegym.model.Category;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ProductDto implements Validator {
    private Integer idProduct;

    @NotEmpty(message = "{empty.invalid}")
    @NotBlank(message = "{blank.invalid}")
    @Pattern(regexp = "^([\\w]*[\\s]*[\\w]*[-]*)+$", message = "{char.invalid}")
    private String codeProduct;
    @NotEmpty(message = "{empty.invalid}")
    @NotBlank(message = "{blank.invalid}")
    @Pattern(regexp = "^([\\w]*[\\s]*[\\w]*[-]*)+$", message = "{char.invalid}")
    private String nameProduct;
    @NotEmpty(message = "{empty.invalid}")
    @NotBlank(message = "{blank.invalid}")
    @Pattern(regexp = "^([1-9][\\d]+)|([1-9][\\d]+[.]\\d+)$", message = "{number.invalid}")
    private String price;
    @NotEmpty(message = "{empty.invalid}")
    @NotBlank(message = "{blank.invalid}")
    @Pattern(regexp = "^([\\w]*[\\s]*[\\w]*[-]*)+$", message = "{char.invalid}")
    private String description;
    @NotEmpty(message = "{empty.invalid}")
    @NotBlank(message = "{blank.invalid}")
    @Pattern(regexp = "^([\\w]*[\\s]*[\\w]*[-]*)+$", message = "{char.invalid}")
    private String manufacture;
    private Category category;

    public ProductDto() {
    }

    public ProductDto(Integer idProduct, String codeProduct, String nameProduct, String price,
                      String description, String manufacture, Category category) {
        this.idProduct = idProduct;
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.description = description;
        this.manufacture = manufacture;
        this.category = category;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
