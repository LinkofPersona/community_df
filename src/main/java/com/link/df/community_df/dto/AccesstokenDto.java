package com.link.df.community_df.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Data

@AllArgsConstructor
public class AccesstokenDto {
    private String  client_id;
    private String  client_secret;
    private String  code;
    private String  redirect_uri;
    private String  state;

    public AccesstokenDto() {
    }
}
