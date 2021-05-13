package com.example.demo.auth.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{

    private static final String[] publicResources = new String[]{ "/registro/nuevo-usuario/rol/**", "/roles" };
    private static final String[] userResources = new String[]{ "/usuario/**", "/registro/nuevo-rol/**",
            "/mi-rol-id", "/mis-cursos" };
    private static final String[] adminResources = new String[]{ "/admin/**" };
    private static final String[] clientResources = new String[]{ "/cliente/**" };

    @Override
    public void configure( HttpSecurity httpSecurity ) throws Exception{
        httpSecurity
                .authorizeRequests( )
                .antMatchers( publicResources ).permitAll( )
                .antMatchers( userResources ).authenticated( )
                .antMatchers( adminResources ).hasAuthority( "ROLE_ADMIN" )
                .antMatchers( clientResources ).hasAuthority( "ROLE_CLIENTE" )
                .and( ).cors( ).disable( );
    }

}