package com.link.df.community_df.controller;

import com.link.df.community_df.dto.AccesstokenDto;
import com.link.df.community_df.dto.GithubUser;
import com.link.df.community_df.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,@RequestParam(name = "state") String state){
        AccesstokenDto accesstokenDto = new AccesstokenDto();
        accesstokenDto.setCode(code);
        accesstokenDto.setClient_id("e2ee3bdf0fc1c697c4f3");
        accesstokenDto.setClient_secret("3f7043bbae385234fd50fee0c54d7d6800cc8a8e");
        accesstokenDto.setState(state);
        accesstokenDto.setRedirect_uri("http://localhost:8887/callback");
        String accessTokenDto = githubProvider.getAccessTokenDto(accesstokenDto);
        GithubUser user = githubProvider.getUser(accessTokenDto);
        System.out.println(user.getName());
        return "index";
    }
}
