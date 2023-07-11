package com.pdai.springboothelloworld.entity;

import com.pdai.springboothelloworld.validation.AddValidationGroup;
import com.pdai.springboothelloworld.validation.ListValidationGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor

public class User {
    @NotNull(message = "could not be null", groups = {AddValidationGroup.class})
    private Integer userId;

    @NotEmpty(message = "could not be empty", groups = {AddValidationGroup.class})
    @Length(min = 1, max = 10, message = "user name should be 1-10", groups = {AddValidationGroup.class})
    private String userName;
}
