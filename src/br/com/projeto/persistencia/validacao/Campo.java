
package br.com.projeto.persistencia.validacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Campo {
    
    int tamanho();
    boolean requerido();
    String formato() default "";
    String mensagemTamanho() default "Não foi possível salva o campo: ";
    String mensagemRequerido() default "O campo não pode ser vazio: ";
    String mensagemFormato() default "O campo está em um formato incorreto: ";
}
