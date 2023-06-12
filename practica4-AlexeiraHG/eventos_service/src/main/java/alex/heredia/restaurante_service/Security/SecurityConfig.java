package alex.heredia.restaurante_service.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Definicion de usuarios para la api
    @Bean
    public UserDetailsService userDetailsService() {

        // declaracion del manager de la info de usuarios en memorio
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        // crea usuario "alex" con contraseña ("{noop}" para que se guarde la contraseña
        // sin cifrado) y le da el rol de "USER"
        manager.createUser(User.withUsername("alex")
                .password("{noop}" + "user1234")
                .roles("USER")
                .build());

        // crea usuario "juanma" con contraseña ("{noop}" para que se guarde la
        // contraseña
        // sin cifrado) y le da el rol de "USER" y de "ADMIN"
        manager.createUser(User.withUsername("juanma")
                .password("{noop}" + "admin1234")
                .roles("USER", "ADMIN")
                .build());

        return manager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()

                // autoriza metodo delete solo para usuarios admin dentro de todas las entidades
                .antMatchers(HttpMethod.DELETE)
                .hasRole("ADMIN")

                // solo usuarios admin entran a ingredientes
                .antMatchers("/api/ingredientes/**")
                .hasAnyRole("ADMIN")

                // tanto usuarios con rol user como admin pueden acceder a cualquier cosa dentro
                // de menus
                .antMatchers("/api/menus/**")
                .hasAnyRole("ADMIN", "USER")

                // solo usuarios admin entran a ingredientes
                .antMatchers("/api/ordenes/**")
                .hasAnyRole("ADMIN")

                // tanto usuarios con rol user como admin pueden acceder a cualquier cosa dentro
                // de platos
                .antMatchers("/api/platos/**")
                .hasAnyRole("ADMIN", "USER")

                .antMatchers("/login/**")
                .anonymous()

                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();

    }
}
