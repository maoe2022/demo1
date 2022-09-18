package com.example.demo1.repositories;

import com.example.demo1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
        User findByEmail(String email);
        // Se puede agregar cuantas funciones se requiran. Puesto, que el repositorio solo puede buscar por id. Sin embargo, se puede estender su funcionalidad con la funcion findByEmail
        //Para este caso se usa la función findBy segida del la propiedad email ubicada en la entities User y sus correspondienetes parametreos String email y asi se puede implementar esta fucnión en cualquier servicio utilizado por el repositorio
}
