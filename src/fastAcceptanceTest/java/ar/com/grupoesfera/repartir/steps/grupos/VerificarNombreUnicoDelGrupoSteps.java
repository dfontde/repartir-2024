package ar.com.grupoesfera.repartir.steps.grupos;

import ar.com.grupoesfera.repartir.steps.FastCucumberSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

import java.util.HashSet;
import java.util.Set;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VerificarNombreUnicoDelGrupoSteps extends FastCucumberSteps {

    private Set<String> nombresGrupo = new HashSet<>();
    private boolean nombreEsUnico;
    private String nuevoNombre;

    @Cuando("un grupo crea como nombre {string}")
    public void unGrupoCreaComoNombre(String nombre)
    {
        nuevoNombre = nombre.toLowerCase();
    }

    @Y("se verifica si el nombre no pertenece a otro grupo")
    public void seVerificaSiElNombreNoPerteneceAOtroGrupo()
    {
        nombreEsUnico = !nombresGrupo.contains(nuevoNombre);
    }

    @Entonces("el nombre del grupo es aceptado")
    public void elNombreDelGrupoEsAceptado()
    {
        assertThat(nombreEsUnico).isTrue();
        nombresGrupo.add(nuevoNombre);
    }

    @Dado("existe un grupo con el nombre {string}")
    public void existeUnGrupoConElNombre(String nombre)
    {
        nombreEsUnico = nombresGrupo.contains(nombre.toLowerCase());
        assertThat(nombreEsUnico).isFalse();
    }
    @Cuando("un grupo intenta crear como nombre {string}")
    public void unGrupoIntentaCrearComoNombre(String nombre)
    {
        nuevoNombre = nombre.toLowerCase();
    }

    @Entonces("el nombre del grupo no es aceptado")
    public void elNombreDelGrupoNoEsAceptado()
    {
        assertThat(nombreEsUnico).isFalse();
        nuevoNombre = null;
    }

    @Dado("otro grupo crea como nombre {string}")
    public void otroGrupoCreaComoNombre(String nombre)
    {
        nuevoNombre = nombre.toLowerCase();
    }
    @Cuando("se verifica si el nombre es similar a otro grupo")//insensible a mayúsculas/minúsculas
    public void seVerificaSiElNombreEsSimilaraAOtroGrupo()
    {
        nombreEsUnico = nombresGrupo.contains(nuevoNombre.toLowerCase());
        assertThat(nombreEsUnico).isFalse();
    }

    @Entonces("el nombre del grupo es rechazado")
    public void elNombreDelGrupoEsRechazado()
    {
        assertThat(nombreEsUnico).isFalse();
        nuevoNombre = null;
    }
}
