package br.com.projeto.persistencia.validacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Chave {
    
    boolean requerido(); 
    String campo();
    boolean fk() default false;
    String mensagemRequerido() default "O Chave não pode ser vazio: ";
}
