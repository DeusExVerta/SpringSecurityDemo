package com.Howard.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class UserDTO {
	private Long id;
    @NotEmpty
    private @NonNull String firstName;
    @NotEmpty
    private @NonNull String lastName;
    @NotEmpty(message = "Email should not be empty")
    @Email
    private @NonNull String email;
    @NotEmpty(message = "Password should be empty")
    private @NonNull String password;
}
